<script setup lang="ts">
</script>

<template>
  <div>
    <nav class="header">
      <button @click="$router.push('/items')">Item List</button>
      <button @click="$router.push('/add-item')">Add an Item</button>
    </nav>
  </div>
  <div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
  div {
    padding: 10px;
    margin-bottom: 10em;
  }
  button {
    margin-left: 5px;
    margin-right: 5px;
    background: #5d7364;
    outline: none;
  }
  button:hover {
    box-shadow: 5px 5px 10px #4a5c4e,
    -5px -5px 10px #6d8172;
    opacity: 0.8;
    outline: none;
  }

</style>
