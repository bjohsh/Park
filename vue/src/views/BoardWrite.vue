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
    <v-container fluid>
    <v-row align="center">
      <v-col
        class="d-flex"
        cols="12"
        sm="6"
      >
        <v-select
        select="p_idx"
          :items="items"
          item-value="p_idx"
          item-text="name"
          v-model="p_idx"
          label="CATEGORY"
        ></v-select>
      </v-col>

      <v-file-input 
        id="file"
        ref="file"
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
     <v-btn color="#7986CB" @click="write({
      b_title: b_title, 
      b_content: b_content, 
      b_id: b_id, 
      b_price: b_price,
      p_idx: p_idx,
      b_inventory:b_inventory,
      b_from:b_from,
      b_photo:b_photo
    })">등록하기</v-btn>
  </div>
</template>

<script>
import {mapState} from "vuex"
  export default {
    data() {
        return {
            b_title: null,
            b_content: null,
            b_id : "111",
            b_price: null,
            b_inventory: null,
            b_from:null,
            p_idx: null,
            b_photo: null
            
        }
    },
    methods: {
        write(payload) {
            this.$store.dispatch("write", payload)
        }
    },
    computed: {
      items() {
        return [
          { name: '수제천연껌', p_idx: 10},
          { name: '육포 & 저키', p_idx: 20},
          { name: '뼈다귀껌', p_idx: 30},
          { name: '사료', p_idx: 40},
        ]
      }
    },
    submitFile(payload) {
      console.log(payload)
      this.$store.dispatch('submitFile', payload)
    }
  }
</script>