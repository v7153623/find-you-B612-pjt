<template>
  <div class="btn-wrapper">
    <b-form-select
      class="mx-1"
      v-model="sidoCode"
      :options="sidos"
      @change="gugunList"
      style="width: 150px"
    ></b-form-select>
    <b-form-select
      class="mx-1"
      v-model="gugunCode"
      :options="guguns"
      @change="dongList"
      style="width: 150px"
    ></b-form-select>
    <b-form-select
      id="sel"
      class="mx-1"
      v-model="dongCode"
      :options="dongs"
      @change="searchDongApt"
      style="width: 150px"
    ></b-form-select>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

/*
  namespaced: true를 사용했기 때문에 선언해줍니다.
  index.js 에서 modules 객체의 '키' 이름입니다.

  modules: {
    키: 값
    memberStore: memberStore,
    houseStore: houseStore
  }  
*/
const houseStore = "houseStore";

export default {
  name: "HouseSearchBarForResult",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "houses"]),
  },
  created() {
    // this.CLEAR_SIDO_LIST();
    // this.CLEAR_APT_LIST();

    this.sidoCode = this.sidos[this.$store.state.idxSido].value;
    this.gugunCode = this.guguns[this.$store.state.idxGugun].value;
    this.dongCode = this.dongs[this.$store.state.idxDong].value;

    this.getSido();
  },
  methods: {
    ...mapActions(houseStore, [
      "getSido",
      "getGugun",
      "getDong",
      "getDongName",
      "getHouseList",
      "getDongHouseList",
    ]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_APT_LIST",
    ]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      console.log(`gugunCode: ${this.gugunCode}`);
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchApt() {
      if (this.gugunCode) this.getHouseList(this.gugunCode);
    },
    searchDongApt() {
      console.log("searchApt 실행");
      console.log(`dongCode: ${this.dongCode}`);
      if (this.dongCode) this.getDongHouseList(this.dongCode);
    },
    dongName() {
      if (this.dongCode) {
        let idx = document.getElementById("sel").selectedIndex;
        this.getDongName(this.dongs[idx].text);
      }
    },
  },
};
</script>

<style></style>
