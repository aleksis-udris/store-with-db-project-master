import { createApp } from 'vue';
import App from './App.vue';
import {createRouter, createWebHistory} from "vue-router";
import AddItem from './components/AddItem.vue';
import Items from './components/Items.vue';

import './style.css';
import './assets/styles/color_values.css';
import './assets/styles/button_style.css'
import './assets/styles/navbar_style.css'
import './assets/styles/pop_up_style.css'
import './assets/styles/table_style.css'

const routes = [
    {path: '/items', component: Items},
    {path: '/add-item', component: AddItem},
];

const router = createRouter({
    history: createWebHistory(),
    routes});


createApp(App).use(router).mount('#app')
