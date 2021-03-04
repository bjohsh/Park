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

                <div
                  v-for="product in productCategory"
                  >
                 <v-list-item
                  link
                  router :to="{name: 'Menu1'}"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{product.p_category}}
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
                </div>

              </v-list>
            </v-sheet>
</template>

<script>
import {mapState} from 'vuex'
export default {
  data() {
    return {
      p_category: null
    }
  },
  computed: {
    ...mapState(['productCategory'])
  },
  created() {
    this.$store.dispatch('productCategory')
  },
  methods: {
     product_p_category() {
       localStorage.getItem(this.product.p_category)
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