package com.fxc.pics.views.behavior

import android.support.design.widget.CoordinatorLayout
import android.view.View

/**
 * @author fxc
 * @date 2018/3/2
 */
class DrawerBehavior<V : View> : CoordinatorLayout.Behavior<V>() {
	override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
		return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
	}

	override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
	}
}