<template>
  <div class="results">
    <p id="yourName">Name:{{ yourName }}</p>
    <p id="yourEmail">Email:{{ yourEmail }}</p>
    <p id="yourSkills">Skills:{{ yourSkills }}</p>
  </div>
</template>

<script>
export default {
  name: 'SeleniumResults',
  props: {
    yourName: String,
    yourEmail: String,
    yourSkills: Array
  },
  created() {
    this.yourName = this.$route.query.name;
    this.yourEmail = this.$route.query.email;
    this.yourSkills = this.$route.query.skills;
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
