<template>
  <div>
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
                <a @click="gotoHome" class="active"><div style="width: 80px"> 首页 </div></a>
                <a @click="gotoTag"><div style="width: 80px"> 分类 </div></a>
                <a @click="gotoCollection"><div style="width: 80px">我的收藏</div></a>
                <a @click="gotoPublish"><div style="width: 80px">发布文章</div></a>
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
  name: "header_com",
  data() {
    return {
      user: {},
      blogs: [],
      total: 0,
      pageNum: 1,
      pageSize: 5
    }
  },
  methods: {
    gotoHome() {
      //点击跳转至上次浏览页面
      // this.$router.go(-1)
      //指定跳转地址
      this.$router.push('/home')
    },
    gotoTag() {
      //点击跳转至上次浏览页面
      // this.$router.go(-1)
      //指定跳转地址
      this.$router.replace('/axios')
    },
    gotoCollection() {
      //点击跳转至上次浏览页面
      // this.$router.go(-1)
      //指定跳转地址
      this.$router.replace('/home')
    },
    gotoPublish() {
      //点击跳转至上次浏览页面
      // this.$router.go(-1)
      //指定跳转地址
      this.$router.replace('/publish')
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