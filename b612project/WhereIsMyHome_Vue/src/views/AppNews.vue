<template>
  <section class="section section section-shaped my-0 overflow-hidden"
  style="
      background-image: url('img/theme/prince1.png');
      background-repeat: no-repeat;
      background-position: 100% 0%;
      background-size: 100% 100%;
    ">
    <div class="shape shape-style-1 bg-gradient-info shape-skew" v-show="false">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container py-0">
      <div class="row row-grid align-items-center">
        <div class="col-md-6 order-lg-2 ml-lg-auto">
          <div class="position-relative pl-md-5"></div>
        </div>
        <div class="mt-5 ml-3">
          <h1 class="display-3 text-white">
            House News
            <span>새로운 소식을 확인하세요</span>
            <br>
          </h1>
        </div>
        <div class="col-lg-15 order-lg-1">
          <div class="d-flex px-3">
            <div>
              <b-carousel
                id="carousel-1"
                v-model="slide"
                :interval="4000"
                controls
                indicators
                background="#ababab"
                img-width="1024"
                img-height="480"
                style="text-shadow: 1px 1px 2px #333"
                @sliding-start="onSlideStart"
                @sliding-end="onSlideEnd"
              >
                <!-- Slide with blank fluid image to maintain slide aspect ratio -->
                <b-carousel-slide
                  v-for="(article, index) in this.news"
                  :key="index"
                  :article="article"
                  :caption="article.title"
                  img-src="img/theme/hand.png"
                  img-alt="Blank image"
                  class="aa"
                >
                <a :href="article.link" style="color:white">
                  <p>
                    {{ article.description }}
                  </p>
                </a>
                </b-carousel-slide>
              </b-carousel>

              <!-- <p class="mt-4">
      Slide #: {{ slide }}<br>
      Sliding: {{ sliding }}
    </p> -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { saveone, naver, deleteAll, getNews } from "@/api/news";

export default {
  name: "AppNews",
  created() {
    // deleteAll(
    //   ({ data }) => {
    //     console.log(data);
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );
    // naver(
    //   ({ data }) => {
    //     console.log(data);
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );
    // saveone(
    //   ({ data }) => {
    //     console.log(data);
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );
    getNews(
      ({ data }) => {
        console.log(data);
        this.news = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  data() {
    return {
      slide: 0,
      sliding: null,
      news: null,
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
  },
};
</script>

<style>
.b-carousel-slide {
  color: aqua;
}
</style>