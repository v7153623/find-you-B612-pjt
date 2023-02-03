<template>
  <footer class="footer has-cards">
    <!-- <div class="container container-lg">
      <div class="row">
        <div class="col-md-6 mb-5 mb-md-0">
          <div class="card card-lift--hover shadow border-0">
            <router-link to="/landing" title="Landing Page">
              <img v-lazy="'img/theme/landing.jpg'" class="card-img" />
            </router-link>
            <p>글자</p>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-0">
          <div class="card card-lift--hover shadow border-0">
            <router-link to="/profile" title="Profile Page">
              <img v-lazy="'img/theme/profile.jpg'" class="card-img" />
            </router-link>
          </div>
        </div>
      </div>
    </div> -->
    <div class="container">
      <div class="row row-grid align-items-center my-md">
        <div class="col-lg-6">
          <h3 class="text-primary font-weight-light mb-2">
            Thank you for supporting us!
          </h3>
          <h5 class="mb-0 font-weight-light">
            <span class="badge badge-pill badge-primary">기업</span>&nbsp;
            <span style="font-family: 'Noto Serif KR', serif;">01234-01234 [예금주 : 장인혁]</span>
          </h5>
          <h5 class="mb-0 font-weight-light">
            <span class="badge badge-pill badge-warning">국민</span>&nbsp;
            <span style="font-family: 'Noto Serif KR', serif;">012502-04-534308 [예금주 : 문성현]</span>
          </h5>
        </div>
        <div class="col-lg-6 text-lg-center btn-wrapper">
          <a
            target="_blank"
            href="https://twitter.com/creativetim"
            class="btn btn-neutral btn-icon-only btn-twitter btn-round btn-lg"
            data-toggle="tooltip"
            data-original-title="Follow us"
          >
            <i class="fa fa-twitter"></i>
          </a>
          <a
            target="_blank"
            href="https://www.facebook.com/creativetim"
            class="btn btn-neutral btn-icon-only btn-facebook btn-round btn-lg"
            data-toggle="tooltip"
            data-original-title="Like us"
          >
            <i class="fa fa-facebook-square"></i>
          </a>
          <a
            target="_blank"
            href="https://dribbble.com/creativetim"
            class="btn btn-neutral btn-icon-only btn-dribbble btn-lg btn-round"
            data-toggle="tooltip"
            data-original-title="Follow us"
          >
            <i class="fa fa-dribbble"></i>
          </a>
          <a
            target="_blank"
            href="https://github.com/creativetimofficial"
            class="btn btn-neutral btn-icon-only btn-github btn-round btn-lg"
            data-toggle="tooltip"
            data-original-title="Star on Github"
          >
            <i class="fa fa-github"></i>
          </a>
        </div>
      </div>
      <hr />
      <div class="row align-items-center justify-content-md-between">
        <div class="col-md-6">
          <div class="copyright">
            &copy; {{ year }}
            <a href="https://lab.ssafy.com/" target="_blank" rel="noopener"
              >In Hyeok Jang</a
            >
            &
            <a href="https://lab.ssafy.com/" target="_blank" rel="noopener"
              >Seong Hyun Moon</a
            >
          </div>
        </div>
        <div class="col-md-6">
          <ul class="nav nav-footer justify-content-end">
            <li class="nav-item">
              <a href="https://www.ssafy.com" class="nav-link" target="_blank"
                >SSAFY</a
              >
            </li>
            <li class="nav-item">
              <a href="https://edu.ssafy.com/" class="nav-link" target="_blank"
                >About Us</a
              >
            </li>
            <li class="nav-item">
              <a
                href="https://sassy-beaufort-24f.notion.site/HappyHouse-98e56018fa764e8a93caca9b13dfe889"
                class="nav-link"
                target="_blank"
                >Blog</a
              >
            </li>
            <li class="nav-item">
              <a
                href="https://github.com/creativetimofficial/argon-design-system/blob/master/LICENSE.md"
                class="nav-link"
                target="_blank"
                >MIT License</a
              >
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>
<script>
export default {
  name: "starter-footer",
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Serif+KR:wght@200&display=swap');
</style>
