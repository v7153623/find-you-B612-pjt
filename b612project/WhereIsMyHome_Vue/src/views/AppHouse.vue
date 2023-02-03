<template>
  <div>
    <div class="position-relative">
      <!-- shape Hero -->
      <section
        class="section-shaped my-0"
        style="
          background-image: url('img/theme/prince1.png');
          background-repeat: no-repeat;
          background-position: 100% 0%;
          background-size: 100% 100%;
        "
      >
        <div class="shape shape-style-1 shape-default shape-skew" v-show="false">
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
                  B612
                  <span>집을 찾는 새로운 방식</span>
                </h1>
                <p class="lead text-white">
                  지역을 고르고 주변의 집 정보를 모아보세요! 다양한 서비스를
                  누릴 수 있어요.
                </p>
                <house-search-bar></house-search-bar>
                <div class="mx-1 mt-4 btn-wrapper">
                  <router-link to="/houseresult" class="link">
                    <base-button
                      tag="a"
                      href="https://demos.creative-tim.com/argon-design-system/docs/components/alerts.html"
                      class="mb-3 mb-sm-0"
                      type="info"
                      icon="fa fa-code"
                      style="width: 200px"
                      @click="setInfo"
                    >
                      Find House
                    </base-button>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- 1st Hero Variation -->
    </div>
    <!-- <section class="section section-lg pt-lg-0 mt--200">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="row row-grid">
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon
                    name="ni ni-check-bold"
                    type="primary"
                    rounded
                    class="mb-4"
                  >
                  </icon>
                  <h6 class="text-primary text-uppercase">Download Argon</h6>
                  <p class="description mt-3">
                    Argon is a great free UI package based on Bootstrap 4 that
                    includes the most important components and features.
                  </p>
                  <div>
                    <badge type="primary" rounded>design</badge>
                    <badge type="primary" rounded>system</badge>
                    <badge type="primary" rounded>creative</badge>
                  </div>
                  <base-button tag="a" href="#" type="primary" class="mt-4">
                    Learn more
                  </base-button>
                </card>
              </div>
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon
                    name="ni ni-istanbul"
                    type="success"
                    rounded
                    class="mb-4"
                  >
                  </icon>
                  <h6 class="text-success text-uppercase">Build Something</h6>
                  <p class="description mt-3">
                    Argon is a great free UI package based on Bootstrap 4 that
                    includes the most important components and features.
                  </p>
                  <div>
                    <badge type="success" rounded>business</badge>
                    <badge type="success" rounded>vision</badge>
                    <badge type="success" rounded>success</badge>
                  </div>
                  <base-button tag="a" href="#" type="success" class="mt-4">
                    Learn more
                  </base-button>
                </card>
              </div>
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon name="ni ni-planet" type="warning" rounded class="mb-4">
                  </icon>
                  <h6 class="text-warning text-uppercase">Prepare Launch</h6>
                  <p class="description mt-3">
                    Argon is a great free UI package based on Bootstrap 4 that
                    includes the most important components and features.
                  </p>
                  <div>
                    <badge type="warning" rounded>marketing</badge>
                    <badge type="warning" rounded>product</badge>
                    <badge type="warning" rounded>launch</badge>
                  </div>
                  <base-button tag="a" href="#" type="warning" class="mt-4">
                    Learn more
                  </base-button>
                </card>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section> -->
  </div>
</template>

<script>
import HouseSearchBar from "../components/house/HouseSearchBar.vue";
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "AppHouse",
  components: {
    HouseSearchBar,
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "dongName", "houses"]),
  },
  methods: {
    setInfo() {
      this.$store.state.idxSido =
        document.getElementById("selSido").selectedIndex;
      this.$store.state.idxGugun =
        document.getElementById("selGugun").selectedIndex;
      this.$store.state.idxDong =
        document.getElementById("selDong").selectedIndex;
    },
  },
};
</script>
