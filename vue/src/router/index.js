import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import User from '../views/User.vue'
import admin from '../views/admin.vue'
import AdminPage from '../views/AdminPage.vue'
import BoardWrite from '../views/BoardWrite.vue' 
import ProductPage from '../views/ProductPage.vue'
import ProductEdit from '../views/ProductEdit.vue'
import Menu1 from '../views/Menu1.vue'
import Menu2 from '../views/Menu2.vue'
import Menu3 from '../views/Menu3.vue'
import Menu4 from '../views/Menu4.vue'
import ProductDetail2 from '../views/ProductDetail2.vue'
import OrderPage from '../views/OrderPage.vue'
import OrderCompleted from '../views/OrderCompleted.vue'
import OrderList from '../views/OrderList.vue'
import OrderTotal from '../views/OrderTotal.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/user',
    name: 'User',
    component: User
  },
  {
    path: '/admin',
    name: 'admin',
    component: admin
  },
  {
    path: '/adminpage',
    name: 'AdminPage',
    component: AdminPage
  },
  {
    path: '/boardwrite',
    name: 'BoardWrite',
    component: BoardWrite
  },
  {
    path: '/productpage',
    name: 'ProductPage',
    component: ProductPage
  },
  {
    path: '/productedit',
    name: 'ProductEdit',
    component: ProductEdit
  },
  {
    path: '/menu1',
    name: 'Menu1',
    component: Menu1
  },
  {
    path: '/menu2',
    name: 'Menu2',
    component: Menu2
  },
  {
    path: '/menu3',
    name: 'Menu3',
    component: Menu3
  },
  {
    path: '/menu4',
    name: 'Menu4',
    component: Menu4
  },
  {
    path: '/productdetail2',
    name: 'ProductDetail2',
    component: ProductDetail2
  },
  {
    path: '/orderpage',
    name: 'OrderPage',
    component: OrderPage
  },
  {
    path: '/ordercompleted',
    name: 'OrderCompleted',
    component: OrderCompleted
  },
  {
    path: '/orderlist',
    name: 'OrderList',
    component: OrderList
  },
  {
    path: '/ordertotal',
    name: 'OrderTotal',
    component: OrderTotal
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router