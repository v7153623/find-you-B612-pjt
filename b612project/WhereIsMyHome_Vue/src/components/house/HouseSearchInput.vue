<template>
  <span>
    <b-select style="width: 150px; margin-left: 17px">
      <option value="sido">시/도</option>
      <option value="gungu">군/구</option>
      <option value="dong">동</option>
      <option value="aptName">아파트 이름</option>
    </b-select>
    <div>
      <form>
        <b-input
          type="email"
          class="form-control mt-4"
          id="exampleFormControlInput1"
          placeholder="name@example.com"
          style="width: 307px; margin-left: 5px"
        ></b-input>
      </form>
    </div>
  </span>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseSearchInput",
  data() {
    return {
      sidoName: null,
      gugunName: null,
      dongName: null,
      aptName: null,
    };
  },
  computed: {
    ...mapState(["houses"]),
  },
  created() {},
};
</script>

<style>
</style>