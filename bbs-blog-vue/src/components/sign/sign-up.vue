<template>
  <div>

    <el-form
        style="width: 30%;display:block;margin:0 auto"
        :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名">
        <el-input ></el-input>
      </el-form-item>
      <el-form-item label="密码" >
        <el-input ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" >
        <el-input ></el-input>
      </el-form-item>

      <el-form-item>
        <div style="margin:0 auto;">
        <el-button >重置</el-button>
        <el-button type="primary" >提交</el-button>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  name: "sign-up",
  components:{

  }
}
</script>

<style scoped>

</style>