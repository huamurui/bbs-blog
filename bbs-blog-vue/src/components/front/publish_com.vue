<template>
  <div>
    <app-header></app-header>
    <app-editor v-model="yourContent.content"></app-editor>

    <el-button @click="save" type="primary">发表文章</el-button>
  </div>

</template>

<script>
import Header_com from "@/components/front/common/header_com";
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
        title:'lalala',
        description:'我试试能不能传',
        content:''
      }
    }
  },
  methods:{
    save() {
      // let type = this.entity.id ? "PUT" : "POST";
      // this.entity.content = tinymce.activeEditor.getContent();
      // if(!this.entity.title) {
      //   this.$message({
      //     message: '请输入文章名称',
      //     type: "warning"
      //   })
      //   return;
      // }
      // if(!this.entity.category) {
      //   this.$message({
      //     message: '请选择文章分类',
      //     type: "warning"
      //   })
      //   return;
      // }
      // if(!this.entity.content) {
      //   this.$message({
      //     message: '请输入文章内容',
      //     type: "warning"
      //   })
      //   return;
      // }


      this.axios.defaults.withCredentials = true;
      console.log(this.user)
      this.axios({
        url:"artical/",
        method:"post",
        data:this.yourContent,
        // 'artical.setUsername':'ko no dio da'
      }).then(res => {
        if (res.data.code === '0') {
          this.$message({
            message: "提交成功",
            type: "success"
          });
          // setTimeout(() => {
          //   location.href = 'artical.html';
          // }, 1000)
        } else {
          console.log(res)
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
        // this.loadTable();
        this.dialogFormVisible = false;
      })
    }
  },
  mounted() {
    this.user = sessionStorage.getItem("user");
  }

}
</script>

<style scoped>

</style>