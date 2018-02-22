package com.fxc.pics.views.viewPager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class NoScrollViewPager : ViewPager {
	var isPagingEnabled = false
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

	override fun onTouchEvent(ev: MotionEvent?): Boolean {
		return isPagingEnabled && super.onTouchEvent(ev)
	}

	override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
		return isPagingEnabled && super.onInterceptTouchEvent(ev)
	}
}