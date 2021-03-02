<template>
<v-app style="width:100%;position:absolute;z-index:100;left:0;height:95%;top:-5px;">
  <div class="login_top">
    <h1>주문이 접수되었습니다.</h1>
  </div>
  <div class="ordersuccess">
      <div class="login_btn_box">
        <p> 성함:{{o_takename}}</p>
        <p> 연락처:{{o_takephone}}</p>
        <p> 주소:{{o_takeaddress}}</p>
        <p> 상품명:{{o_title}}</p>
        <p> 수량:{{o_amount}}</p>
        <p> 가격:{{o_price}}</p>
        <v-btn class="login_btn" router :to="{name: 'Home'}">홈으로</v-btn>
        
      </div>
  </div>

</v-app>
</template>

<script>
import {mapActions,mapState} from "vuex"
  export default {
    data() {
      return {
        o_idx : localStorage.getItem("order_o_idx"),
        o_takename : localStorage.getItem("order_o_takename"),
        o_takephone : localStorage.getItem("order_o_takephone"),
        o_takeaddress : localStorage.getItem("order_o_takeaddress"),
        o_title : localStorage.getItem("order_b_title"),
        o_amount : localStorage.getItem("order_o_amount"),
        o_price : localStorage.getItem("order_o_price"),
        
      }
    },
    methods: {
      orderPage(payload) {
        this.$store.dispatch("orderpage", payload)
      }
    },
    computed: {
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
.ordersuccess {
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
  display:center;
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