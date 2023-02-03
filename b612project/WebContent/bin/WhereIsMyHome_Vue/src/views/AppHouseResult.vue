<template>
  <div>
    <div class="position-relative">
      <!-- shape Hero -->
      <section class="section-shaped my-0">
        <div class="shape shape-style-1 shape-default shape-skew">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
        <div class="container shape-container d-flex">
          <div class="col px-0">
            <div class="row">
              <div class="col-lg-6">
                <h1 class="display-3 text-white">
                  Happy House
                  <!-- <span>지역 검색 서비스</span> -->
                </h1>
                <p class="lead text-white">지역 검색 서비스</p>
                <house-search-bar-for-result></house-search-bar-for-result>
                <!-- <div class="mx-1 mt-4 btn-wrapper">
                  <router-link to="/houseresult" class="link">
                    <base-button
                      tag="a"
                      href="https://demos.creative-tim.com/argon-design-system/docs/components/alerts.html"
                      class="mb-3 mb-sm-0"
                      type="info"
                      icon="fa fa-code"
                      style="width: 200px"
                    >
                      Find House
                    </base-button>
                  </router-link>
                </div> -->
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- 1st Hero Variation -->
    </div>
    <section class="section section-lg pt-lg-0 mt--200">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="row row-grid">
              <div
                class="col-lg-4 mt-4"
                v-for="(house, index) in houses"
                :key="index"
                :house="house"
              >
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon
                    name="ni ni-check-bold"
                    type="primary"
                    rounded
                    class="mb-4"
                  >
                  </icon>
                  <h6 class="text-primary text-uppercase">
                    {{ house.aptName }}
                  </h6>
                  <p class="description mt-3">
                    Argon is a great free UI package based on Bootstrap 4 that
                    includes the most important components and features.
                  </p>
                  <!-- <div>
                    <badge type="primary" rounded>design</badge>
                    <badge type="primary" rounded>system</badge>
                    <badge type="primary" rounded>creative</badge>
                  </div> -->
                  <base-button tag="a" href="#" type="primary" class="mt-4">
                    상세보기
                  </base-button>
                </card>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import HouseSearchBarForResult from "../components/house/HouseSearchBarForResult.vue";
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "AppHouseResult",
  data() {
    return {
      no: null,
      name: null,
      dong: null,
      floor: null,
      amount: null,
    };
  },
  components: {
    HouseSearchBarForResult,
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "dongName", "houses"]),
  },
  created() {
    // console.log(this.$store.state.houseStore.houses);
  },
};
</script>
