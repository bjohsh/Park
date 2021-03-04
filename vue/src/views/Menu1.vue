<template>
  <div>
     <v-main>
      <v-container>
       <div class="product_list_text"> 수제천연껌 </div>
       <div class="product_container_box">
         <div 
            v-for="product in productMenu1" 
            class="product_box"
         >
          <v-btn @click="productDetail2({b_idx: b_idx})">
           <div class="product_box_img"  ></div>
           <div class="product_box_text"> 
             {{ product.b_title }}
             <p class="product_box_price">{{ product.b_price }}원</p>
           </div>
          </v-btn>
         </div><!-- end of prouduct_box -->
       
       </div>
      </v-container>
    </v-main>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  computed: {
    ...mapState(['productMenu1'])
  },
  created() {
    this.$store.dispatch('productMenu1')
  },
  methods: {
    productDetail2(payload) {
      console.log(payload)
      this.$store.dispatch("productDetail2", payload)
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Potta+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Sunflower:wght@300;500&display=swap');

.product_list_text {
  font-size: 1.5rem;
  color:#B80C00;
  font-weight: 700;
  font-family: 'Potta One', cursive;
  text-align: center;
}
.product_list_text::after {
  display: inline-block;
  margin: 0 0 8px 20px;
  height: 2px;
  content: " ";
  text-shadow: none;
  background-color:#B80C00;
  width:35%;
}
.product_list_text::before {
  display: inline-block;
  margin: 0 20px 8px 0;
  height: 2px;
  content: " ";
  text-shadow: none;
  background-color:#B80C00;
  width:35%;
}
.product_container_box {
  margin-top:30px;
  padding:0 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
.product_box {
  flex-basis:30%;
  height:300px;
  box-shadow: 3px 3px 4px #818181;
  margin-bottom:15px;
}
.product_box_img {
  height: 230px;
  background-color:#ededed;
}
.product_box_text {
  height: 70px;
  line-height: 35px;
  font-size:1.3rem;
  font-weight: 700;
  text-align: right;
  margin:0 30px;
  font-family: 'Sunflower', sans-serif;
}
.product_box_price {
  font-weight: 400;
  }
</style>