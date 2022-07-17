<template>
  <div>

    <el-form
        style="width: 30%;display:block;margin:0 auto"
         status-icon  ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="账号" >
        <el-input type="text" v-model="user.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" >
        <el-input type="password" v-model="user.password" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <el-button type="primary" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>


export default {
  name: "sign-in",
  components:{

  },
  data(){
    return{
      user: {
        username:'yt',
        password:'123'
      }
    }
  },
  methods: {
    login() {

      if (!this.user.username) {
        this.$message({
          message: "请输入用户名",
          type: "error"
        });
        return;
      }
      if (!this.user.password) {
        this.$message({
          message: "请输入密码",
          type: "error"
        });
        return;
      }
      this.axios.defaults.withCredentials = true;
      this.axios({
        method:"post",
        url:"/user/login",
        data:this.user
      }).then(res => {
        console.log(res)
        if (res.data.code === '0') {
          this.$message({
            message: "登录成功",
            type: "success"
          });
          sessionStorage.setItem("user", JSON.stringify(res.data.data));
          console.log(res.data.data)
          this.$router.push('/home')
        }
        else {
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
      })
      }
    }
}
</script>

<style scoped>

</style>