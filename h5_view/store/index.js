import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const store = new Vuex.Store({
	state: {
		user: null,
		funlist: [
			{
				title: '自助打印',
				name: '/pages/functions/print/print',
				color: 'red',
				cuIcon: 'text',
				describe: '官方',
				display: true,
				platform: 0
			},
			{
				title: '大小写转换',
				name: '/pages/functions/toggleCase/toggleCase',
				color: 'red',
				cuIcon: 'text',
				describe: '官方',
				display: true,
				platform: 0
			},
			{
				title: '手持弹幕',
				name: '/pages/functions/barrage/barrage',
				color: 'green',
				cuIcon: 'write',
				describe: '官方',
				display: true,
				platform: 0
			},
			{
				title: '价格计算',
				name: '/pages/functions/WaterMarking/WaterMarking',
				color: 'calendar',
				cuIcon: 'file',
				describe: '官方',
				display: true,
				platform: 0 //0通用1ios2andorid
			}
		],
		flashlightIndex: 0,
		flashlightSpeed: 1,
		vibrateIndex: 0,
		vibrateSpeed: 1,
		platfrom: '',
		version: '1.5.4'
	},
	mutations: {},
	actions: {}
})
export default store
