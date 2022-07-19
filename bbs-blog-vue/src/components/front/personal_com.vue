<template>
<div>
  <el-card style="min-height: 800px; margin-top: 20px; position: relative">
    <div style="flex: 1; text-align: right">共 <span style="font-size: 20px; color: orange">{{total}}</span> 条</div>

    <app-articles :blogs="this.blogs"></app-articles>

  </el-card>
</div>
</template>

<script>
import articlesDisplay from "@/components/front/common/articles-display";

export default {
  name: "personal_com",
  components:{
    'app-articles':articlesDisplay
  },
  data(){
    return{
      user: {},
      total: 0,
    }
  },
  methods:{
    loadTable() {
      console.log(this.$route.params.username)
      this.axios({
        url:'/artical/personal',
        method:"get",
        params:{
          thename :this.$route.params.username
        }
      }).then(response=>{
        console.log(response.data)
        this.blogs=response.data
        this.total=this.blogs.length
      })
    },
  },
  created() {
    this.loadTable();
  },
}
</script>

<style scoped>

</style>