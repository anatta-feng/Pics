package com.fxc.pics.test

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView

/**
 * @author fxc
 * @date 2018/3/2
 */
class TestBehavior<V : View>(context: Context, attrs:AttributeSet) : CoordinatorLayout.Behavior<V>(context, attrs) {
	override fun layoutDependsOn(parent: CoordinatorLayout?, child: V, dependency: View?): Boolean {
		Log.d("asdzc", "layoutDependsOn target $dependency")
		return dependency is TextView
	}

	override fun onDependentViewChanged(parent: CoordinatorLayout?, child: V, dependency: View): Boolean {
		val offset = dependency.top - child.top
		ViewCompat.offsetTopAndBottom(child, offset)
		Log.d("asdzc", "onDependentViewChanged")
		return true
	}

	override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
		Log.d("asdzc", "onStartNestedScroll")
		return true
	}

	override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
		Log.d("asdzc", "onNestedPreScroll dy $dy")
		super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
	}

}