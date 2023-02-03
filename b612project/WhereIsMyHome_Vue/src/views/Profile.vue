<template>
  <div class="profile-page">
    <section class="section-profile-cover section-shaped my-0"
    style="
      background-image: url('img/theme/prince1.png');
      background-repeat: no-repeat;
      background-position: 100% 0%;
      background-size: 100% 100%;
    ">
      <div class="shape shape-style-1 shape-primary shape-skew alpha-4" v-show="false">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
    </section>
    <section class="section section-skew">
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                  <a href="#">
                    <img
                      v-lazy="'img/theme/btree.png'"
                      class="rounded-circle"
                    />
                  </a>
                </div>
              </div>
              <div
                class="col-lg-4 order-lg-3 text-lg-right align-self-lg-center"
              >
                <div class="card-profile-actions py-4 mt-lg-0">
                  <base-button
                    type="info"
                    size="sm"
                    class="mr-4"
                    @click="movePage"
                    >Modify</base-button
                  >
                  <base-button
                    type="danger"
                    size="sm"
                    class="float-right"
                    @click="removeUser"
                    >Delete</base-button
                  >
                </div>
              </div>
              <div class="col-lg-4 order-lg-1">
                <!--여기 지우면 사진이 쳐짐-->
              </div>
            </div>
            <div class="text-center mt-5">
              <h3>
                {{ userInfo.name }}
                <!-- <span class="font-weight-light">, 27</span> -->
              </h3>
              <div class="h6 font-weight-300">
                <i class="ni location_pin mr-2"></i>{{ userInfo.joindate }} ~
              </div>
              <div class="h6 mt-4">
                <i class="ni business_briefcase-24 mr-2"></i
                >{{ userInfo.address }}
              </div>
              <!-- <div><i class="ni education_hat mr-2"></i>University of Computer Science</div> -->
            </div>
            <div class="mt-5 py-5 border-top text-center">
              <div class="row justify-content-center">
                <div class="col-lg-9">
                  <p>© 2022 SSAFY B612</p>
                  <!-- <a href="#">Show more</a> -->
                </div>
              </div>
            </div>
          </div>
        </card>
      </div>
    </section>
  </div>
</template>
<script>
import { mapState, mapActions } from "vuex";
const memberStore = "memberStore";

export default {
  name: "Profile",
  data() {
    return {
      userid: null,
    };
  },
  computed: {
    ...mapState("memberStore", ["userInfo", "isRegist"]),
  },
  created() {
    this.userid = this.userInfo.id;
  },
  methods: {
    ...mapActions(memberStore, ["deleteUser", "afterRegist"]),
    async removeUser() {
      await this.deleteUser(this.userid);
      if (this.isRegist) {
        this.afterRegist();
        this.$router.push({ name: "main" });
        alert("삭제 성공");
      } else {
        alert("삭제 실패 - 없는 계정입니다.");
      }
    },

    movePage() {
      this.$router.push({ name: "userModify" });
    },
  },
};
</script>
<style>
</style>
