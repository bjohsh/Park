<template>
    <div>
        <h1>주문통계</h1>
        <h2> [ 월별 ]</h2>
        <h2> [ 주간 ]</h2>
    </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    computed: {
        ...mapState(['orderMonth'])
    },
    created() {
        this.$store.dispatch('orderMonth')
    }
}
</script>