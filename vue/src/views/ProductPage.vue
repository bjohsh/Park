<template>
  <v-data-table
    :headers="headers"
    :items="productPage"
    sort-by="calories"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
        flat
      >
        <v-toolbar-title>상품관리</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        ></v-divider>
        <v-spacer></v-spacer>
        <v-dialog
          v-model="dialog"
          max-width="500px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="primary"
              dark
              class="mb-2"
              v-bind="attrs"
              v-on="on"
              router :to="{name: 'BoardWrite'}"
            >
              상품등록
            </v-btn>
          </template>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:[`item.actions`]="{ item }">
      <v-btn
        small
        color="#1E88E5"
        @click="productDetail({b_idx:item.b_idx})" 
      >
      <v-icon
        small
        color="#FFFFFF"
        class="mr-2"
        
      >
        mdi-pencil
      </v-icon>
      </v-btn>
      <v-btn
        small
        color="#BDBDBD"
        @click="productDelete({b_idx:item.b_idx})"
      >
      <!-- {{item.b_idx}} -->
      <v-icon
        small
        color="#D84315"
        class="mr-2"
      >
        mdi-delete
      </v-icon>
      </v-btn>
    </template>
  </v-data-table>
</template>


<script>
import {mapState, mapActions} from 'vuex'
  export default {
    data: () => ({
      dialog: false,
      dialogDelete: false,
      headers: [
        {
          text: 'NO.',
          align: 'start',
          sortable: false,
          value: 'b_idx',
        },
        { text: 'image', value: '' },
        { text: 'category', value: 'b_category' },
        { text: 'name', value: 'b_title' },
        { text: 'content', value: 'b_content' },
        { text: 'price', value: 'b_price' },
        { text: 'inventory', value: 'b_inventory' },
        { text: 'Actions', value: 'actions', sortable: false },
      ],
      b_idx:null
    }),

    computed: {
       ...mapState(['productPage'])
    },

    created () {
      this.$store.dispatch('productPage')
    },

     methods: {
        productDelete(payload) {
            console.log(payload)
            this.$store.dispatch("productDelete", payload)
        },
        productDetail(payload) {
            console.log(payload)
            this.$store.dispatch("productDetail", payload)
        }
    }
  }
</script>