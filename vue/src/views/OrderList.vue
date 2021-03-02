<template>
<div>
    <h2>주문내역</h2>
  <v-card>
    <v-card-title>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="orderList"
      :search="search"
    ></v-data-table>
  </v-card>
</div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    data: () => ({
        search: '',
        headers: [
            {
            text: '주문번호',
            align: 'start',
            filterable: false,
            value: 'o_idx', 
            },
            {text:'성함', value:'o_takename'},
            {text:'연락처', value:'o_takephone'},
            {text:'주소', value:'o_takeaddress'},
            {text:'상품명', value:'o_title'},
            {text:'수량', value:'o_amount'},
            {text:'가격', value:'o_price'},
            {text:'결제수단', value:'o_pay'},
            {text:'주문일', value:'o_date'},
        ],
        o_idx : null
    }),
    computed: {
        ...mapState(['orderList'])
    },
    created() {
        this.$store.dispatch('orderList')
    }
}
</script>