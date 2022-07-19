<template>
  <div>
    <app-header></app-header>
    <el-form round ref="form" label-width="80px" style="background-color: #ffffff;width: 60%;display:block;margin:0 auto">
      <el-form-item label="文章标题">
        <el-input style="width: 40%;" v-model="yourContent.title"></el-input>
      </el-form-item>
      <el-form-item label="文章概要">
        <el-input style="width: 40%;" type="textarea" v-model="yourContent.description"></el-input>
      </el-form-item>
      <el-form-item label="文章分类" style="display:block;margin:0 auto">
        <el-select v-model="yourContent.category" placeholder="请选择">
          <el-option
              v-for="item in categorys"
              :key="item.name"
              :label="item.name"
              :value="item.name">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="封面" label-width="50px">
        <el-upload
            class="upload-demo"
            action="http://localhost:9999/files/upload"

            :on-success="successUpload"
            list-type="picture">
          <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
      </el-form-item>
    </el-form>

    <app-editor style="width: 60%;display:block;margin:0 auto" v-model="yourContent.content"></app-editor>

    <el-button @click="save" type="primary" style="display:block;margin:0 auto">发表文章</el-button>
  </div>

</template>

<script>
import Header_com from "@/components/front/common/el-header";
import tinymceEditor from "@/components/front/common/tinymce-editor";

export default {
  name: "publish_com",
  components: {
    'app-header': Header_com,
    'app-editor':tinymceEditor
  },
  data(){
    return{
      yourContent:{
        title:'这个是标题',
        description:'这个是文章简述',
        content:'',
      },
      categorys: [],
    }
  },
  methods:{
    successUpload(res) {
      this.yourContent.cover = "http://localhost:9999/files/" + res.data;
      console.log(res)
    },

    save() {
      this.axios.defaults.withCredentials = true;
      console.log(this.user)
      this.axios({
        url:"artical/",
        method:"post",
        data:this.yourContent,
      }).then(res => {
        if (res.data.code === '0') {
          this.$message({
            message: "提交成功",
            type: "success"
          });
          this.$router.replace('/home')
        } else {
          console.log(res)
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
        this.dialogFormVisible = false;
      })
    }
  },
  mounted() {
    this.user = sessionStorage.getItem("user");
    this.axios({
      url:'category',
      method:'get'
    }).then(res=>{
      console.log(res.data.data);
      this.categorys=res.data.data;
    })
  }

}
</script>

<style scoped>

</style>