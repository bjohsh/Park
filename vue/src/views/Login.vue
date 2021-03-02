<template>
<v-app style="width:100%;position:absolute;z-index:100;left:0;height:95%;top:-5px;">
  <div class="login_top">
    <h1>LOGIN</h1>
  </div>
  <div class="login_box">
    <v-form>
      <v-text-field
      label="ID"
      name="username"
      v-model="username"
      prepend-icon="mdi-account"
      type="text"
      ></v-text-field>

      <v-text-field
      id="Password"
      label="Password"
      v-model="password"
      name="password"
      prepend-icon="mdi-lock"
      type="password"
      ></v-text-field>
      <div class="login_btn_box">
        <v-btn class="login_btn" @click="login({username: username, password: password})">로그인</v-btn>
        <v-btn class="login_btn" router :to="{name: 'SignUp'}">회원가입</v-btn>
      </div>
    </v-form>
  </div>

</v-app>
</template>

<script>
import {mapActions,mapState} from "vuex"
  export default {
    data() {
      return {
        username:null,
        password:null
      }
    },
    methods: {
   // ...mapActions(["Login"])
    login(payload) {
        this.$store.dispatch('loginProcess', payload)
    }

  }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Potta+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&display=swap');
.login_top {
  background-color:#cccccc;
  color:#fff;
  font-family: 'Cute Font', cursive;
  text-align: center;
  padding:10px;
  font-size:2rem;
  font-weight: 100;
  letter-spacing: 5px;
  margin-top:20px;
  /* margin-bottom:17%; */
}
.login_box {
  width:700px;
  margin:0 auto;
  border:1px solid #ababab;
  border-radius: 10px;
  padding:50px;
  position: absolute;
  top:45%;
  left:50%;
  transform: translate(-50%,-50%);
}
.v-text-field {
  margin:20px 0!important;
}
.login_btn_box {
  width:90%;
  margin:15px auto;
  display:flex;
  justify-content: space-between;

}
.login_btn {
  border:1px solid #ededed;
  border-radius: 5px;
  width:200px;
  box-shadow: none!important;
  padding: 20px!important;
  font-family: 'Cute Font', cursive;
  font-size:1.2rem;
  font-weight: 700;
  background-color:#dfdfdf;
  transition-duration: 0.2s!important;
}
/* .login_btn:hover {
  
  background-color:#B80C00;
  color:#fff;
} */

</style>