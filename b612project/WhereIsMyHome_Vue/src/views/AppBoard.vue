<template>
  <section class="section-hero section-shaped my-0"
  style="
      background-image: url('img/theme/prince1.png');
      background-repeat: no-repeat;
      background-position: 100% 0%;
      background-size: 100% 100%;
    ">
    <div class="shape shape-style-1 shape-primary" v-show="false">
      <span class="span-150"></span>
      <span class="span-50"></span>
      <span class="span-50"></span>
      <span class="span-75"></span>
      <span class="span-100"></span>
      <span class="span-75"></span>
      <span class="span-50"></span>
      <span class="span-100"></span>
      <span class="span-50"></span>
      <span class="span-100"></span>
    </div>
    <div class="container shape-container d-flex align-items-center">
      <router-view></router-view>
    </div>
  </section>
</template>

<script>
export default {
  name: "AppBoard",
};
</script>

<style>
</style>