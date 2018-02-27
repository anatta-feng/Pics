package com.fxc.pics.views.behavior

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View

/**
 *
 * @author fxc
 * @date 2018/2/27
 */
class BottomNavigationViewBehavior : CoordinatorLayout.Behavior<View> {
	constructor() : super()
	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

	override fun onLayoutChild(parent: CoordinatorLayout, child: View, layoutDirection: Int): Boolean {
		((child.layoutParams) as CoordinatorLayout.LayoutParams).topMargin = parent.measuredHeight.minus(child.measuredHeight)
		return super.onLayoutChild(parent, child, layoutDirection)
	}

	override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
		return dependency is AppBarLayout
	}

	override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
		val params = dependency.layoutParams as CoordinatorLayout.LayoutParams
		val behavior = params.behavior as AppBarLayout.Behavior
		val top = behavior.topAndBottomOffset
		child.translationY = -top.toFloat()
		return false
	}

}