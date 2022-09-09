import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Instituciones from '../views/InstitucionesView.vue'
import InstitucionesEdit from '../views/InstitucionesEditView.vue'
import InstitucionesCreateView from '@/views/InstitucionesCreateView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/instituciones',
    name: 'instituciones',
    component: Instituciones
  },
  {
    path: '/institucionesEdit/:id',
    name: 'institucionesEdit',
    component: InstitucionesEdit
  },
  {
    path: '/instituciones-crear/',
    name: 'instituciones-crear/',
    component: InstitucionesCreateView
  }
]
const router = new VueRouter({
  routes
})

export default router
