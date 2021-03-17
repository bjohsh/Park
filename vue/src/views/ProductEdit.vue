<template>
  <div>
    <v-text-field
      label="TITLE"
      v-model="b_title"
      hide-details="auto"
    ></v-text-field>
    <v-text-field label="CONTENT"
    v-model="b_content"></v-text-field>
    <v-text-field label="$"
    v-model="b_price"></v-text-field>
    <v-text-field label="재고"
    v-model="b_inventory"></v-text-field>
    <v-text-field label="원산지"
    v-model="b_from"></v-text-field>
    <input type="hidden" v-model="b_id"/>
    <input type="hidden" v-model="b_idx"/>
    <v-container fluid>
    <v-row align="center">
      <v-col
        class="d-flex"
        cols="12"
        sm="6"
      >
        <v-select
        select="b_category"
          :items="items"
          v-model="b_category"
          return-object
          label="종류"
        ></v-select>
      </v-col>
      <v-file-input id="file"
        v-model="fileinput"
        v-on:change="submitFile(fileinput)">
      </v-file-input>

      <v-col
        class="d-flex"
        cols="12"
        sm="6"
      >
      </v-col>
    </v-row>
  </v-container>
     <v-btn color="#7986CB" @click="productEdit({
       b_idx:b_idx,
      b_title:b_title, 
      b_content:b_content, 
      b_id: b_id, 
      b_price: b_price,
      b_category: b_category,
      b_inventory:b_inventory,
      b_from:b_from
    })">수정하기</v-btn>
  </div>
  
</template>

<script>
import {mapState,mapActions} from "vuex"
  export default {
    data() {
        return {
            b_title: localStorage.getItem("edit_b_title"),
            b_content: localStorage.getItem("edit_b_content"),
            b_id : localStorage.getItem("edit_b_id"),
            b_price:localStorage.getItem("edit_b_price"),
            b_inventory: localStorage.getItem("edit_b_inventory"),
            items: ['수제천연껌', '육포&저키', '뼈다귀껌', '사료'],
            b_category: localStorage.getItem("edit_b_category"),
            b_idx:localStorage.getItem("edit_b_idx"),
            b_from:localStorage.getItem("edit_b_from")
        }
    },
    methods: {
        productEdit(payload) {
          console.log(payload)
          this.$store.dispatch("productEdit", payload)
        },
       
    },
    computed: {
       ...mapState(["productDetail"]),
    },
    submitFile(payload) {
      console.log(payload)
      this.$store.dispatch('submitFile', payload)
    }
  }
</script>