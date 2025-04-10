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
</style>
