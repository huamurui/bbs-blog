<template>
  <div>
    <app-header></app-header>


    <el-row style="margin-top: 20px">
      <el-col :span="12" :offset="6">
        <el-card style="min-height: 800px; position: relative">
          <div style="display: flex">
            <div style="color: forestgreen; font-size: 20px; flex: 1">最新动态</div>
            <div style="flex: 1; text-align: right">共 <span style="font-size: 20px; color: orange">{{total}}</span> 条</div>
          </div>
          <!--                    分割线-->
          <div style="height: 1px; margin: 10px 0; background-color: #ccc"></div>
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
  name: "home_com",
  components: {
    'app-header':Header_com,
    'app-articles':articlesDisplay
  },
  data(){
    return {
      user: {},
      blogs: [],
      total: 0,
    }
  },

  created() {
    this.loadTable();
  },
  methods: {
    loadTable() {
      this.axios.get("artical").then(res => {
        this.blogs = res.data.data;
        this.total= res.data.data.length;
      })
    },
  }

}
</script>

<style scoped>

</style>