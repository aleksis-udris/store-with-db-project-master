<style scoped>
.table-button {
  margin-left: 1px;
  margin-right: 1px;
}
</style>

<template>
  <h1>Item List</h1>
  <div>
    <table>
      <thead>
      <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Price</th>
        <th>Count</th>
        <th>Date When Added</th>
        <th>Expiration Date</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in items">
        <td>{{item.name}}</td>
        <td>{{item.type}}</td>
        <td>{{item.price}}</td>
        <td>{{item.count}}</td>
        <td>{{item.added_to_register}}</td>
        <td>{{item.expiration}}</td>
        <td>
          <button @click="deleteItem(item.id)" class="table-button">Delete</button>
          <button @click="editItem(item.id)" class="table-button">Edit</button>
          <button @click="$router.push('/item/' + item.id)">View</button>
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
