<template>
  <div>
    <h1>{{item.name}}</h1>
  </div>
</template>

<!--suppress ThisExpressionReferencesGlobalObjectJS -->
<script setup>
</script>

<script>
    import ItemService from "../ItemService.js";

    export default {
      data() {
        return {
          item: ItemService.getItem(parseInt(id))
        }
      }
    }
</script>

<style scoped>

</style>