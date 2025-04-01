<template>
  <div>
    <form @submit.prevent="addItem">
      <input class="input-normal" v-model="item.name" placeholder="Name">
      <input class="input-normal" v-model="item.type" placeholder="Type">
      <div class="container">
        <input class="number-input" v-model="item.price" placeholder="Price" type="number" step="0.01">

        <input class="number-input" v-model="item.count" placeholder="Count" type="number">

        <input class="input-date" v-model="item.expiration" type="date" value="2025-02-27">
      </div>
      <button class="submit-btn" type="submit"> Add Item</button>
    </form>
  </div>
</template>

<style scoped>
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
        date: ''
      }
    };
  },
  methods: {
    addItem() {
      ItemService.addItem(this.item).then(() => {
        this.item.name = '';
        this.item.type = '';
        this.item.price = 0.00;
        this.item.count = 0;
        this.item.date = '';
      });
    }
  }
};
</script>