<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <div class="alert alert-primary" role="alert">
          <h3 style="color: white">글수정</h3>
        </div>
      </b-col>
    </b-row>
    <board-input-item type="modify" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem";

export default {
  name: "BoardModify",
  components: {
    BoardInputItem,
  },
};
</script>

<style></style>
