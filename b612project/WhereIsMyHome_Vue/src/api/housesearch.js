import { apiInstance, houseInstance } from "./index.js";

const api = apiInstance();
const house = houseInstance();

function listBySido(success, fail) {
  api.get(`/homeapi/listBySiDo`).then(success).catch(fail);
}

function listBySiGunGu(params, success, fail) {
  api.get(`/homeapi/listBySiGunGu`, { params: params }).then(success).catch(fail);
}

function listByDong(params, success, fail) {
  api.get(`/homeapi/listByDong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house.get(``, { params: params }).then(success).catch(fail);
}

function listByApt(params, success, fail) {
  api.get(`/homeapi/listByApt`, { params: params }).then(success).catch(fail);
}

export { listBySido, listBySiGunGu, listByDong, houseList, listByApt };
