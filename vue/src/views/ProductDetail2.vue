<template>
    <div>
        <tr>
            <td>상품명</td>
            <td>내용</td>
            <td>가격</td>
            <td>원산지</td>
        </tr>
        <tr>
            <td>{{b_title}}</td>
            <td>{{b_content}}</td>
            <td>{{b_price}}</td>
            <td>{{b_from}}</td>
        </tr>
        <v-col
        class="d-flex"
        cols="12"
        sm="6"
      >
    <v-select
        select="o_amount"
          :items="amount"
          v-model="o_amount"
          return-object
          label="수량"
        ></v-select>
      </v-col>
      <v-btn @click="orderPage({o_idx:o_idx, amount:o_amount})">
          주문하기
      </v-btn>
    </div>
</template>

<script>
import {mapState,mapActions,mapMutations} from "vuex"
  export default {
    data() {
        return {
            b_title: localStorage.getItem("order_b_title"),
            b_content: localStorage.getItem("order_b_content"),
            b_price: localStorage.getItem("order_b_price"),
            o_idx: localStorage.getItem("order_b_idx"),
            b_from: localStorage.getItem("order_b_from"),
            amount: ['1', '2', '3', '4', '5'],
            o_amount:null
        }
    },
     methods: {
        productDetail2(payload) {
          this.$store.dispatch("productDetail2", payload)
        },
        orderPage(payload) {
          if(this.o_amount == null) {
            alert("수량을 입력하세요")
          } else {
          localStorage.setItem("amount",payload.amount)
          this.$store.commit('orderPage')
        }
      }
    },
    computed: {
       ...mapState(["productDetail"]),
    },
  }
</script>