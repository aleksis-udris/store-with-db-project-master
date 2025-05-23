<!--suppress JSUnresolvedReference -->
<style scoped>
tbody {
  background: #202020;
}
thead {
  background: #202020;
}

h1 {
  margin-bottom: 50px;
  text-transform: uppercase;
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
        <th>Bar Code</th>
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
        <td>{{item.price}} €</td>
        <td>{{item.count}}</td>
        <td>{{item.bar_code}}</td>
        <td>{{item.added_to_register}}</td>
        <td> {{item.expiration}}</td>

        <td :class="{'td-bottom-right': index === items.length - 1}">
          <button @click="safeDelete(item.id)" class="table-button">Delete</button>
          <button @click="editItem(item.id)" class="table-button">Edit</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>

  <div class="pop-up-container" id="alert" v-if="tryingToDelete === true">
    <h3>Are You Sure You Want To Delete This Item?</h3>
    <button type="submit" @click="deleteItem" id="delete">Delete</button>
    <button @click="cancel" id="cancel">Cancel</button>
  </div>

  <div v-if="editableItem"  class="pop-up-container" >
    <h3>Edit Item</h3>
    <h4 v-if="errorMessage !== null" class="error-text">{{errorMessage}}</h4>
    <form @submit.prevent="updateItem">
      <input v-model="editableItem.name"/>
      <input v-model="editableItem.type"/>
      <input v-model="editableItem.price" type="number" step="0.01"/>
      <input v-model="editableItem.count" type="number"/>
      <input v-model="editableItem.bar_code">
      <button type="submit" id="confirm">Update</button>
      <button @click="cancel()" id="cancel">Cancel</button>
    </form>
  </div>
</template>

<script lang="js">
import ItemService from "../ItemService.js";

export default {
  data() {
    return {
      items: [],
      editableItem: null,
      tryingToDelete: false,
      tmpId: null,
      errorMessage: null,
    };
  },
  created() {
    this.getItems()
  },
  methods: {
    getItems() {
      ItemService.getItems().then(response => {
        this.items = response.data;
      }).catch(error => {
        this.errorMessage = error.response.data.message;
      })
    },
    deleteItem() {
        ItemService.deleteItem(this.tmpId).then(() => {
          this.tryingToDelete = false;
          this.tmpId = null;
          this.getItems();
        }).catch(error => {
          this.errorMessage = error.response.data.message;
        })
    },
    editItem(id) {
      ItemService.getItem(id).then((response) => {
        this.editableItem = response.data;
      }).catch(error => {
        this.errorMessage = error.response.data.message;
      })
    },
    updateItem() {
      this.errorMessage = null;
      ItemService.updateItem(this.editableItem).then(()=> {
        this.getItems();
        this.editableItem = null;
      }).catch(error => {
        this.errorMessage = error.response.data.message;
      })
    },
    cancel() {
      this.editableItem = null;
      this.errorMessage = null;
      this.tryingToDelete = false;
    },
    safeDelete(id) {
      this.tryingToDelete = true;
      this.tmpId = id;
    }
  },
  };
</script>
