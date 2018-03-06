package com.fxc.pics.views.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import kotlin.math.abs

/**
 * @author fxc
 * @date 2018/3/5
 */
class ScrollBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
	private val fraction = 0.80f

	override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
		return axes == ViewCompat.SCROLL_AXIS_VERTICAL
	}

	override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
		if (target !is RecyclerView) {
			return
		}
		val offset = target.computeVerticalScrollOffset()
		if (offset == 0) {
			if (child.top != 0) {
				ViewCompat.offsetTopAndBottom(child, -child.top)
				return
			}
		}
		ViewCompat.offsetTopAndBottom(child, (-dyConsumed * fraction).toInt())
	}

	override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, type: Int) {
		super.onStopNestedScroll(coordinatorLayout, child, target, type)
		val rr = target as RecyclerView
		if (child.top < 0 && rr.computeVerticalScrollOffset() == 0) {
			ViewCompat.offsetTopAndBottom(child, abs(child.top))
		}
		if (child.top > 0 && rr.computeVerticalScrollOffset() == 0) {
			ViewCompat.offsetTopAndBottom(child, -abs(child.top))
		}
	}

}