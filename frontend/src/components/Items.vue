<!--suppress JSUnresolvedReference -->
<style scoped>
.table-button {
  margin-left: 1px;
  margin-right: 1px;
}

table {
  box-shadow:
      5px 0 30px #202020,
      -5px 0 30px #202020,
      0 -5px 30px #202020,
      0 5px 30px #202020;
  border-radius: 10px;
  padding: 2px;
}
tbody {
  background: #202020;
}
thead {
  background: #202020;
}

h1 {
  margin-bottom: 50px;
}

.th-top-right {
  border-top-right-radius: 10px;
}

.th-top-left {
  border-top-left-radius: 10px;
}

.td-bottom-right {
  border-bottom-right-radius: 10px;
}

.td-bottom-left {
  border-bottom-left-radius: 10px;
}
</style>

<template>
  <h1>Item List</h1>
  <div>
    <table>
      <thead>
      <tr>
        <th class="th-top-left">Name</th>
        <th>Type</th>
        <th>Price</th>
        <th>Count</th>
        <th>Date When Added</th>
        <th>Expiration Date</th>
        <th class="th-top-right">Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item, index) in items"
          :key="index"
          :class="{'last-row': index === items.length - 1}">

        <td :class="{'td-bottom-left': index === items.length - 1}">
          {{item.name}}
        </td>

        <td>{{item.type}}</td>
        <td>{{item.price}}</td>
        <td>{{item.count}}</td>
        <td>{{item.added_to_register}}</td>
        <td> {{item.expiration}}</td>

        <td :class="{'td-bottom-right': index === items.length - 1}">
          <button @click="deleteItem(item.id)" class="table-button">Delete</button>
          <button @click="editItem(item.id)" class="table-button">Edit</button>
        </td>
      </tr>
      </tbody>
    </table>

  </div>
  <div v-if="editableItem">
    <h3>Edit Item</h3>
    <form @submit.prevent="updateItem">
      <input v-model="editableItem.name"/>
      <input v-model="editableItem.type"/>
      <input v-model="editableItem.price" type="number" step="0.01"/>
      <input v-model="editableItem.count" type="number"/>
      <input v-model="editableItem.expiration" type="date" value="2025-03-26"/>
      <button type="submit">Update</button>
    </form>
  </div>
</template>

<script lang="js">
import ItemService from "../ItemService.js";

export default {
  data() {
    return {
      items: [],
      editableItem: null
    };
  },
  created() {
    this.getItems()
  },
  methods: {
    getItems() {
      ItemService.getItems().then(response => {
        this.items = response.data;
      });
    },
    deleteItem(id) {
      ItemService.deleteItem(id).then(() => {
        this.getItems();
      })
    },
    editItem(id) {
      ItemService.getItem(id).then((response) => {
        this.editableItem = response.data;
      })
    },
    updateItem() {
      ItemService.updateItem(this.editableItem).then(()=> {
        this.getItems();
        this.editableItem = null;
      })
    }
  },
  };
</script>
