import { createApp } from 'vue';
import './style.css';
import App from './App.vue';
import {createRouter, createWebHistory} from "vue-router";
import AddItem from './components/AddItem.vue';
import Items from './components/Items.vue';
import LogIn from './components/LogIn.vue';
import SignUp from './components/SignUp.vue';

const routes = [
    {path: '/items', component: Items},
    {path: '/add-item', component: AddItem},
    {path: '/login', component: LogIn},
    {path: '/signup', component: SignUp},
];

const router = createRouter({
    history: createWebHistory(),
    routes});


createApp(App).use(router).mount('#app')
