<template>
  <header class="header-global">
    <base-nav class="navbar-main" transparent type="" effect="light" expand>
      <router-link slot="brand" class="navbar-brand mr-lg-5" to="/">
        <img src="img/brand/white.png" />
      </router-link>

      <div class="row" slot="content-header" slot-scope="{ closeMenu }">
        <div class="col-6 collapse-brand">
          <a href="../index.html">
            <img src="img/brand/blue.png" />
          </a>
        </div>
        <div class="col-6 collapse-close">
          <close-button @click="closeMenu"></close-button>
        </div>
      </div>

      <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
        <li class="nav-item dropdown">
          <a href="#" class="nav-link" data-toggle="dropdown" role="button">
            <i class="ni ni-ui-04 d-lg-none"></i>
            <span class="nav-link-inner--text">HappyHouse</span>
          </a>
          <div class="dropdown-menu dropdown-menu-xl">
            <div class="dropdown-menu-inner">
              <router-link to="/house" class="media d-flex align-items-center">
                <div
                  class="
                    icon icon-shape
                    bg-gradient-primary
                    rounded-circle
                    text-white
                  "
                >
                  <i class="ni ni-spaceship"></i>
                </div>
                <div class="media-body ml-3">
                  <h6 class="heading text-primary mb-md-1">해피 하우스</h6>
                  <p class="description d-none d-md-inline-block mb-0">
                    해피 하우스와 함께 나만의 집을 찾아보세요.
                  </p>
                </div>
              </router-link>
              <a
                href="https://demos.creative-tim.com/argon-design-system/docs/components/alerts.html"
                class="media d-flex align-items-center"
              >
                <div
                  class="
                    icon icon-shape
                    bg-gradient-warning
                    rounded-circle
                    text-white
                  "
                >
                  <i class="ni ni-ui-04"></i>
                </div>
                <div class="media-body ml-3">
                  <h5 class="heading text-warning mb-md-1">Components</h5>
                  <p class="description d-none d-md-inline-block mb-0">
                    Learn how to use Argon compiling Scss, change brand colors
                    and more.
                  </p>
                </div>
              </a>
            </div>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a href="#" class="nav-link" data-toggle="dropdown" role="button">
            <i class="ni ni-collection d-lg-none"></i>
            <span class="nav-link-inner--text">Forum</span>
          </a>
          <div class="dropdown-menu">
            <router-link to="/board" class="dropdown-item"
              >공지사항</router-link
            >
            <router-link to="/profile" class="dropdown-item">Q&A</router-link>
          </div>
        </li>
      </ul>
      <ul class="navbar-nav align-items-lg-center ml-lg-auto">
        <li class="nav-item">
          <a
            class="nav-link nav-link-icon"
            href="https://www.facebook.com/creativetim"
            target="_blank"
            data-toggle="tooltip"
            title="Like us on Facebook"
          >
            <i class="fa fa-facebook-square"></i>
            <span class="nav-link-inner--text d-lg-none">Facebook</span>
          </a>
        </li>
        <li class="nav-item">
          <a
            class="nav-link nav-link-icon"
            href="https://www.instagram.com/linga_jang/"
            target="_blank"
            data-toggle="tooltip"
            title="Follow us on Instagram"
          >
            <i class="fa fa-instagram"></i>
            <span class="nav-link-inner--text d-lg-none">Instagram</span>
          </a>
        </li>
        <li class="nav-item">
          <a
            class="nav-link nav-link-icon"
            href="https://github.com/v7153623"
            target="_blank"
            data-toggle="tooltip"
            title="Star us on Github"
          >
            <i class="fa fa-github"></i>
            <span class="nav-link-inner--text d-lg-none">Github</span>
          </a>
        </li>
        <!-- <li class="nav-item d-none d-lg-block ml-lg-4">
                    <a href="https://www.creative-tim.com/product/vue-argon-design-system" target="_blank"
                       class="btn btn-neutral btn-icon">
                <span class="btn-inner--icon">
                  <i class="fa fa-cloud-download mr-2"></i>
                </span>
                        <span class="nav-link-inner--text">Download</span>
                    </a>
                </li> -->
      </ul>
      <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
        <li class="nav-item dropdown" v-if="userInfo">
          <a href="#" class="nav-link" data-toggle="dropdown" role="button">
            <i class="ni ni-collection d-lg-none"></i>
            <span class="nav-link-inner--text">
              {{ userInfo.name }} 유저님 안녕하세요
            </span>
          </a>
          <div class="dropdown-menu">
            <a class="dropdown-item" @click.prevent="onClickLogout">
              Logout
            </a>
            <router-link :to="{ name: 'profile' }" class="dropdown-item">Profile</router-link>
          </div>
        </li>
        <li class="nav-item dropdown" v-else>
          <a href="#" class="nav-link" data-toggle="dropdown" role="button">
            <i class="ni ni-collection d-lg-none"></i>
            <span class="nav-link-inner--text">Login / Register</span>
          </a>
          <div class="dropdown-menu">
            <router-link :to="{ name: 'login' }" class="dropdown-item">Login</router-link>
            <router-link :to="{ name: 'register' }" class="dropdown-item"
              >Register</router-link
            >
          </div>
        </li>
      </ul>
    </base-nav>
  </header>
</template>
<script>
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

import BaseNav from "@/components/BaseNav";
import CloseButton from "@/components/CloseButton";

export default {
  
  components: {
    BaseNav,
    CloseButton,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    onClickLogout() {
      console.log(this.userInfo.id);
      this.userLogout(this.userInfo.id);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "main" });
    },
  },
  
};
</script>
<style>
</style>
