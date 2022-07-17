<template>
  <div>
    <app-header></app-header>
  <h2>test</h2>
  <button @click="demo">lalala</button>
  </div>
</template>

<script>
import elHeader from "@/components/front/common/el-header";

export default {
  name: "axios_test",
  components:{
    'app-header':elHeader
  },
  methods:{
    demo() {
      this.axios.get("http://localhost:9999/api/artical/12", {
      }).then(res => {
        console.log(res);
      }).catch(function (err) {
        console.log(err)
      });
    },
  }
}
</script>

<style scoped>

</style>