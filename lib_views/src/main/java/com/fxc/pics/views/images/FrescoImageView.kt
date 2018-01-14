package com.fxc.pics.views.images

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.GenericDraweeView

/**
 * 已生成配置：
 *  ScaleType: CENTER_CROP
 * @author fxc
 * @date 2018/1/14
 */
class FrescoImageView : GenericDraweeView {
	constructor(ctx: Context) : this(ctx, null)
	constructor(ctx: Context, attrs: AttributeSet?) : this(ctx, attrs, 0)

	constructor(ctx: Context, attr: AttributeSet?, defStyle: Int): super(ctx, attr, defStyle)


	init {
		hierarchy = setNormalHierarchy()
	}

	private fun setNormalHierarchy(): GenericDraweeHierarchy {
		return GenericDraweeHierarchyBuilder.newInstance(resources)
				.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
				.build()
	}


}