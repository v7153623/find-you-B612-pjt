<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <div class="alert alert-primary" role="alert">
          <h3 style="color: white">글작성</h3>
        </div>
      </b-col>
    </b-row>
    <board-input-item type="register" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem";

export default {
  name: "BoardWrite",
  components: {
    BoardInputItem,
  },
};
</script>

<style></style>
