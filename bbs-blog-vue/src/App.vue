<template>
  <div id="app" >
    <router-view></router-view>
    <br>    <br>    <br>    <br>    <br>
    <div>
    <el-button type="primary" round @click="goTo"  style="width:20%;display:block;margin:0 auto">Go to</el-button>
    </div>
  </div>
</template>

<script>


export default {
  name: 'App',
  methods:{
    goTo(){
      this.$router.push('/home')
    }
  }
}
</script>

<style>
html,body,#app{
  height: 100%;
  background-color: #B0C4DE
}
</style>
