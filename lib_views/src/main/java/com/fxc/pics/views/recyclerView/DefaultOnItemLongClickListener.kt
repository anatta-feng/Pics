package com.fxc.pics.views.recyclerView

import android.view.View

/**
 *
 * @author fxc
 * @date 2018/2/23
 */
internal class DefaultOnItemLongClickListener : ItemClickRecyclerViewAdapter.OnItemLongClickListener {
	override fun onItemLongClick(item: View?, position: Int): Boolean {
		return false
	}
}