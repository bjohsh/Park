<template>
<div>
  <v-container>
    <v-data-table
      :headers="headers"
      :items="UserList"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </v-container>
</div>
</template>

<script>
  import {mapState, mapActions} from 'vuex'
  export default {
    data () {
      return {
        headers: [
          {
            text: '성함',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: '아이디', value: 'username' },
          { text: '연락처', value: 'phone' },
          { text: '주소', value: 'address' },
          { text: '가입날짜', value: 'datetime' },
          { text: '구매율(%)', value: '' }
        ],
      }
    },
    created() {
      this.$store.dispatch('admin')
    },
    computed: {
      ...mapState(['UserList'])
    }
  }
</script>