<template>
	<view>
		<l-file ref="lFile" :logo="logo" @up-success="onSuccess"></l-file>

		<view class="padding text-center">
			<view class="padding">
				<button @tap="onUpload">上传文件</button>
			</view>
			<view class="padding" style="font-size: 32rpx;text-align: center; color: #3cc51f;">
				<text style="color: blue">{{ tip }}
					<image src="/static/images/icon/success.png" style="width: 26rpx;height: 26rpx;margin-left: 6rpx"
						v-if="tip!==undefined"></image>
				</text>
				<br>
			</view>
			<text>点击文件名字即可查看打印预览</text>
			<view class="padding">
				<view class="uni-form-item uni-column">
					<radio-group name="radio" @change="chang">
						<label v-for="(item, index) in radios" :key="index">
							<radio :value="item"  style="margin: 12rpx;"/><text>{{item}}</text>
						</label>
					</radio-group>
				</view>
				<br>
				<button @tap="printer">开始打印</button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			this.api = '';
			return {
				logo: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F00%2F00%2F07%2F155788a6d8a5c42.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619847627&t=2da40b583002205c204d980b54b35040',
				localPath: '',
				tip: undefined,
				fileFlag: undefined,
				radios: [],
				radio: undefined
			}
		},
		onLoad() {
			this.getConfig();
		},
		methods: {
			onLogin() {},
			// 单选按钮发生改变时触发的方法
			chang(e) {
				this.radio = e.detail.value; //选中按钮的value值
				console.log(this.radio);
			},
			getConfig() {
				uni.request({
					url: "/core/config",
					method: 'GET',
					success: (res) => {
						this.radios = res.data.data
					}
				})
			},
			onOpenNameDoc(path = '') {
				if (!path) {
					return;
				}
				/* 打开文件 */
				this.$refs.lFile.open(path);
			},
			onOpenDoc() {
				let url = '/files/' + this.fileFlag;
				/* 下载返回临时路径（退出应用失效） */

			},

			/* 上传 */
			onUpload() {
				/**
				 * url：上传接口地址
				 * name：附件key,服务端根据key值获取文件流，默认file,上传文件的key
				 * header: 上传接口请求头
				 */
				this.$refs.lFile.upload({
					//替换为你的上传接口地址
					url: '/files/upload',
					// 服务端接收附件的key
					name: 'file',
					//根据你接口需求自定义 (优先不传content-type,安卓端无法收到参数再传)
					header: {
						'uid': '27682',
						'client': 'app',
					},
				});
			},
			/* 开始打印 */
			printer() {
				if (this.fileFlag === undefined) {
					uni.showToast({
						title: '请先上传文件',
						icon: 'error'
					})
					return;
				}
				if (this.radio === undefined) {
					uni.showToast({
						title: '请选择打印机',
						icon: 'error'
					})
					return;
				}
				uni.request({
					url: "/core/startPrint",
					method: 'GET',
					data: {
						"uuid": this.fileFlag,
						"printerName": this.radio
					},
					success: (res) => {
						uni.showToast({
							title: res.data.data,
							icon: 'success'
						})
					}
				})
			},
			onSuccess(result) {
				console.log('上传回调', result);
				if (result.data.code != 0) {
					uni.showToast({
						title: '上传失败原因:'+result.data.msg,
						icon: 'error'
					})
					return;
				}
				uni.showToast({
					title: '上传成功',
					icon: 'success'
				})
				this.fileFlag = result.data.data.flag;
				this.tip = result.fileName;
			}
		}
	}
</script>

<style>
	.padding-sm {
		padding: 20upx;
	}

	.padding {
		padding: 30upx;
	}
</style>