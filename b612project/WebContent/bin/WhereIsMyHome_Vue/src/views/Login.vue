<template>
    <section class="section section-shaped section-lg my-0">
        <div class="shape shape-style-1 bg-gradient-default">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div class="container pt-lg-md">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                    <card type="secondary" shadow
                          header-classes="bg-white pb-5"
                          body-classes="px-lg-5 py-lg-5"
                          class="border-0">
                        
                        <template>
                            <div class="text-center text-muted mb-4">
                                <h3>Login</h3>
                            </div>
                            <form role="form">
                                <base-input required
                                            v-model="user.userid"
                                            id="userid"
                                            class="mb-3"
                                            placeholder="id"
                                            addon-left-icon="ni ni-email-83"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>
                                <base-input required
                                            v-model="user.userpwd"
                                            id="userpwd"
                                            type="password"
                                            placeholder="Password"
                                            addon-left-icon="ni ni-lock-circle-open"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>
                                <base-checkbox>
                                    Remember me
                                </base-checkbox>
                                <div class="text-center">
                                    <base-button type="primary" class="my-4" @click="confirm">Sign In</base-button>
                                </div>
                            </form>
                        </template>
                    </card>
                    <div class="row mt-3">
                        <div class="col-6">
                            <a href="#" class="text-light" @click="movePage">
                                <small>Forgot password?</small>
                            </a>
                        </div>
                        <div class="col-6 text-right">
                            <a href="#" class="text-light"  @click="movePage">
                                <small>Create new account</small>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
    name: "UserLogin",
    data() {
        return {
        // isLoginError: false,
        user: {
            userid: null,
            userpwd: null,
        },
        };
    },
    computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
    },
    methods: {
        ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
        async confirm() {
            
        await this.userConfirm(this.user);
        let token = sessionStorage.getItem("access-token");
          // console.log("1. confirm() token >> " + token);
        if (this.isLogin) {
            await this.getUserInfo(token);
            // console.log("4. confirm() userInfo :: ", this.userInfo);
            this.$router.push({ name: "main" });
        }
        },
        movePage() {
        this.$router.push({ name: "register" });
        },
    },
};
</script>
<style>
</style>
