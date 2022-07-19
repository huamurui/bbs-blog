<template>
<div>
  <div style="display: flex">
    <div style="color: #888; font-size: 20px; flex: 1">评论</div>
  </div>
  <div style="height: 1px; margin: 10px 0; background-color: #ccc"></div>
  <!--回复框-->
  <div style="padding: 20px; color: #888">
    <div>
      <el-input type="textarea" :rows="3" v-model="entity.content"></el-input>
      <div style="text-align: right; padding: 10px"><el-button type="primary" @click="save">评论</el-button></div>
    </div>
  </div>
  <!-- 分割线-->
  <div style="height: 1px; margin: 10px 0; background-color: #ccc"></div>
  <!--        //展示评论-->
  <div style="display: flex; padding: 20px" v-for="item in comments.data" :key="item.id">
    <!--            <div  v-if="item.parentId!=null">-->
    <div style="text-align: center; flex: 1" >
      <!--              <el-image :src="item.avatar" style="width: 60px; height: 60px; border-radius: 50%"></el-image>-->
    </div>
    <div style="padding: 0 10px; flex: 5">
      <div><b style="font-size: 14px">{{ item.username }}</b></div>
      <div style="padding: 10px 0; color: #888">{{ item.content }}</div>
      <div style="background-color: #eee; padding: 10px" v-if="item.parentComment">{{ item.username }}：{{ item.parentComment.content }}</div>
      <div style="color: #888; font-size: 12px">
        <span>{{ item.time  }}</span>
        <el-button type="text" style="margin-left: 20px" @click="reReply(item.id)">回复</el-button>
      </div>

    </div>
    <!--            </div>-->
  </div>

<!--二级评论弹出框-->
  <el-dialog title="回复" v-bind:visible.sync="dialogFormVisible" width="35%"
             close-on-click-modal="false" close-on-press-escape="false" show-close="false">
    <el-form :model="entity">
      <el-form-item label="内容" label-width="20%">
        <el-input v-model="entity.reply" autocomplete="off" type="textarea" :rows="3" ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="cancel">取 消</el-button>
      <el-button type="primary" @click="reply">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
export default {
  name: "el-comments",
  data() {
    return {
      url: '',
      vis: false,
      dialogFormVisible: false,
      entity: {},
      blog: {},
      comments: [],
      collectActive: false
    }
  },
  mounted() {
    // this.user = sessionStorage.getItem("user");
    this.load();
  },
  methods:{
    load() {
      // this.axios.defaults.withCredentials = true;
      let id=this.$route.params.id
      this.axios.get("comment/artical/"+id, {
      }).then(res => {
        this.comments = res.data
        console.log(this.comments)
        // this.comments = Object.assign([],res.data).map(item=>{
        //   return Object.assign({},item)
        // })
      })
    },

    cancel() {
      this.dialogFormVisible = false;
      this.entity = {};
    },
    reReply(id) {
      this.dialogFormVisible = true;
      this.entity.parentId = id;
    },
    reply() {
      this.entity.content = this.entity.reply;
      this.save();
    },
    save() {

      // if (!this.user.username) {
      //   this.$message({
      //     message: "请登录",
      //     type: "warning"
      //   });
      //   return;
      // }
      if (!this.entity.content) {
        this.$message({
          message: "请填写内容",
          showClose: true,
          type: "warning"
        });
        return;
      }
      this.axios.defaults.withCredentials = true;
      let id=this.$route.params.id
      this.entity.acticalId = id;
      this.axios({
        method:"post",
        url:"comment",
        data:this.entity
      }).then(res => {
        if (res.data.code === '0') {
          this.$message({
            showClose: true,
            message: "评论成功",
            type: "success"
          });
        } else {
          this.$message({
            message: res.data.msg,
            type: "error"
          });
        }
        this.entity = {}
        this.load();
        this.dialogFormVisible = false;
      })
    },
  }

}
</script>

<style scoped>

</style>