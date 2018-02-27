package com.fxc.pics.views.like

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.fxc.pics.views.R

/**
 *
 * @author fxc
 * @date 2018/2/27
 */
class LikeView : LinearLayout {
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init(attrs)
	}

	private fun init(attrs: AttributeSet) {
		val array = context.obtainStyledAttributes(attrs, R.styleable.LikeView)
		array.recycle()
	}

}