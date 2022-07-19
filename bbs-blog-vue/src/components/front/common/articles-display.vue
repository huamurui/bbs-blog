<template>
  <div>
  <div style="padding: 20px; border-bottom: 1px solid #ccc" v-for="item in blogs" :key="item.id">
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
        <div v-if="item.cover" style="padding: 10px">
          <el-image :src="item.cover" style="width: 100px; height: 100px"></el-image>
        </div>
      </el-col>
    </el-row>
  </div>
  </div>
</template>

<script>
export default {
  name: "articles-display",
  props: {
    blogs: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  data() {
    return {
      user: {},
      total: 0,
      // categorys:[],
    }
  },
  mounted() {
    this.load()
  },
  methods: {
    load(){
      console.log(this.blogs)
    },
    jump(obj) {
      obj.readCount = obj.readCount + 1;
      console.log(obj.id)
      this.$router.push({
        path: '/detail',
        name: 'detail_com',
        //要传参还得加上name...
        params: {
          id: obj.id
        }
      })
    },
  }

}
</script>

<style scoped>

</style>