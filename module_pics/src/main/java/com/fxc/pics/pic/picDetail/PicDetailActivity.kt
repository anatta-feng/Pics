package com.fxc.pics.pic.picDetail

import android.os.Bundle
import android.support.v4.util.Pair
import android.transition.ChangeBounds
import android.util.Log
import android.view.ViewTreeObserver
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.view.DraweeTransition
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.pic.R
import kotlinx.android.synthetic.main.pic_activity_pic_detail.*


/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDetailActivity : PresenterActivity<PicDetailPresenterImp>() {

	companion object {
		const val KEY_IMAGE = "key_image"
		const val KEY_PIC_ID = "pic_id"
		const val KEY_PIC_URL = "pic_url"
	}

	override fun initPresenter(): PicDetailPresenterImp {
		return PicDetailPresenterImp(this)
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic_detail
	}

	override fun beforeInitWidget() {
		super.beforeInitWidget()
		pic_detail_image.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
			override fun onPreDraw(): Boolean {
				pic_detail_image.viewTreeObserver.removeOnPreDrawListener(this)
				startPostponedEnterTransition()

				return true
			}

		})
		postponeEnterTransition()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(pic_detail_image, KEY_IMAGE))
		setImageUrl(intent.getStringExtra(KEY_PIC_URL))
	}

	override fun error(failReason: String) {
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Log.d("asdzxc", "onCreate")
	}
	fun setImageUrl(url: String) {
		pic_detail_image.setImageURI(url)

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