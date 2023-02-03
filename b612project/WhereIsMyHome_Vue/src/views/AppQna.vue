<template>
  <section class="section section section-shaped my-0 overflow-hidden"
  style="
      background-image: url('img/theme/prince1.png');
      background-repeat: no-repeat;
      background-position: 100% 0%;
      background-size: 100% 100%;
    ">
    <div class="shape shape-style-1 bg-gradient-warning shape-skew" v-show="false">
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
          <div class="position-relative pl-md-5">
          </div>
        </div>
        <div class="col-lg-6 order-lg-1">
          <div class="d-flex px-3">
            <div>
              <icon
                name="ni ni-building"
                size="lg"
                class="bg-gradient-white"
                color="primary"
                shadow
                rounded
              ></icon>
            </div>
            <div class="pl-4">
              <h4 class="display-3 text-white">Q&A</h4>
              <p class="text-white">
                오늘도 B612의 모험을 많은 회원님들께서 함께해주고
                있습니다. 다른 사용자 분들과 집에 관한 정보를 공유해 보세요.
              </p>
            </div>
          </div>

          <div align="right">
            <base-button type="success" @click="question"
              >질문 작성</base-button
            >
          </div>
          <transition name="bounce">
            <card shadow class="shadow-lg--hover mt-5" v-if="isQuestion">
              <div class="d-flex px-3">
                <div>
                  <icon
                    name="ni ni-satisfied"
                    gradient="success"
                    color="white"
                    shadow
                    rounded
                  ></icon>
                </div>
                <div class="d-flex px-0">
                  <div class="pl-2">
                    <form>
                      <textarea
                        class="form-control"
                        id="exampleFormControlTextarea1"
                        rows="3"
                        cols="50"
                        placeholder="질문을 입력해주세요"
                        v-model="article.content"
                      ></textarea>
                    </form>
                    <div align="right">
                      <base-button
                        size="sm"
                        type="success"
                        @click="[registArticle(), refresh()]"
                        >작성</base-button
                      >
                    </div>
                  </div>
                </div>
              </div>
            </card>
          </transition>

          <div
            v-for="(article, index) in articles"
            :key="index"
            :article="article"
          >
            <card shadow class="shadow-lg--hover mt-5">
              <div class="d-flex px-3">
                <div>
                  <icon
                    name="ni ni-satisfied"
                    gradient="success"
                    color="white"
                    shadow
                    rounded
                  ></icon>
                </div>
                <div class="pl-4">
                  <h5 class="title text-success">{{ article.userid }}</h5>
                  <p>
                    {{ article.content }}
                  </p>
                  <a
                    href="javascript:"
                    class="text-success"
                    @click="
                      [
                        callAnswer(article.articleno, index),
                        (article.hit = article.hit === 1 ? 0 : 1),
                      ]
                    "
                    >답변 보기</a
                  >&nbsp;&nbsp;
                  <a
                    href="javascript:"
                    class="text-success"
                    @click="
                      article.subject = article.subject === 'c' ? 'a' : 'c'
                    "
                    >답변 달기</a
                  >
                  &nbsp;&nbsp;
                  <a
                    href="javascript:"
                    class="text-success"
                    v-if="article.userid === loginId"
                    @click="
                      article.subject = article.subject === 'u' ? 'a' : 'u'
                    "
                    >수정</a
                  >
                  &nbsp;&nbsp;
                  <a
                    href="javascript:"
                    class="text-success"
                    v-if="article.userid === loginId"
                    @click="deleteArticle(article.articleno)"
                    >삭제</a
                  >
                </div>
              </div>
            </card>

            <transition name="bounce">
              <card
                shadow
                class="shadow-lg--hover mt-5"
                v-if="article.subject === 'u'"
              >
                <div class="d-flex px-3">
                  <div>
                    <icon
                      name="ni ni-satisfied"
                      gradient="success"
                      color="white"
                      shadow
                      rounded
                    ></icon>
                  </div>
                  <div class="d-flex px-0">
                    <div class="pl-2">
                      <form>
                        <textarea
                          class="form-control"
                          id="exampleFormControlTextarea1"
                          rows="3"
                          cols="50"
                          placeholder="질문을 입력해주세요"
                          v-model="article.content"
                        ></textarea>
                      </form>
                      <div align="right">
                        <base-button
                          size="sm"
                          type="success"
                          @click="
                            [
                              modifyArticle(article),
                              resetArticle(article),
                              refreshMod(),
                            ]
                          "
                          >수정</base-button
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </card>
            </transition>

            <div id="example-1">
              <transition name="bounce">
                <ul v-if="article.subject === 'c'">
                  <li>
                    <card
                      shadow
                      class="shadow-lg--hover mt-3"
                      style="margin-left: 20px"
                    >
                      <div class="d-flex px-2">
                        <div class="pl-2">
                          <form>
                            <textarea
                              class="form-control"
                              id="exampleFormControlTextarea1"
                              rows="3"
                              cols="47"
                              placeholder="답변을 입력해주세요"
                              v-model="answer.content"
                            ></textarea>
                          </form>
                          <div align="right">
                            <base-button
                              size="sm"
                              type="warning"
                              @click="
                                [registAnswer(article.articleno), refreshAns()]
                              "
                              >작성</base-button
                            >
                          </div>
                        </div>
                      </div>
                    </card>
                  </li>
                </ul>
              </transition>
            </div>

            <div id="example-1">
              <transition name="slide-fade">
                <ul v-if="article.hit === 1">
                  <icon
                    name="ni ni-bold-down"
                    color="white"
                    width="500px"
                    height="500px"
                  ></icon>
                  <li
                    v-for="(answer, index2) in articles[index].answerlist"
                    :key="index2"
                    :answer="answer"
                  >
                    <card
                      shadow
                      class="shadow-lg--hover mt-2"
                      style="margin-left: 20px"
                    >
                      <div class="d-flex px-3">
                        <div>
                          <icon
                            name="ni ni-like-2"
                            gradient="warning"
                            color="white"
                            shadow
                            rounded
                          ></icon>
                        </div>
                        <div class="pl-4">
                          <h5 class="title text-success">
                            {{ answer.userid }}
                          </h5>
                          <p>
                            {{ answer.content }}
                          </p>
                          <div class="left-box">
                            <a
                              href="javascript:"
                              class="text-success"
                              @click="[likePlus(answer.articleno)]"
                              >추천: {{ answer.likeval }}</a
                            >
                            &nbsp;&nbsp;
                            <a
                              href="javascript:"
                              class="text-success"
                              v-if="answer.userid === loginId"
                              @click="
                                article.subject =
                                  article.subject === 'w' ? 'a' : 'w'
                              "
                              >수정</a
                            >
                            &nbsp;&nbsp;
                            <a
                              href="javascript:"
                              class="text-success"
                              v-if="answer.userid === loginId"
                              @click="deleteAnswer(answer.articleno)"
                              >삭제</a
                            >
                          </div>
                        </div>
                      </div>
                    </card>

                    <card
                      shadow
                      class="shadow-lg--hover mt-3"
                      style="margin-left: 20px"
                      v-if="article.subject === 'w'"
                    >
                      <div class="d-flex px-2">
                        <div class="pl-2">
                          <form>
                            <textarea
                              class="form-control"
                              id="exampleFormControlTextarea1"
                              rows="3"
                              cols="47"
                              placeholder="답변을 입력해주세요"
                              v-model="answer.content"
                            ></textarea>
                          </form>
                          <div align="right">
                            <base-button
                              size="sm"
                              type="warning"
                              @click="
                                [
                                  modifyAnswer(
                                    answer.articleno,
                                    answer.content
                                  ),
                                  refreshAns(),
                                ]
                              "
                              >수정</base-button
                            >
                          </div>
                        </div>
                      </div>
                    </card>
                  </li>
                </ul>
              </transition>
            </div>
          </div>
          <!-- <card shadow class="shadow-lg--hover mt-5">
            <div class="d-flex px-3">
              <div>
                <icon
                  name="ni ni-satisfied"
                  gradient="success"
                  color="white"
                  shadow
                  rounded
                ></icon>
              </div>
              <div class="pl-4">
                <h5 class="title text-success">해피해피하우스</h5>
                <p>
                  정보를 찾는 데 어려움이 많아요, 제가 사는 동네의 주소를 직접
                  검색하고 싶은데 방법이 없을까요?
                </p>
                <a href="#" class="text-success" @click="change">답변 보기</a
                >&nbsp;&nbsp;
                <a href="#" class="text-success" @click="inputForm"
                  >답변 달기</a
                >
              </div>
            </div>
          </card> -->

          <!-- <div id="example-1">
            <transition name="bounce">
              <ul v-if="isInput">
                <li>
                  <card
                    shadow
                    class="shadow-lg--hover mt-3"
                    style="margin-left: 20px"
                  >
                    <div class="d-flex px-2">
                      <div class="pl-2">
                        <form>
                          <textarea
                            class="form-control"
                            id="exampleFormControlTextarea1"
                            rows="3"
                            cols="47"
                            placeholder="답변을 입력해주세요"
                          ></textarea>
                        </form>
                        <div align="right">
                          <base-button size="sm" type="warning"
                            >작성</base-button
                          >
                        </div>
                      </div>
                    </div>
                  </card>
                </li>
              </ul>
            </transition>
          </div> -->

          <div id="example-1">
            <transition name="slide-fade">
              <ul v-if="isShow">
                <li>
                  <icon
                    name="ni ni-bold-down"
                    color="white"
                    width="500px"
                    height="500px"
                  ></icon>
                  <card
                    shadow
                    class="shadow-lg--hover mt-2"
                    style="margin-left: 20px"
                  >
                    <div class="d-flex px-3">
                      <div>
                        <icon
                          name="ni ni-like-2"
                          gradient="warning"
                          color="white"
                          shadow
                          rounded
                        ></icon>
                      </div>
                      <div class="pl-4">
                        <h5 class="title text-success">아르곤</h5>
                        <p>
                          HappyHouse 서비스 하단의 직접 검색 기능을 이용하세요!
                        </p>
                        <div class="left-box">
                          <a href="#" class="text-success">추천: 2</a>
                        </div>
                      </div>
                    </div>
                  </card>
                </li>
                <li>
                  <card
                    shadow
                    class="shadow-lg--hover mt-3"
                    style="margin-left: 20px"
                  >
                    <div class="d-flex px-3">
                      <div>
                        <icon
                          name="ni ni-active-40"
                          gradient="warning"
                          color="white"
                          shadow
                          rounded
                        ></icon>
                      </div>
                      <div class="pl-4">
                        <h5 class="title text-success">녹투스</h5>
                        <p>주소 찾기 서비스를 이용해보세요</p>
                        <a href="#" class="text-success">추천: 1</a>
                      </div>
                    </div>
                  </card>
                </li>
              </ul>
            </transition>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapState } from "vuex";
import {
  writeArticle,
  modifyArticle,
  listArticle,
  deleteArticle,
} from "@/api/qna";
import {
  writeAnswer,
  modifyAnswer,
  listAnswer,
  deleteAnswer,
  getAnswer,
} from "@/api/answer";

export default {
  name: "AppQna",
  data() {
    return {
      articles: [],
      isShow: false,
      isInput: false,
      isQuestion: false,
      loginId: "",
      article: {
        articleno: 0,
        userid: "",
        subject: "default",
        content: "",
      },
      answer: {
        articleno: 0,
        userid: "",
        subject: "default",
        content: "",
      },
      isUserid: false,
      id: "",
      likeValue: 0,
    };
  },
  created() {
    this.article.userid = this.userInfo.id;
    this.loginId = this.userInfo.id;
    let param = {
      pg: 1,
      spp: 20,
      key: null,
      word: null,
    };
    listArticle(
      param,
      ({ data }) => {
        this.articles = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  computed: {
    ...mapState("memberStore", ["userInfo", "isRegist"]),
  },
  watch: {},
  methods: {
    refresh() {
      // this.$forceUpdate();
      this.isQuestion = false;
      this.$router.go();
    },
    refreshAns() {
      this.article.subject = "a";
      // this.$forceUpdate();
      // this.isQuestion = false;
    },
    refreshMod() {
      this.$router.go();
    },
    resetArticle(article) {
      article.subject = "a";
      // this.$router.go();
    },
    change() {
      this.isShow = !this.isShow;
    },
    inputForm() {
      this.isInput = !this.isInput;
    },
    question() {
      this.isQuestion = !this.isQuestion;
    },
    registArticle() {
      let param = {
        userid: this.article.userid,
        subject: this.article.subject,
        content: this.article.content,
      };
      console.log(param);
      writeArticle(
        param,
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          // alert(msg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    modifyArticle(article) {
      let param = {
        articleno: article.articleno,
        userid: article.userid,
        content: article.content,
      };
      modifyArticle(
        param,
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          // alert(msg);
          // 현재 route를 /list로 변경.
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteArticle(no) {
      let param = no;
      deleteArticle(
        param,
        ({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          // alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.go();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    registAnswer(refno) {
      let param = {
        refno: refno,
        userid: this.article.userid,
        subject: this.answer.subject,
        content: this.answer.content,
      };
      console.log(param);
      writeAnswer(
        param,
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            this.$router.go();
            msg = "등록이 완료되었습니다.";
          }
          // alert(msg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    callAnswer(refno, index) {
      let param = {
        pg: 1,
        spp: 20,
        key: null,
        word: null,
        refno: refno,
      };
      listAnswer(
        param,
        ({ data }) => {
          this.articles[index].answerlist = data;
          this.$forceUpdate();
          // console.log(data);
          // console.log(this.articles[index].answerlist);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteAnswer(no) {
      let param = no;
      deleteAnswer(
        param,
        ({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          // alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.go();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    modifyAnswer(no, content) {
      let param = {
        articleno: no,
        userid: this.loginId,
        content: content,
      };
      modifyAnswer(
        param,
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          // alert(msg);
          // 현재 route를 /list로 변경.
        },
        (error) => {
          console.log(error);
        }
      );
      this.$router.go();
    },
    likePlus(no) {
      let param = no;
      getAnswer(
        param,
        ({ data }) => {},
        (error) => {
          console.log(error);
        }
      );
      this.$router.go();
    },
    incLike(answer) {
      answer.likeval++;
    },
  },
};
</script>

<style>
.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.5);
  }
  100% {
    transform: scale(1);
  }
}
ul {
  list-style: none;
  padding-left: 0px;
}
.slide-fade-enter-active {
  transition: all 0.3s ease;
}
.slide-fade-leave-active {
  transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}
.slide-fade-enter, .slide-fade-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}
.left-box {
  float: left;
}
.right-box {
  float: right;
}
</style>