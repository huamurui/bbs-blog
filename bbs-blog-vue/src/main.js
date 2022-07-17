import Vue from 'vue'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from "./router/index"
import "font-awesome/css/font-awesome.min.css"
import axios from "axios"


import App from './App.vue'

Vue.use(ElementUI);
Vue.prototype.axios= axios;
// Vue.prototype.service = service
Vue.config.productionTip = false
axios.defaults.baseURL = 'http://localhost:9999/api/'
// axios.defaults.withCredentials = true;
new Vue({
  axios,
  router,
  render: h => h(App),
}).$mount('#app')
