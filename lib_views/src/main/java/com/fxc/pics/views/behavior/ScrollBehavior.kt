package com.fxc.pics.views.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
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

	override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
		val rr = target as RecyclerView
		val offset = rr.computeVerticalScrollOffset()
		val canScrollToDown = target.canScrollVertically(-1)
		val canScrollToUp = target.canScrollVertically(1)
		var delta = dy
		if (canScrollToDown && dy < 0) {
			if (abs(dy) > offset) {
				var temp = 0
				if (child.top < 0) {
					temp = child.top
				}
				delta = offset + temp
			}
			ViewCompat.offsetTopAndBottom(child, (-delta * fraction).toInt())
			return
		}
		if (canScrollToUp && dy > 0) {
			Log.d("qweasd", "canScrollToUp $delta")
			ViewCompat.offsetTopAndBottom(child, (-delta * fraction).toInt())
		}
	}

	override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: View, target: View, velocityX: Float, velocityY: Float): Boolean {
		return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
	}
}