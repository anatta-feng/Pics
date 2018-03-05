package com.fxc.pics.views.recyclerView.itemDecoration

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.views.like.LikeView

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

	private var mOutRect: Rect

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		super.getItemOffsets(outRect, view, parent, state)
		outRect.set(mOutRect)
		if (parent.getChildLayoutPosition(view) == 0) {
			outRect.set(Rect())
		}
		val layoutManager = parent.layoutManager
		if (layoutManager is GridLayoutManager && layoutManager.spanCount == 2) {
			setSymmetrySpace(parent, view, outRect)
		}

		if (layoutManager is StaggeredGridLayoutManager && layoutManager.spanCount == 2) {
			setSymmetrySpaceByStaggered(view, outRect, layoutManager)
		}
	}

	private fun setSymmetrySpaceByStaggered(view: View, outRect: Rect, layoutManager: StaggeredGridLayoutManager) {
		val params = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
		if (params.spanIndex == 0) {
			outRect.left = outRect.left * 2
		} else if (params.spanIndex == layoutManager.spanCount - 1) {
			outRect.right = outRect.right * 2
		}
	}

	private fun setSymmetrySpace(parent: RecyclerView, view: View, outRect: Rect) {
		val position = parent.getChildAdapterPosition(view)

		if (position % 2 == 0) {
			outRect.right = outRect.left / 2
		} else {
			outRect.left = outRect.right / 2
		}
	}

}