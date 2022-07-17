<template>
  <div>

    <br>    <br>    <br>    <br>
    <el-menu
        style="width: 45%;display:block;margin:0 auto"
        router
        :default-active="'2'"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#b3d4fc"
        text-color="#fff"

        active-text-color="#4B0082">
      <el-menu-item index="/log/sign-in" style="width: 50%; text-align: center;font-size: 20px;font-family:'Microsoft YaHei UI Light'">  登 录  </el-menu-item>
      <el-menu-item index="/log/sign-up" style="width: 50%; text-align: center;font-size: 20px;font-family:'Microsoft YaHei UI Light'">  注 册  </el-menu-item>
    </el-menu>
    <br>    <br>
    <router-view></router-view>
    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>    <br>
  </div>
</template>

<script>
export default {
  name: "log_com",
  components:{
  },
  methods:{
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  }
}
</script>

<style scoped>
div{
  font-family: "Microsoft YaHei"
}
</style>