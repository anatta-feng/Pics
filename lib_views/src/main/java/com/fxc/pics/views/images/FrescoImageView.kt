package com.fxc.pics.views.images

import android.content.Context
import android.graphics.drawable.Animatable
import android.net.Uri
import android.util.AttributeSet
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.GenericDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.fxc.pics.views.color.parsePicColor

/**
 * 调用方式: [setUrl]
 *
 * 已生成配置：
 *  ScaleType: [ScalingUtils.ScaleType.CENTER_CROP]
 *  渐进加载
 *
 * @author fxc
 * @date 2018/1/14
 */
class FrescoImageView : GenericDraweeView {
	constructor(ctx: Context) : this(ctx, null)
	constructor(ctx: Context, attrs: AttributeSet?) : this(ctx, attrs, 0)
	constructor(ctx: Context, attr: AttributeSet?, defStyle: Int) : super(ctx, attr, defStyle)

	private val mControllerListener = ControllerListener(this)
	private var mColorParseListener: ((Int) -> Unit)? = null

	init {
		hierarchy = setNormalHierarchy()
		controller = Fresco.newDraweeControllerBuilder()
				.build()
	}

	private fun setNormalHierarchy(): GenericDraweeHierarchy {
		return GenericDraweeHierarchyBuilder.newInstance(resources)
				.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
				.build()
	}

	/**
	 * 直接下载指定图片
	 * @param url 指定图片 url
	 */
	fun setUrl(url: String) {
		val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
				.setProgressiveRenderingEnabled(true)
				.build()
		controller = Fresco.newDraweeControllerBuilder()
				.setImageRequest(request)
				.setControllerListener(mControllerListener)
				.build()
	}

	fun setMultiUrl(lowResUrl: String, highResUrl: String) {
		val lowRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(lowResUrl))
				.setProgressiveRenderingEnabled(true)
				.build()
		val highRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(highResUrl))
				.setProgressiveRenderingEnabled(true)
				.build()
		controller = Fresco.newDraweeControllerBuilder()
				.setLowResImageRequest(lowRequest)
				.setImageRequest(highRequest)
				.setControllerListener(mControllerListener)
				.build()
	}

	private fun onFinalImageSet() {
		isDrawingCacheEnabled = true
		postDelayed({

			parsePicColor(drawingCache, {
				it
						.filter { it != 0 }
						.forEach { notifyVibrantColor(it) }
			})

		}, 1000)
	}

	private fun notifyVibrantColor(rgb: Int) {
		mColorParseListener?.invoke(rgb)
	}

	fun parseColor(listener: (Int) -> Unit) {
		mColorParseListener = listener
	}

	private class ControllerListener(view: FrescoImageView) : BaseControllerListener<ImageInfo>() {
		private val mView: FrescoImageView = view

		override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
			super.onFinalImageSet(id, imageInfo, animatable)
			mView.onFinalImageSet()
		}

	}

}