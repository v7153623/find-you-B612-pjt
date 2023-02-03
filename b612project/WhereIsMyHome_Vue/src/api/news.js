import { apiInstance } from "./index.js";

const api = apiInstance();

function saveone(success, fail) {
    api.post(`/api/server/saveone`).then(success).catch(fail);
}

function naver(success, fail) {
    api.get(`/api/server/naver`).then(success).catch(fail);
}

function deleteAll(success, fail) {
    api.delete(`/api/server/deleteAll`).then(success).catch(fail);
}

function getNews(success, fail) {
    api.get(`/api/server/getnews`).then(success).catch(fail);
}

export {saveone, naver, deleteAll, getNews};