<template>
  <div style="background-color: white">
    <b-container class="bv-example-row mt-3">
      <b-row>
        <b-col>
          <div class="alert alert-primary" role="alert">
            <h3>글목록</h3>
          </div>
        </b-col>
      </b-row>
      <b-row class="mb-1">
        <b-col class="text-right">
          <b-button variant="outline-primary" @click="moveWrite()"
            >글쓰기</b-button
          >
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-table
            striped
            hover
            :items="articles"
            :fields="fields"
            @row-clicked="viewArticle"
          >
            <template #cell(subject)="data">
              <router-link
                :to="{
                  name: 'boardview',
                  params: { articleno: data.item.articleno },
                }"
              >
                {{ data.item.subject }}
              </router-link>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { listArticle } from "@/api/board";

export default {
  name: "BoardList",
  data() {
    return {
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "text-dark" },
        { key: "subject", label: "제목", tdClass: "text-dark" },
        { key: "userid", label: "작성자", tdClass: "text-dark" },
        { key: "regtime", label: "작성일", tdClass: "text-dark" },
        { key: "hit", label: "조회수", tdClass: "text-dark" },
      ],
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 20,
      key: null,
      word: null,
    };
    listArticle(
      param,
      ({ data }) => {
        this.articles = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "boardwrite" });
    },
    viewArticle(article) {
      this.$router.push({
        name: "boardview",
        params: { articleno: article.articleno },
      });
    },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
