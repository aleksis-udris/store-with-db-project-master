import { createApp } from 'vue';
import './style.css';
import App from './App.vue';
import {createRouter, createWebHistory} from "vue-router";
import AddItem from './components/AddItem.vue';
import Item from './components/Item.vue';
import ItemView from './components/ItemView.vue';

const routes = [
    {path: '/items', component: Item},
    {path: '/add-item', component: AddItem},
    {path: '/item/:id', component: ItemView},
];

const router = createRouter({
    history: createWebHistory(),
    routes});


createApp(App).use(router).mount('#app')
