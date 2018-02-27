package com.fxc.pics.views.recyclerView.itemDecoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *
 * @author fxc
 * @date 2018/2/27
 */
class SpaceItemDecoration : RecyclerView.ItemDecoration {
	constructor(verticalSpace: Int, horizontalSpace: Int) {
		mOutRect = Rect(horizontalSpace, verticalSpace, horizontalSpace, verticalSpace)
	}

	constructor(leftSpace: Int, topSpace: Int, rightSpace: Int, bottomSpace: Int) {
		mOutRect = Rect(leftSpace, topSpace, rightSpace, bottomSpace)
	}

	private lateinit var mOutRect: Rect

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		super.getItemOffsets(outRect, view, parent, state)
		outRect.set(mOutRect)
		if (parent.getChildLayoutPosition(view) == 0) {
			outRect.top = 0
		}
	}
}