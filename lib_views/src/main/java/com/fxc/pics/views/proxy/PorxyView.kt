package com.fxc.pics.views.proxy

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @author fxc
 * @date 2018/3/6
 */
class PorxyView : View {
	lateinit var target: View
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//		initAttrs(attrs)
	}

	init {
		isClickable = true
	}

	private fun initAttrs(attrs: AttributeSet) {
//		val array = context.obtainStyledAttributes(attrs, R.styleable.ProxyView)
//		val count = array.indexCount
//		(0 until count)
//				.map { array.getIndex(it) }
//				.forEach {
//					when (it) {
////						R.styleable.ProxyView_target -> target =
//					}
//				}
//		array.recycle()
	}

	override fun performClick(): Boolean {
		return target.performClick()
	}

	override fun performLongClick(): Boolean {
		return target.performLongClick()
	}

}