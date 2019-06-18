import Vue from 'vue'
import Router from 'vue-router'
import App from './App.vue'
import SeleniumForm from '@/components/SeleniumForm'
import SeleniumResults from '@/components/SeleniumResults'

Vue.config.productionTip = false

Vue.use(Router)

new Vue({
  render: h => h(App),
  router: new Router({
    routes: [
      {
            path: "/",
            redirect: {
                name: "SeleniumForm"
            }
        },
        {
            path: '/form',
            name: 'SeleniumForm',
            component: SeleniumForm
        },
        {
            path: '/results',
            name: 'SeleniumResults',
            component: SeleniumResults
        }
    ]}),
}).$mount('#app')
