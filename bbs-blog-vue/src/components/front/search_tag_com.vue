<template>
  <div>
  <app-header></app-header>
    <el-row style="margin-top: 20px">
      <el-col :span="12" :offset="6">
        <el-card>
          <div style="display: block ;margin:0 auto;width: 80%">
            <div style="display: flex">
              <el-input v-model="searchByWord" placeholder="请输入内容" @keyup.enter.native="loadTable"></el-input>
              <a>  </a>
              <el-button @click="loadTable" type="primary">搜索</el-button>
            </div>
          </div>
          <!--                    分割线-->
          <div style="height: 1px; margin: 10px 0; background-color: #ccc"></div>
<!--          <div style="display: flex; margin:0 auto;width: 80%">-->
<!--            <div style="color: dodgerblue; font-size: 20px; flex: 1">分类</div>-->
<!--            <div class="category" @click="select(item.name)" v-for="item in categorys" :key="item.id" :class="{ categoryActive: item.name === index }">{{ item.name }}</div>-->
<!--          </div>-->
        </el-card>
        <el-card style="min-height: 800px; margin-top: 20px; position: relative">
          <div style="flex: 1; text-align: right">共 <span style="font-size: 20px; color: orange">{{total}}</span> 条</div>

          <app-articles :blogs="this.blogs"></app-articles>

        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import Header_com from "@/components/front/common/el-header";
import articlesDisplay from "@/components/front/common/articles-display";

export default {
  name: "search_tag_com",
  components:{
    'app-header':Header_com,
    'app-articles':articlesDisplay
  },
  data(){
    return{
      user: {},
      // blogs: [],
      total: 0,
      // categorys:[],
      searchByWord:'这样能搜吗'
    }
  },
  methods:{
    loadTable() {
      this.axios({
        url:'/artical/search',
        method:"get",
        params:{
          keyword :this.searchByWord
        }
      }).then(response=>{
        // console.log(response.data)
        this.blogs=response.data
        this.total=this.blogs.length
      })
    },
    select(category) {
      this.index = category;
      this.loadTable();
    },

  },
  created() {
  this.loadTable();
  },
  // mounted() {
  //   this.user = sessionStorage.getItem("user");
  //   this.axios({
  //     url:'/category',
  //     method:'get'
  //   }).then(res=>{
  //     console.log(res.data.data);
  //     this.categorys=res.data.data;
  //     this.index = res.data.data[0].name;
  //   })
  // }
}
</script>

<style scoped>

</style>