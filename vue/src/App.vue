<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
      style="height:70px;z-index:102"
    >
      <v-container class="py-0 fill-height">
        <!-- avater -> 맨 왼쪽에 로고 이미지 -->
        <div class="main_logo">
          <a href="/">DOG EAT</a>
            </div>
        <v-btn
          text
          class="main_top_btn"
          v-if="this.Userinfo.User_Id==null"
          router :to="{name: 'Login'}"
        >
         로그인
        </v-btn>
        <v-btn
          text
          small
          class="main_top_btn"
          @click="logout"
          router :to="{name: 'Home'}"
          v-else
        >
         LOGOUT
        </v-btn>

        <v-btn
          text
          class="main_top_btn"
          v-if="Userinfo.User_Id==null"
          router :to="{name: 'SignUp'}"
        >
         회원가입
        </v-btn>
        <v-btn
          text
          class="main_top_btn"
          v-else
          router :to="{name: 'User'}"
        >
         마이페이지
        </v-btn>
        <v-btn
          text
          class="main_top_btn"
          v-if="Userinfo.User_Id==null"
        >
         고객센터
        </v-btn>
        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <div class="fill-height" style="align-items:flex-start;margin:20px;">
        <v-row>
          <v-col cols="2" v-if="Userinfo.User_Id=='111'">
            <AdminMenu/>
          </v-col>
          <v-col cols="2" v-else>
            <DefaultMenu/>
          </v-col>
          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <router-view/>
            </v-sheet>
          </v-col>
        </v-row>
      </div>
    </v-main>
    
  </v-app>
</template>

<script>
import {mapMutations, mapState} from "vuex"
import AdminMenu from '@/components/AdminMenu'
import DefaultMenu from '@/components/defaultMenu'

  export default {
    data: () => ({
      drawer: null,
    }),
    computed: {
      ...mapState(["Userinfo"])
    },
    components: {
        AdminMenu,
        DefaultMenu
    },
    methods: {
      ...mapMutations(["logout"])
    },
    created() {
     
      if(this.Userinfo.User_token === null && localStorage.getItem("token") !== null) {
         console.log("tokentoken")
        this.$store.commit("INSERT_TOKEN"),
        this.$store.dispatch('UnpackToken')
      }else {
        this.Userinfo.User_token = localStorage.getItem("token")
      }
    }
  }
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Potta+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&display=swap');
a {
  text-decoration: none;
}
.main_logo > a{
  width:70px;
  height:70px;
  font-size: 1.5rem;
  color:#B80C00;
  font-weight: 700;
  font-family: 'Potta One', cursive;
  line-height: 25px;
  text-align: center;
  margin-right:20px;
  display: inline-block;
}
.main_top_btn {
  width:100px;
  background-color: transparent;
  font-weight: 700;
  text-align: left;
  font-size:1.3rem!important;
  font-family: 'Cute Font', cursive;
  color:#595959!important;
}
</style>