package com.fxc.pics.views.recyclerView.refreshable

import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 *
 * @author fxc
 * @date 2018/2/24
 */
abstract class RefreshViewCreator {
	/**
	 * Get RefreshView's instance
	 * @param context the Context
	 * @param parent the Parent View
	 * @return the refresh view's instance
	 */
	abstract fun getRefreshView(context: Context, parent: ViewGroup): View

	/**
	 * The pull callback
	 * @param currentDragHeight current drag distance, compare with [refreshViewHeight]
	 * @param refreshViewHeight total drag distance
	 * @return current refresh status.
	 */
	abstract fun onPull(currentDragHeight: Int, refreshViewHeight: Int, currentRefreshStatus: Int)

	/**
	 * Refreshing.
	 */
	abstract fun onRefreshing()

	/**
	 * Refresh finished callback.
	 */
	abstract fun onRefreshFinished()
}