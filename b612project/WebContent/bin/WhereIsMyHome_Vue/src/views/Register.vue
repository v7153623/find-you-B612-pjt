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
                            <div class="text-muted text-center mb-3">
                                <small>Sign in with</small>
                            </div>
                            <div class="btn-wrapper text-center">
                                <base-button type="neutral">
                                    <img slot="icon" src="img/icons/common/github.svg">
                                    Github
                                </base-button>

                                <base-button type="neutral">
                                    <img slot="icon" src="img/icons/common/google.svg">
                                    Google
                                </base-button>
                            </div>
                        </template>
                        <template>
                            <div class="text-center text-muted mb-4">
                                <small>Or sign up with credentials</small>
                            </div>
                            <form role="form">
                                <base-input required
                                            class="mb-3"
                                            placeholder="Name"
                                            v-model="user.name"
                                            addon-left-icon="ni ni-hat-3"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>
                                <base-input required
                                            class="mb-3"
                                            v-model="user.id"
                                            placeholder="Id"
                                            addon-left-icon="ni ni-email-83"
                                            @keyup.enter="confirm"
                                            >
                                            
                                </base-input>
                                <base-input required
                                            v-model="user.pwd"
                                            type="password"
                                            placeholder="Password"
                                            addon-left-icon="ni ni-lock-circle-open"
                                            @keyup.enter="confirm">
                                </base-input>
                                
                                <base-input required
                                            class="mb-3"
                                            placeholder="address"
                                            v-model="user.address"
                                            addon-left-icon="ni ni-hat-3"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>

                                <base-input required
                                            class="mb-3"
                                            placeholder="tel(xxx-xxxx-xxxx형식)"
                                            v-model="user.tel"
                                            addon-left-icon="ni ni-hat-3"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>

                                <base-input required
                                            class="mb-3"
                                            placeholder="비밀번호 찾기 질문"
                                            v-model="user.question"
                                            addon-left-icon="ni ni-hat-3"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>

                                <base-input required
                                            class="mb-3"
                                            placeholder="비밀번호 찾기 정답"
                                            v-model="user.answer"
                                            addon-left-icon="ni ni-hat-3"
                                            @keyup.enter="confirm"
                                            >
                                </base-input>

                                <!-- <div class="text-muted font-italic">
                                    <small>password strength:
                                        <span class="text-success font-weight-700">strong</span>
                                    </small>
                                </div>
                                <base-checkbox>
                                    <span>I agree with the
                                        <a href="#">Privacy Policy</a>
                                    </span>
                                </base-checkbox> -->
                                <div class="text-center">
                                    <base-button type="primary" class="my-4" @click="confirm">Create account</base-button>
                                </div>
                            </form>
                        </template>
                    </card>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import { mapState,mapActions } from "vuex";

const memberStore = "memberStore";
export default {
    name: "UserRegister",
    data() {
        return {
        // isLoginError: false,
            user: {
                id: null,
                pwd: null,
                name: null,
                tel: null,
                question: null,
                answer: null,
            },
        };
    },
    computed: {
    ...mapState(memberStore, ["isRegist"]),
    },
    methods: {
        ...mapActions(memberStore, ["registConfirm"]),
        async confirm() {
        await this.registConfirm(this.user);
        if (this.isRegist) {
            console.log("가입 성공");
            this.isRegist=false;
            this.$router.push({ name: "main" });
        }
        else{
            alert("가입 실패");
        }
        },
    },
};
</script>
<style>
</style>
