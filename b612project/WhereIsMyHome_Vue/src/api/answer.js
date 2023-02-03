import { apiInstance } from "./index.js";

const api = apiInstance();

function listAnswer(param, success, fail) {
  api.get(`/answer/`, { params: param }).then(success).catch(fail);
}

function writeAnswer(article, success, fail) {
  api.post(`/answer/`, JSON.stringify(article)).then(success).catch(fail);
}

function getAnswer(articleno, success, fail) {
  api.get(`/answer/${articleno}`).then(success).catch(fail);
}

function modifyAnswer(article, success, fail) {
  api.put(`/answer/`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteAnswer(articleno, success, fail) {
  api.delete(`/answer/${articleno}`).then(success).catch(fail);
}

export { listAnswer, writeAnswer, getAnswer, modifyAnswer, deleteAnswer };
