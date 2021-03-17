<template >
  <v-sheet rounded="lg" style="position:fixed;top:10%;display:block;width:15%;">
    <v-list color="transparent">
      <v-list-item
        link
        router :to="{name: 'Home'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            전체
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <div v-for="product in productCategory" :key="product.p_idx">
        <v-btn @click="productMenu1({p_idx:product.p_idx})">
          <v-list-item-content>
            <v-list-item-title>
              {{product.p_category}}
            </v-list-item-title>
          </v-list-item-content>
        </v-btn>
      </div>

    </v-list>
  </v-sheet>
</template>

<script>
import {mapState} from 'vuex'
export default {
  computed: {
    ...mapState(["productCategory"]),
  },
  created () {
     this.$store.dispatch('productCategory')    
  },
  methods: {
    productMenu1(payload) {
      this.$store.dispatch("productMenu1", payload)
    }
  }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&display=swap');
div {
  font-family: 'Cute Font', cursive;
  font-size:1.5rem;
  font-weight:700;
  color:#595959;
  text-align: center;
}
</style>