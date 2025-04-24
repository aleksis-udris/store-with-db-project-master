<template>
  <h1>Add an Item</h1>
  <h2 class="error-text" v-if="errorMessage !== null">{{errorMessage}}</h2>
  <div>
    <form @submit.prevent="addItem">
      <input v-model="item.name" placeholder="Name">
      <input v-model="item.type" placeholder="Type">
      <input v-model="item.bar_code" placeholder="Bar Code">
      <div class="container">
        <input class="number-input" v-model="item.price" placeholder="Price" type="number" step="0.01">

        <input class="number-input" v-model="item.count" placeholder="Count" type="number">

        <input class="input-date" v-model="item.expiration" type="date" value="2025-02-27">
      </div>
      <button class="submit-btn" type="submit">Add</button>
    </form>
  </div>
</template>

<style scoped>
  h1 {
    text-transform: uppercase;
  }

  button {
    text-transform: uppercase;
  }
</style>

<script lang="js">

import ItemService from "../ItemService.js";

export default {
  data() {
    return {
      item: {
        name: '',
        type: '',
        price: 0.00,
        count: 0,
        bar_code: '',
        date: ''
      },
      errorMessage: null,
    };
  },
  methods: {
    addItem() {
      this.errorMessage = null;
      ItemService.addItem(this.item).then(() => {
        this.item.name = '';
        this.item.type = '';
        this.item.price = 0.00;
        this.item.count = 0;
        this.item.bar_code = '';
        this.item.date = '';
      }).catch((error) => {
        this.errorMessage = error.response.data.message;
      })
    }
  }
};
</script>