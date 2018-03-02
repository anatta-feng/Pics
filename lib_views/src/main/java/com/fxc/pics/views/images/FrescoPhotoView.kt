package com.fxc.pics.views.images

import android.content.Context
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.imagepipeline.image.ImageInfo
import me.relex.photodraweeview.PhotoDraweeView

/**
 * @author fxc
 * @date 2018/3/2
 */
class FrescoPhotoView : PhotoDraweeView {
	companion object {
		private const val TAG = "FrescoImageView"
	}

	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
		initScaleType()
	}

	constructor(context: Context?, hierarchy: GenericDraweeHierarchy?) : super(context, hierarchy)

	var listener: (id: String, imageInfo: ImageInfo?, animatable: Animatable?) -> Unit = { _, _, _ ->

	}

	private fun initScaleType() {
		hierarchy.actualImageScaleType = ScalingUtils.ScaleType.CENTER_CROP
	}

	/**
	 * 直接下载指定图片
	 * @param url 指定图片 url
	 */
	fun setUrl(url: String) {
		val listenerController = Fresco.newDraweeControllerBuilder()
				.setOldController(controller)
				.setControllerListener(FrescoControllerListener())
				.setUri(url)
				.build()
		controller = listenerController
//		setImageURI(url)
	}

	private inner class FrescoControllerListener : BaseControllerListener<ImageInfo>() {
		override fun onFinalImageSet(id: String, imageInfo: ImageInfo?, animatable: Animatable?) {
			if (imageInfo == null) {
				Log.w(TAG, "FrescoControllerListener imageInfo is null")
				return
			}
			listener.invoke(id, imageInfo, animatable)
		}
	}
}