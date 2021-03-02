<template>
<v-container style="max-width:500px">
    <v-layout>
        <v-flex xs12>
            <v-card class="elevation-12">
                <v-toolbar
                color="#9575CD"
                dark
                flat
                >
                <v-toolbar-title>
                    Sign Up 
                </v-toolbar-title>
                <v-spacer></v-spacer>
                </v-toolbar>
                <v-card-text>
                <v-form>
                    <v-text-field
                    label="Id"
                    name="username"
                    prepend-icon="mdi-account"
                    v-model="username"
                    type="text"
                    ></v-text-field>

                    <v-text-field
                    id="UserPassword"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    v-model="password"
                    type="password"
                    ></v-text-field>

                    <v-text-field
                    id="UserName"
                    label="Name"
                    name="name"
                    v-model="name"
                    prepend-icon="mdi-card-account-details"
                    type="text"
                    ></v-text-field>

                    <v-text-field
                    id="UserPhone"
                    label="Phone"
                    v-model="phone"
                    name="phone"
                    prepend-icon="mdi-phone"
                    type="text"
                    ></v-text-field>

                     <v-text-field
                    id="UserAddress"
                    label="Address"
                    v-model="address"
                    name="address"
                    prepend-icon="mdi-home"
                    type="text"
                    ></v-text-field>
                </v-form>
                </v-card-text>
                <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="#9575CD" @click="SignUp({username: username, password: password, name:name, phone:phone, address:address})">Sign Up</v-btn>
                </v-card-actions>
            </v-card>
        </v-flex>
    </v-layout>
</v-container>
</template>

<script>
import { mapActions } from 'vuex'

  export default {
    data() {
      return {
        username:null,
        password:null,
        name:null,
        phone:null,
        address:null
      }
    },
    methods: {
      ...mapActions(['SignUp']),
    }
  }
</script>