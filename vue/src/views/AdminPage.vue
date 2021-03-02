<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <!-- avater -> 맨 왼쪽에 로고 이미지 -->
        <v-avatar>DOG EAT</v-avatar>
       <v-btn
          text
          router :to="{name: 'Home'}"
          color="#A1887F"
        >
         박정은
       </v-btn>
        <v-btn
          text
          v-if="Userinfo.User_Id==null"
          router :to="{name: 'Login'}"
        >
         로그인
        </v-btn>
        <v-btn
          text
          small
          @click="logout"
          v-else
        >
         LOGOUT
        </v-btn>

        <v-btn
          text
          v-if="Userinfo.User_Id==null"
          router :to="{name: 'SignUp'}"
        >
         회원가입
        </v-btn>
        <v-btn
          text
          small
          v-else
        >
         마이페이지
        </v-btn>
        <v-btn
          text
          v-if="Userinfo.User_Id=='111'"
          router :to="{name: 'admin'}"
        >
         관리자
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
      <v-container>
        <v-row>
          <v-col style="margin-top:-74px;">
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <router-view/>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import {mapMutations, mapState} from "vuex"

  export default {
    data: () => ({
      drawer: null,
    }),
    
    computed: {
      ...mapState(["Userinfo"])
    },
    methods: {
      ...mapMutations(["logout"])
    }
  }
</script>
