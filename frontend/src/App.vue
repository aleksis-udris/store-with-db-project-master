<script setup lang="ts">
</script>

<template>
  <div>
    <nav>
      <button @click="$router.push('/items')">Item List</button>
      <button @click="$router.push('/add-item')">Add an Item</button>
      <button @click="$router.push('/login')">Login</button>
    </nav>
  </div>
  <div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
  nav {
    text-align: center;
    vertical-align: top;
    position: fixed;
  }
  div {
    padding: 10px;
    margin-bottom: 10em;
  }
  button {
    margin-left: 5px;
    margin-right: 5px;
  }
</style>
