<template>
    <section class="section section-shaped section-lg my-0"
    style="
      background-image: url('img/theme/prince1.png');
      background-repeat: no-repeat;
      background-position: 100% 0%;
      background-size: 100% 100%;
    ">
        <div class="shape shape-style-1 bg-gradient-default" v-show="false">
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
                                            v-model="user.id"
                                            class="mb-3"
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
        ...mapActions(memberStore, ["registConfirm","afterRegist"]),
        async confirm() {
        await this.registConfirm(this.user);
        if (this.isRegist) {
            alert("가입 성공");
            this.afterRegist();
            this.$router.push({ name: "main" });
        }
        else{
            alert("가입 실패- 전화번호 규칙을 확인하거나 모든 칸을 채워주세요.");
        }
        },
    },
};
</script>
<style>
</style>
