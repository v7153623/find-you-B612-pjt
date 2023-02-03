<template>
  <div>
    <div class="position-relative" ref="movepoint">
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
        <div
          class="shape shape-style-1 shape-default shape-skew"
          v-show="false"
        >
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
              <div class="col-lg-12">
                <h1 class="display-3 text-white">
                  Happy House
                  <!-- <span>지역 검색 서비스</span> -->
                </h1>
                <p class="lead text-white">지역 검색 서비스</p>
                <house-search-bar-for-result></house-search-bar-for-result>
                <p class="lead text-white"></p>
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
          <!-- <KakaoMap /> -->
          <div id="map" ref="kakaomap"></div>
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
                  <p class="description mt-3">지번: {{ house.jibun }}</p>
                  <p class="description mt-3">
                    건축년도: {{ house.buildYear }}
                  </p>
                  <p class="description mt-3">
                    매매가격: {{ house.recentPrice }}
                  </p>
                  <p class="description mt-3">
                    상세주소: {{ house.sidoName }} {{ house.gugunName }}
                    {{ house.dongName }}
                    {{ house.jibun }}
                    {{ house.aptName }}
                  </p>
                  <!-- <div>
                    <badge type="primary" rounded>design</badge>
                    <badge type="primary" rounded>system</badge>
                    <badge type="primary" rounded>creative</badge>
                  </div> -->
                  <base-button
                    tag="a"
                    href="javascript:"
                    type="primary"
                    class="mt-4"
                    @click="setCenter(house.lat, house.lng)"
                  >
                    지도에서 보기
                  </base-button>
                  <b-button @click="modalShow = !modalShow"
                    >저축하면 얼마나 걸릴까?</b-button
                  >
                  <b-modal v-model="modalShow" title="저축하면 얼마나 걸릴까?"
                    >대상: {{ house.aptName }} ({{ house.sidoName }}
                    {{ house.gugunName }} {{ house.dongName }})<br />
                    가격: {{ getPrice(house.recentPrice) }}
                    <hr
                  />{{getPrice(house.recentPrice)}} * (1-LTV(0.7)) = {{getPrice2(house.recentPrice)}}<br>
                  {{getPrice2(house.recentPrice)}} / 100만원 = {{getPrice3(house.recentPrice)}}<hr>
                  => {{getPrice3(house.recentPrice)}}만 더 모으면 되겠네요!!
                </b-modal>
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
// import KakaoMap from "../components/KakaoMap";

const houseStore = "houseStore";

export default {
  name: "AppHouseResult",
  data() {
    return {
      modalShow: false,
      map: null,
    };
  },
  components: {
    HouseSearchBarForResult,
    // KakaoMap,
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "dongName", "houses"]),
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=80bcacec42325ba8779e53d08ef148be";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(this.houses[0].lat, this.houses[0].lng),
        level: 5,
      };
      var map = new kakao.maps.Map(container, options);

      // var positions = this.houses.map(
      //   (house) => new kakao.maps.LatLng(house.lat, house.lng)
      // );

      this.houses.forEach((house) => {
        var pos = new kakao.maps.LatLng(house.lat, house.lng);
        var marker = new kakao.maps.Marker({
          position: pos,
        });
        marker.setMap(map);
        var iwContent = `<div><b>${house.aptName}<b></div>`;
        var infowindow = new kakao.maps.InfoWindow({
          content: iwContent,
        });
        kakao.maps.event.addListener(marker, "mouseover", function () {
          infowindow.open(map, marker);
        });
        kakao.maps.event.addListener(marker, "mouseout", function () {
          infowindow.close();
        });
      });
      this.map = map;
    },
    setCenter(lat, lng) {
      // var mapContainer = document.getElementById("map"), // 지도를 표시할 div
      //   mapOption = {
      //     center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      //     level: 3, // 지도의 확대 레벨
      //   };

      // var map = new kakao.maps.Map(mapContainer, mapOption);
      var moveLatLon = new kakao.maps.LatLng(lat, lng);

      // 지도 중심을 이동 시킵니다
      this.map.setCenter(moveLatLon);
      // this.$refs.kakaomap.focus();
      // messages.scrollTo({ top: messages.scrollHeight, behavior: 'smooth' });
      // let scrollArea = this.$refs.kakaomap;
      let scrollArea = this.$refs.movepoint;
      scrollArea.scrollIntoView({ behavior: "smooth", block: "start" });
    },
    getPrice(recentPrice) {
      let price = recentPrice.replace(",", "");
      let u = parseInt(price / 10000);
      let c = price % 10000;
      if (c != 0) {
        return `${u}억 ${c}만원`;
      } else return `${u}억`;
    },
    getPrice2(recentPrice) {
      let price = recentPrice.replace(",", "");
      price = price * 0.3;
      let u = parseInt(price / 10000);
      let c = price % 10000;
      if (c != 0) {
        return `${u}억 ${c}만원`;
      } else return `${u}억`;
    },
    getPrice3(recentPrice) {
      let price = recentPrice.replace(",", "");
      price = price * 0.3
      let month = price * 0.01;
      let year = parseInt(month / 12);
      month = month % 12;
      if (year > 0) {
        return `${year}년 ${month}개월`;
      } else return `${month}개월`;
    },
  },
  updated() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=80bcacec42325ba8779e53d08ef148be";
      document.head.appendChild(script);
    }
  },
};
</script>

<style>
#map {
  width: 400px;
  height: 400px;
}
div.left {
  width: 50%;
  float: left;
}
div.right {
  width: 50%;
  float: right;
}
</style>