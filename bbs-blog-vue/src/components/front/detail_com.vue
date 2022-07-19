<template>
  <div>
  <app-header></app-header>

  <el-row style="margin-top: 20px">
    <el-col :span="12" :offset="6">
      <el-card>
        <div style="display: flex">
          <div style="color: forestgreen; font-size: 20px; flex: 1">文章详情</div>
          <div style="text-align: right">
            <el-button size="mini" @click="vis = true"><i class="el-icon-position"></i></el-button>
            <el-button :class="{active: collectActive}" size="mini" @click="collect"><i class="el-icon-collection-tag"></i></el-button>
          </div>
        </div>
        <!--                    分割线-->
        <div style="height: 1px; margin: 10px 0; background-color: #ccc"></div>
<!--//文章内容-->
        <div style="min-height: 500px;padding: 20px; color: #888" v-html="blog.data.content"></div>

<!--评论区-->
        <el-card style="margin-top: 20px; margin-bottom: 50px">
          <app-comments></app-comments>
        </el-card>

      </el-card>
    </el-col>
  </el-row>


  </div>
</template>

<script>
import Header_com from "@/components/front/common/el-header";
import elComments from "@/components/front/common/el-comments";
export default {
  name: "detail_com",
  components: {
    'app-header':Header_com,
    'app-comments':elComments
  },
  data() {
    return {
      url: '',
      vis: false,
      entity: {},
      blog: {},
    }
  },
  mounted() {
      this.load();
  },
  methods: {
    load() {
      let id=this.$route.params.id
      // console.log(id)
      this.axios.get("artical/"+id, {
      }).then(res => {
        this.blog = res.data;
      });

    },

    collect() {
      //   $.ajax({
      //     url: '/api/collect',
      //     type: 'POST',
      //     contentType: "application/json",
      //     data: JSON.stringify({name: this.blog.title, url: 'http://localhost:9999/page/front/detail.html?id=' + this.blog.id})
      //   }).then(res => {
      //     if (res.code === '0') {
      //       this.$message({
      //         message: "收藏成功",
      //         type: "success"
      //       });
      //     } else {
      //       this.$message({
      //         message: res.msg,
      //         type: "error"
      //       })
      //     }
      //     this.loadTable();
      //     this.dialogFormVisible = false;
      //   })
    }
  },

}

</script>

<style scoped>

</style>