<template>
<div>
    <h2>주문하시는 분</h2>
    
    <div v-if="Userinfo.User_Id==null">
       <input v-model="o_sendname" placeholder="성함을 입력하세요">
       <input v-model="o_sendphone" placeholder="연락처를 입력하세요">
    </div>
    <div v-else>
      이름: {{ Userinfo.User_Name }}<br>
      핸드폰: {{ Userinfo.User_Phone }}
    </div>

    <h2>받으시는 분</h2>
    <p>이름: {{ o_takename }}</p>
    <input v-model="o_takename" placeholder="성함을 입력하세요">
    <p>핸드폰: {{ o_takephone }}</p>
    <input v-model="o_takephone" placeholder="연락처를 입력하세요">
    <p>주소: {{ o_takeaddress }}</p>
    <input v-model="o_takeaddress" placeholder="주소를 입력하세요">

    <h3>상품명: {{o_title}}</h3>
    <h3>총 주문수량: {{o_amount}}개</h3>
    <h2>총 결제금액: {{allPrice}} 원</h2> 
    <h4>결제 수단</h4>
     <v-btn depressed>
      무통장입금
    </v-btn>
    <v-btn
      depressed
      color="primary"
    >
      휴대폰결제
    </v-btn>
    <v-btn
      depressed
      color="error"
    >
      계좌이체
    </v-btn>
    <h3>주문확인</h3>
    <v-btn
      x-large
      color="success"
      dark
      @click="order({
      o_sendname: o_sendname,
      o_sendphone:o_sendphone,
      o_takename: o_takename,
      o_takephone:o_takephone,
      o_takeaddress:o_takeaddress,
      o_amount:o_amount,
      o_price:allPrice,
      o_title: o_title,
      o_number: o_number
      })">
    주문하기
    </v-btn>
    <v-btn
      x-large
      color="error"
      dark
    >
    취소하기
    </v-btn>
</div>
    


</template>
<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      o_sendname: null,
      o_sendphone:null,
      o_takename: null,
      o_takephone:null,
      o_takeaddress:null,
      o_idx : null,
      o_amount:localStorage.getItem("amount"),
      o_price:localStorage.getItem("order_b_price"),
      o_title: localStorage.getItem("order_b_title"),
      o_number: localStorage.getItem("order_b_idx"),
    }
  },
  computed: {
    ...mapState(["Userinfo"]),
    allPrice: function () {
      return this.o_price * this.o_amount
    }
  },
  methods: {
    order(payload) {
      console.log(payload)
      if(this.Userinfo.User_Id!=null) {
        payload.o_sendname=this.Userinfo.User_Name
        payload.o_sendphone=this.Userinfo.User_Phone
      }
      console.log(payload.o_sendname)
      console.log(payload.o_sendphone)
      if(this.o_takename == null) {
        alert("받으시는 분 성함을 입력하세요.")
      } 
      if (this.o_takephone == null) {
        alert("받으시는 분 연락처를 입력하세요.")
      }
      if(this.o_takeaddress == null) {
        alert("받으시는 분 주소를 입력하세요.")
      } else {
        this.$store.dispatch("order", payload)
      }
    }
  }
}
</script>
<style scoped>
div {
  display:block;
}
</style>