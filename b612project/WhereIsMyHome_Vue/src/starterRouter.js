import Vue from "vue";
import Router from "vue-router";
import Header from "./layout/starter/StarterHeader";
import Footer from "./layout/starter/StarterFooter";
import Starter from "./views/Starter.vue";
import AppHouse from "@/views/AppHouse";
import AppHouseResult from "@/views/AppHouseResult";
import AppBoard from "@/views/AppBoard";
import AppQna from "@/views/AppQna";
import BootstrapVue from 'bootstrap-vue';
import Register from './views/Register.vue';
import Login from "@/views/Login";
import AppMain from "@/views/Starter.vue"; 
import Profile from "./views/Profile.vue";
import userModify from "./views/userModify.vue";
import AppNews from "./views/AppNews.vue";

Vue.use(BootstrapVue);
Vue.use(Router);

const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const checkToken = store.getters["memberStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("memberStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "login" });
    router.push({ name: "login" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

export default new Router({
  linkExactActiveClass: "active",
  routes: [
    {
      path: "/",
    name: "main",
      components: {
        header: Header,
        default: Starter,
        footer: Footer
      }
    },
    {
      path: "/house",
      name: "house",
      components: {
        header: Header,
        default: AppHouse,
        footer: Footer
      }
    },
    {
      path: "/news",
      name: "news",
      components: {
        header: Header,
        default: AppNews,
        footer: Footer
      }
    },
    {
      path: "/houseresult",
      name: "houseresult",
      components: {
        header: Header,
        default: AppHouseResult,
        footer: Footer
      }
    },
    {
      path: "/register",
      name: "register",
      components: {
        header: Header,
        default: Register,
        footer: Footer
      }
    },
    {
      path: "/qna",
      name: "qna",
      components: {
        header: Header,
        default: AppQna,
        footer: Footer
      }
    },
    {
      path: "/board",
      name: "board",
      components: {
        header: Header,
        default: AppBoard,
        footer: Footer,
      },
      redirect: "/board/list",
      children: [
        {
          path: "list",
          name: "boardlist",
          component: () => import("@/components/board/BoardList"),
        },
        {
          path: "write",
          name: "boardwrite",
          // beforeEnter: onlyAuthUser,
          component: () => import("@/components/board/BoardWrite"),
        },
        {
          path: "view/:articleno",
          name: "boardview",
          // beforeEnter: onlyAuthUser,
          component: () => import("@/components/board/BoardView"),
        },
        {
          path: "modify",
          name: "boardmodify",
          // beforeEnter: onlyAuthUser,
          component: () => import("@/components/board/BoardModify"),
        },
        {
          path: "delete/:articleno",
          name: "boarddelete",
          // beforeEnter: onlyAuthUser,
          component: () => import("@/components/board/BoardDelete"),
        },
      ],
    },
    {
      header: Header,
      path: "/user",
      name: "user",
      footer: Footer,
      components: {
        header: Header,
        default: Login,
        footer: Footer,
      },
      children: [
        {
          path: "join",
          name: "join",
          component: () => import("@/components/user/UserRegister"),
        },
        {
          path: "login",
          name: "login",
          components: {
            header: Header,
            default: Login,
            footer: Footer,
          }
        },
        {
          path: "mypage",
          name: "mypage",
          beforeEnter: onlyAuthUser,
          component: () => import("@/components/user/UserMyPage"),
        },
      ],
    },
    {
      path: "/profile",
      name: "profile",
      components: {
        header: Header,
        default: Profile,
        footer: Footer,
      }
    },
    {
      path: "/userModify",
      name: "userModify",
      components: {
        header: Header,
        default: userModify,
        footer: Footer,
      }
    },
  ],
  scrollBehavior: to => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  }
});
