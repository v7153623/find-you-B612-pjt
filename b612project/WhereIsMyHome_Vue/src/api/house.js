import { apiInstance, houseInstance } from "./index.js";

const api = apiInstance();
const house = houseInstance();

function sidoList(success, fail) {
  api.get(`/homeapi/sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`/homeapi/gugun`, { params: params }).then(success).catch(fail);
}

function dongList(params, success, fail) {
  api.get(`/homeapi/dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house.get(``, { params: params }).then(success).catch(fail);
}

function dongHouseList(params, success, fail) {
  api.get(`/homeapi/apt`, { params: params }).then(success).catch(fail);
}

export { sidoList, gugunList, dongList, houseList, dongHouseList };
