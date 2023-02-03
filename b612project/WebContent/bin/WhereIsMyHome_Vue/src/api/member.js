import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  const realuser = {
    id:user.userid,
    pwd:user.userpwd,
  }
  await api.post(`/userapi/login`, JSON.stringify(realuser)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/userapi/info/${userid}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  const realuser = {
    id:user.userid,
    pwd:user.userpwd,
  }
  api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token"); //axios header에 refresh-token 셋팅
  await api.post(`/userapi/refresh`, realuser).then(success).catch(fail);
}

async function logout(userid, success, fail) {
  await api.get(`/userapi/logout/${userid}`).then(success).catch(fail);
}

async function regist(user,success,fail){
  await api.post(`/userapi/user`, JSON.stringify(user)).then(success).catch(fail);
}

export { login, findById, tokenRegeneration, logout, regist };
