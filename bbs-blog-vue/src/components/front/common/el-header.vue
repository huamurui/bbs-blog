<template>
  <div style="margin:0">
<!--    <el-header class="header">-->
        <div style="height: 60px;line-height: 60px; background-color: #b3d4fc">
          <el-row>
            <el-col :span="3" :offset="6">
              <div @click="gotoHome" style="color: white; font-size: 24px">
                <a >博客平台</a>
              </div>
            </el-col>
            <el-col :span="9" :default-active="'2'">
              <div style="display: flex">
                <el-menu
                    router
                    :default-active="'2'"
                    class="el-menu-demo"
                    mode="horizontal"
                    background-color="#b3d4fc"
                    text-color="#fff"
                    active-text-color="#4B0082">

                  <el-menu-item index="/home">首 页</el-menu-item>
                  <el-menu-item index="/search">搜 索</el-menu-item>
                  <el-menu-item index="/">收 藏</el-menu-item>
                  <el-menu-item index="/publish">发布文章</el-menu-item>
                </el-menu>
              </div>
            </el-col>
            <el-col :span="6" style="text-align: right; padding-right: 20px">
              <div v-if="!user.username">
                <el-button type="primary" size="mini" @click="goToLog">登录or注册</el-button>
<!--                <el-button type="primary" size="mini" @click="location.href = '/page/end/register.html'">注册</el-button>-->
              </div>
              <div v-else>
                <span>{{ user.username }}</span>
                <el-button type="primary" size="mini" @click="logout">退出</el-button>
              </div>
            </el-col>
          </el-row>
        </div>
<!--    </el-header>-->
  </div>
</template>

<script>
export default {
  name: "el-header",
  data() {
    return {
      user: {},
      blogs: [],
      total: 0,
    }
  },
  created:{
    log(){
      this.user = sessionStorage.getItem("user");
      JSON.parse(JSON.stringify(this.user))
      console.log(this.user)
      console.log(this.user.username)
    }
  },
  methods: {
    gotoHome() {
      //点击跳转至上次浏览页面
      // this.$router.go(-1)
      //指定跳转地址
      this.$router.push('/home')
    },
    goToLog(){
      this.$router.replace('/log')
    }
  }
}
</script>

<style scoped>
  /*.header{*/
  /*  background-color: #4169E1;*/
  /*  color:#fff;*/
  /*  line-height: 80px;*/
  /*  justify-content: space-between;*/
  /*  display: flex;*/
  /*}*/
</style>