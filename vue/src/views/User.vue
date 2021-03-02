<template>
  <div>
    <h2>{{Userinfo.User_Name}}님 환영합니다.</h2>
  </div>
</template>

<script>
import {mapState} from "vuex"

export default {
    computed: {
        ...mapState(["Userinfo"])
    }
}
</script>