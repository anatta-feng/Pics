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
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.fxc.pics.views.color.ColorUtils.parsePicColor

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
class FrescoImageView : SimpleDraweeView {
	constructor(ctx: Context) : this(ctx, null)
	constructor(ctx: Context, attrs: AttributeSet?) : this(ctx, attrs, 0)
	constructor(ctx: Context, attr: AttributeSet?, defStyle: Int) : super(ctx, attr, defStyle)

	/**
	 * 直接下载指定图片
	 * @param url 指定图片 url
	 */
	fun setUrl(url: String) {
		setImageURI(url)
	}

}