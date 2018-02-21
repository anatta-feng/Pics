package com.fxc.pics.views.collapse

import android.content.Context
import android.support.v4.view.NestedScrollingChild
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
class CollapseingHead : FrameLayout, NestedScrollingChild {
	constructor(context: Context) : super(context)
	constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

	override fun onTouchEvent(event: MotionEvent): Boolean {
		when (event.action) {
			MotionEvent.ACTION_DOWN -> {
				val nestedScrollAxis = ViewCompat.SCROLL_AXIS_VERTICAL
				startNestedScroll(nestedScrollAxis)
			}
//			MotionEvent.ACTION_MOVE -> {
//				if (dispatchNestedPreScroll())
//			}
		}
		return super.onTouchEvent(event)
	}
}