<template>
  <v-sheet rounded="lg">
    <v-list color="transparent">
      <v-list-item
        link
        router :to="{name: 'BoardWrite'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            상품등록
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        router :to="{name: 'ProductPage'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            상품관리
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

        <v-list-item
        link
        router :to="{name: 'admin'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            회원관리
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        router :to="{name: 'OrderList'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            주문관리
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        router :to="{name: 'OrderTotal'}"
      >
        <v-list-item-content>
          <v-list-item-title>
            주문통계
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      
    </v-list>
  </v-sheet>
</template>
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