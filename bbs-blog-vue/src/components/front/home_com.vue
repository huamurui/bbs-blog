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

          <div style="padding: 20px; border-bottom: 1px solid #ccc" v-for="item in blogs" :key="item.name">
            <el-row>
              <el-col :span="18">
                <div style="font-size: 20px"><b style="cursor: pointer" @click="jump(item)">{{ item.title }}</b></div>
                <div style="padding: 20px 0; color: #888; margin-top: 20px">{{ item.description }}</div>
                <div style="color: #888; margin-top: 20px">
                  <div>
                    <span><i class="el-icon-user"></i> {{ item.username }}</span>
                    <span style="margin-left: 20px"><i class="el-icon-date"></i> {{ item.time }}</span>
                    <span style="margin-left: 20px"><i class="el-icon-reading"></i> {{ item.readCount }}</span>
                  </div>
                </div>
              </el-col>
              <el-col :span="6">
                <div style="padding: 10px">
<!--                  <el-image :src="item.cover" style="width: 100px; height: 100px"></el-image>-->
                </div>
              </el-col>
            </el-row>
          </div>

        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import Header_com from "@/components/front/common/header_com";

export default {
  name: "home_com",
  components: {
    'app-header':Header_com,
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
    jump(obj) {
      obj.readCount = obj.readCount + 1;
        // location.href = "/detail"+obj.id;
        console.log(obj.id)

      this.$router.push({
        path:'/detail',
        name:'detail_com',
        //要传参还得加上name...
        params:{
          id:obj.id
        }
      })
    },


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