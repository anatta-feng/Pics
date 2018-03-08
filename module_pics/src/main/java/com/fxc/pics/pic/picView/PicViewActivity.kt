package com.fxc.pics.pic.picView

import android.graphics.drawable.Animatable
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.imagepipeline.image.ImageInfo
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.pic.R
import kotlinx.android.synthetic.main.pic_activity_view_layout.*

/**
 * @author fxc
 * @date 2018/3/7
 */
class PicViewActivity : PresenterActivity<PicViewPresenterImp>() {
	companion object {
		const val KEY_SHARED_IMAGE = "pic_view_shared_image"

		const val EXTRA_IMAGE_URL = "pic_view_extra_image_url"
	}

	override fun error(failReason: String) {
	}

	override fun initPresenter(): PicViewPresenterImp = PicViewPresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_activity_view_layout

	override fun afterInitWidget() {
		super.afterInitWidget()
		val url = intent.getStringExtra(EXTRA_IMAGE_URL)
		val controller = Fresco.newDraweeControllerBuilder()
		controller.setUri(url)
		controller.oldController = pic_view_image.controller
		controller.controllerListener = object : BaseControllerListener<ImageInfo>() {
			override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
				super.onFinalImageSet(id, imageInfo, animatable)
				if (imageInfo == null || pic_view_image == null) {
					return
				}
				Log.d("weadc", "width ${imageInfo.width}  height ${imageInfo.height}")
				pic_view_image.update(imageInfo.width, imageInfo.height)
			}
		}
		pic_view_image.controller = controller.build()
	}
}