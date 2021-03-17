<template >
            <v-sheet rounded="lg" style="position:fixed;top:10%;display:block;width:15%;">
              <v-list color="transparent">
                <v-list-item
                  link
                  router :to="{name: 'Home'}"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      나의 정보
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                 <v-list-item
                  link
                  router :to="{name: 'Menu1'}"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      나의 주문
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-list-item
                  link
                >
                  <v-list-item-content>
                    <v-list-item-title>
                        1 : 1 문의
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