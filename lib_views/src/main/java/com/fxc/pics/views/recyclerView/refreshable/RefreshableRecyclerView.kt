package com.fxc.pics.views.recyclerView.refreshable

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.fxc.pics.views.recyclerView.WrapRecyclerView

/**
 *
 * @author fxc
 * @date 2018/2/24
 */
class RefreshableRecyclerView : WrapRecyclerView {
	constructor(context: Context) : super(context)
	constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
	constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

}