(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-index-index"],{"40e0":function(n,t,e){"use strict";var a;e("7a82"),Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var c=0,i={onReady:function(){plus.navigator.closeSplashscreen()},watch:{"$store.state.funlist":{handler:function(n,t){c=0},deep:!0}},onLoad:function(){a=this},onShow:function(){console.log("显示")},data:function(){return{color:["#6739b6","#6739b6","#e03997","#e03997","#e54d42","#e54d42","#8799a3","#8799a3","#fbbd08","#fbbd08","#f37b1d","#f37b1d","#39b54a","#39b54a","#1cbbb4","#1cbbb4","#a5673f","#a5673f","#8dc63f","#8dc63f","#0081ff","#0081ff","#1cbbb4","#1cbbb4","#6739b6","#6739b6","#e03997","#e03997","#e54d42","#e54d42","#8799a3","#8799a3","#fbbd08","#fbbd08","#f37b1d","#f37b1d","#39b54a","#39b54a","#1cbbb4","#1cbbb4","#a5673f","#a5673f","#8dc63f","#8dc63f","#0081ff","#0081ff","#1cbbb4","#1cbbb4"]}},methods:{colorF:function(n,t){if(n.display){var e=a.color[c];return c+=1,e}}}};t.default=i},6667:function(n,t,e){"use strict";e.r(t);var a=e("40e0"),c=e.n(a);for(var i in a)["default"].indexOf(i)<0&&function(n){e.d(t,n,(function(){return a[n]}))}(i);t["default"]=c.a},"6ade":function(n,t,e){"use strict";e.r(t);var a=e("d990"),c=e("6667");for(var i in c)["default"].indexOf(i)<0&&function(n){e.d(t,n,(function(){return c[n]}))}(i);var o=e("f0c5"),f=Object(o["a"])(c["default"],a["b"],a["c"],!1,null,"361e1261",null,!1,a["a"],void 0);t["default"]=f.exports},d990:function(n,t,e){"use strict";e.d(t,"b",(function(){return a})),e.d(t,"c",(function(){return c})),e.d(t,"a",(function(){}));var a=function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("v-uni-view",{staticStyle:{"padding-top":"50upx"}},[e("v-uni-scroll-view",{staticClass:"page",attrs:{"scroll-y":!0,bgColor:"bg-gradual-blue"}},[e("v-uni-view",{staticClass:"nav-list"},n._l(n.$store.state.funlist,(function(t,a){return t.display?e("v-uni-navigator",{key:a,staticClass:"nav-li",staticStyle:{color:"#FFFFFF"},style:{"background-color":n.colorF(t,a)},attrs:{"hover-class":"none",url:t.name,navigateTo:!0}},[e("v-uni-view",[n._v(n._s(t.title))]),e("v-uni-view",{staticClass:"nav-name"},[n._v(n._s(t.describe))]),e("v-uni-text",{class:"cuIcon-"+t.cuIcon})],1):n._e()})),1)],1)],1)},c=[]}}]);