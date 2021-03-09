import Vue from 'vue'
import Vuex from 'vuex'
import Route from '../router/index'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Userinfo:{User_Id:null,User_Name:null,User_Phone: null, User_auth:[],User_token:null},
    boardlist:[],
    board_detail:[],
    UserList:[],
    productPage:[],
    isLogin: false,
    isLoginError: false,
    productDetail:[],
    productCategory:[],
    productPage: [],
    orderList:[],
    productMenu1:[]

  },
  mutations: {
    NewUsers: (state,payload) => {
      state.UserList.push(payload)
      Route.push("/login")
    },
    SET_USER(state, data) {
      console.log(data)
      state.Userinfo.User_Id = data.username
      state.Userinfo.User_Name = data.name
      state.Userinfo.User_Phone = data.phone
      state.Userinfo.User_auth = data.authorities
      state.Userinfo.User_token = data.token
      if(state.Userinfo.User_Id === "111") {
        Route.push("/productPage")
      } else {
        Route.push("/")
      } 
   },
   READ_USER_LIST(state,data) {
    state.UserList = data
   },
   READ_PRODUCT_PAGE(state,data) {
     state.productPage = data
   },
   READ_PRODUCT_DETAIL(state,data) {
    state.productDetail = data
    Route.push("/productEdit")
   },
   READ_PRODUCT_DETAIL2(state,data) {
    state.productDetail = data
    Route.push("/productDetail2")
   },
   READ_ORDER_PAGE(state,data){
     state.orderpage = data
   },
   READ_ORDER_LIST(state,data) {
     state.orderList = data
   },
   READ_ORDER_MONTH(state,data) {
     state.orderMonth = data
   },
   READ_PRODUCT_MENU1(state,data) {
    state.productMenu1 = data
    Route.push("/productMenu1")
   },
   READ_PRODUCT_CATEGORY(state,data) {
    state.productCategory = data
   },
   INSERT_TOKEN(state) {
     console.log("insertToken")
     state.Userinfo.User_token = localStorage.getItem("token")
   },
   SET_USER_REFRESH(state,data) {
     
    state.Userinfo.User_Id = data.username
    state.Userinfo.User_Name = data.name
    state.Userinfo.User_Phone =data.phone
    state.Userinfo.User_auth = data.authorities
    state.Userinfo.User_token = data.token
   },
   logout(state) {
    state.Userinfo.User_Id = null
    state.Userinfo.User_Name = null
    state.Userinfo.User_auth = null
    state.Userinfo.User_token = null
    localStorage.removeItem("token")
    console.log(state.Userinfo)
    console.log("로그아웃됐니?"+localStorage.getItem("token"))
   },
   loginSuccess(state) {
     state.isLogin = true
     state.isLoginError = false
   },
   loginError(state) {
     state.isLogin = false
     state.isLoginError = true
   },
   orderPage(state) {
    
    if(state.Userinfo.User_Id != null) {
      Route.push("/orderpage")
    } else {
      alert("로그인이 필요합니다.")
      Route.push("/login")
    }
   }
  },
  actions: {
    loginProcess({ commit }, payload) {
      console.log(payload)
      return new Promise((resolve, reject) => {
          axios.post('http://3.36.159.227:9000/api/auth/signin', payload)
              .then(Response => {
                  console.log(Response.data)
                  if (Response.data.username != null) {
                      axios.defaults.headers.common['Authorization'] = `Bearer ${Response.data.token}`
                      localStorage.setItem("token",Response.data.token)
                      commit('SET_USER', Response.data) 
                      Route.push("/")     
                  }
              })
              .catch(Error => {
                  console.log('error')
                  reject(Error)
              })
      })
   },
  
   SignUp({commit},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
        axios.post('http://3.36.159.227:9000/api/auth/signup', payload)
            .then(Response => {
                console.log(Response.data)
                if(Response.data === "success") {
                  Route.push("/login")
                }
            })
            .catch(Error => {
                console.log('error')
                reject(Error)
                alert("아이디가 중복")
                Route.push("/signup")
            })
    })
   },
  admin({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://3.36.159.227:9000/api/admin/adminPage')
          .then(Response => {
            console.log(Response.data)
             commit('READ_USER_LIST',Response.data)
          })
          .catch(Error => {
              console.log('admin_error')
          })
  })
  },
  productPage({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/auth/productPage')
        .then(Response => {
         
          commit('READ_PRODUCT_PAGE',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
  UnpackToken({commit}) {
    return new Promise((resolve, reject) => {
      console.log(localStorage.getItem("token"))
      axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem("token")}`
      axios.get('http://3.36.159.227:9000/api/auth/unpackToken')
          .then(Response => {
            console.log(Response.data)
            commit('SET_USER_REFRESH',Response.data)
          })
          .catch(Error => {
            console.log(Error)
              console.log('unpackToken_error')
          })
  })
  },
  write({commit},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:9000/api/auth/boardinsert',payload)
        .then(Response => {
          console.log(Response.data)
          if(Response.data === "success") {
            Route.push("/ProductPage")
          }
        })
        .catch(Error => {
          console.log('error')
          reject(Error)
          alert("등록이 안됨")
        })
    })
  },
  productEdit({commit,state},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.post('http://3.36.159.227:9000/api/auth/productEdit', payload)
      .then(Response => {
        console.log(Response.data)
        commit('READ_PRODUCT_PAGE',Response.data)
        localStorage.removeItem("edit_b_idx",Response.data.b_idx)
        localStorage.removeItem("edit_b_title",Response.data.b_title)
        localStorage.removeItem("edit_b_id",Response.data.b_id)
        localStorage.removeItem("edit_b_content",Response.data.b_content)
        localStorage.removeItem("edit_b_price",Response.data.b_price)
        localStorage.removeItem("edit_b_inventory",Response.data.b_inventory)
        localStorage.removeItem("eidt_b_from",Response.data.b_from)
        console.log('localstorage edit remove?',localStorage.getItem("edit_b_idx"))
        Route.push("/productpage")
      })
       .catch(Error => {
         console.log('error')
         reject(Error)
       })
    })
  },
  productDetail({commit,state},payload) {
    console.log(payload);
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.post('http://3.36.159.227:9000/api/auth/productDetail', payload)
        .then(Response => {
          console.log(Response.data.b_idx)
          localStorage.setItem("edit_b_idx",Response.data.b_idx)
          localStorage.setItem("edit_b_title",Response.data.b_title)
          localStorage.setItem("edit_b_id",Response.data.b_id)
          localStorage.setItem("edit_b_content",Response.data.b_content)
          localStorage.setItem("edit_b_price",Response.data.b_price)
          localStorage.setItem("edit_b_inventory",Response.data.b_inventory)
          localStorage.setItem("edit_b_from",Response.data.b_from)


          commit('READ_PRODUCT_DETAIL',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
  productDetail2({commit,state},payload) {
    console.log(payload);
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.post('http://3.36.159.227:9000/api/auth/productDetail', payload)
        .then(Response => {
          console.log(Response.data.b_idx)
          localStorage.setItem("order_b_idx",Response.data.b_idx)
          localStorage.setItem("order_b_title",Response.data.b_title)
          localStorage.setItem("order_b_id",Response.data.b_id)
          localStorage.setItem("order_b_content",Response.data.b_content)
          localStorage.setItem("order_b_price",Response.data.b_price)
          localStorage.setItem("order_b_inventory",Response.data.b_inventory)
          localStorage.setItem("order_b_from",Response.data.b_from)


          commit('READ_PRODUCT_DETAIL2',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
  productDelete({commit}, payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
     axios.post('http://3.36.159.227:9000/api/auth/productDelete', payload)
      .then(Response => {
        console.log(Response.data)
        commit('READ_PRODUCT_PAGE',Response.data)
      })
       .catch(Error => {
         console.log('error')
         reject(Error)
       })
    })
  },
  order({commit},payload) {
    console.log(payload)
    localStorage.setItem("order_o_idx",payload.o_idx)
    localStorage.setItem("order_o_takename", payload.o_takename)
    localStorage.setItem("order_o_takephone", payload.o_takephone)
    localStorage.setItem("order_o_takeaddress", payload.o_takeaddress)
    localStorage.setItem("order_o_title", payload.o_title)
    localStorage.setItem("order_o_amount", payload.o_amount)
    localStorage.setItem("order_o_price", payload.o_price)
    return new Promise((resolve, reject) => {
      axios.post('http://3.36.159.227:9000/api/auth/order',payload)
        .then(Response => {
          if(Response.data === "success") {
            Route.push("/ordercompleted")
          }
        })
        .catch(Error => {
          console.log('error')
          reject(Error)
          alert("주문안됨")
        })
    })
  },
  orderList({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://3.36.159.227:9000/api/auth/orderList')
        .then(Response => {
          console.log(Response.data)
          commit('READ_ORDER_LIST',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
  orderMonth({commit, state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://3.36.159.227:9000/api/auth/orderMonth')
      .then(Response => {
        console.log(Response.data)
        commit('READ_ORDER_MONTH', Response.data)
      })
      .catch(Error => {
        console.log('error')
      })
    })
  },
  productMenu1({commit,state},payload) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.post('http://localhost:9000/api/auth/productMenu1', payload)
        .then(Response => {
          console.log(payload)
          commit('READ_PRODUCT_MENU1',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
  productCategory({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/auth/productCategory')
        .then(Response => {
          //console.log(Response.data)
          commit('READ_PRODUCT_CATEGORY',Response.data)
        })
        .catch(Error => {
          console.log('error')
        })
    })
  },
}
})
