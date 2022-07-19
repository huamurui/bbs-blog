import Vue from "vue";
import Router from "vue-router"
// import {Main} from "element-ui";



import home_com from "@/components/front/home_com";
import detail_com from "@/components/front/detail_com";
import publish_com from "@/components/front/publish_com";

import log_com from "@/components/sign/log_com";
import sign_up from "@/components/sign/sign-up";
import sign_in from "@/components/sign/sign-in";
import search_tag_com from "@/components/front/search_tag_com";

Vue.use(Router);

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}
export default new Router({
    routes:[
        // {path:"/",name:"Main",component:Main},
        {path:"/home",name:"home_com",component:home_com},
        {path:"/detail",name:"detail_com",component:detail_com},
        {path:"/publish",name:"publish_com",component:publish_com},
        {path:"/search",name:"search_tag_com",component:search_tag_com},
        {path:"/log",name:"log_com",component:log_com,
            children:[
                {path:"/log/sign-up",name:"sign-up",component:sign_up},
                {path:"/log/sign-in",name:"sign-in",component:sign_in}
            ]
        }
    ],
    mode:"history"
});