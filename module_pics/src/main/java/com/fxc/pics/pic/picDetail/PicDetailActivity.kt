package com.fxc.pics.pic.picDetail

import android.util.Log
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.common.events.EventUtil
import com.fxc.pics.pic.R
import com.fxc.pics.pic.events.PicEvents
import com.fxc.pics.pic.network.entities.PicListEntity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDetailActivity : PresenterActivity<PicDetailPresenterImp>() {

	companion object {
		private const val TAG = "PicDetailActivity"
		const val KEY_IMAGE = "key_image"
		const val KEY_PIC_ID = "pic_id"
		const val KEY_PIC_URL = "pic_url"
	}

	private var data = ArrayList<PicListEntity>()

	override fun initPresenter(): PicDetailPresenterImp {
		return PicDetailPresenterImp(this)
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic_detail
	}

	override fun beforeInitWidget() {
		super.beforeInitWidget()
		postponeEnterTransition()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		Log.d(TAG, "afterInitWidget post PicDetailReadyEvent")
		EventUtil.post(PicEvents.PicDetailReadyEvent())
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	fun recieveList(event: PicEvents.PicEnterDetailEvent) {
		Log.d(TAG, "recieveList ${event.data.size}")
		data.addAll(event.data)
	}

	override fun error(failReason: String) {
	}

	fun setImageUrl(url: String) {

//		val controller = Fresco.newDraweeControllerBuilder()
//		controller.setUri(url)//设置图片url
//		controller.oldController = pic_detail_image.controller
//		controller.controllerListener = object : BaseControllerListener<ImageInfo>() {
//			override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
//				super.onFinalImageSet(id, imageInfo, animatable)
//				if (imageInfo == null || pic_detail_image == null) {
//					return
//				}
//				Log.d("asdzx", "onFinalImageSet ${imageInfo.height}")
//				pic_detail_image.update(imageInfo.width, imageInfo.height)
//			}
//		}
//		pic_detail_image.controller = controller.build()
	}
}