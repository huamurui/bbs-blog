<template>
    <!-- 富文本 -->
    <div>
      <editor v-model="content" :init="init"></editor>
    </div>
</template>

<script>
import tinymce from 'tinymce/tinymce';
import Editor from '@tinymce/tinymce-vue';
import 'tinymce/themes/silver/theme';
import "tinymce/icons/default/icons";
import 'tinymce/plugins/link';
import 'tinymce/plugins/code';
import 'tinymce/plugins/table';
import 'tinymce/plugins/lists';
// import 'tinymce/plugins/contextmenu';
import 'tinymce/plugins/wordcount';
// import 'tinymce/plugins/colorpicker';
// import 'tinymce/plugins/textcolor';

export default {
  name: "tinymce-editor",
  components: {
    Editor
  },  props: {
    value: {
      type: String,
      default: ""
    },
    disabled: {
      type: Boolean,
      default: false
    },
    plugins: {
      type: [String, Array],
      default:
      // "preview searchreplace autolink directionality visualblocks visualchars fullscreen image link media template code codesample table charmap hr nonbreaking insertdatetime advlist lists wordcount imagetools textpattern autosave bdmap autoresize lineheight"
          "link code table lists wordcount "
    },
    toolbar: {
      type: [String, Array],
      default:
          "link code table wordcount | alignleft aligncenter alignright alignjustify outdent indent formatpainter | formatselect | fontselect | fontsizeselect | bullist numlist |"
      // "code undo redo restoredraft | cut copy paste pastetext | forecolor backcolor bold italic underline strikethrough link codesample | alignleft aligncenter alignright alignjustify outdent indent lineheight formatpainter | \
      // styleselect formatselect fontselect fontsizeselect | bullist numlist | blockquote subscript superscript removeformat | \
      // table image media charmap hr pagebreak insertdatetime | bdmap fullscreen preview"
    }
  },
  data() {
    return {
      //初始化配置
      init: {
        language_url: "/static/tinymce/langs/zh-Hans.js",
        language: "zh-Hans",
        skin_url: "/static/tinymce/skins/ui/oxide",
        content_css: '/static/tinymce/skins/content/document/content.css',
        height: 780,
        min_height: 780,
        max_height: 780,
        object_resizing: false, //禁用表格内联样式拖拽拉伸
        table_resize_bars:false,//禁用表格单元格拖拽拉伸
        toolbar_mode: "wrap",
        plugins: this.plugins,
        toolbar: this.toolbar,
        content_style: "p {margin: 5px 0;}",//内容样式
        fontsize_formats: "12px 14px 16px 18px 24px 36px 48px 56px 72px",
        font_formats:
            "微软雅黑=Microsoft YaHei,Helvetica Neue,PingFang SC,sans-serif;苹果苹方=PingFang SC,Microsoft YaHei,sans-serif;宋体=simsun,serif;仿宋体=FangSong,serif;黑体=SimHei,sans-serif;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;",
        branding: false,//不显示富文本支持方
        contextmenu: "undo redo | cut copy paste pastetext | selectall table", // 富文本右键菜单
      },
      content: this.value
    };
  },
  mounted() {
    tinymce.init({});
  },
  methods: {

  },
  watch: {
    value(newValue) {
      this.content = newValue;
    },
    content(newValue) {
      this.$emit("input", newValue);
    }
  }
}
</script>

<style scoped>

</style>