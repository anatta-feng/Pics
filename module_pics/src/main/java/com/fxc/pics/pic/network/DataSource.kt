package com.fxc.pics.pic.network

import android.support.annotation.StringRes

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
interface DataSource {
	interface Callback<T> : SuccessCallback<T>, FailedCallback

	interface SuccessCallback<in T> {
		fun onDataLoaded(data: T)
	}

	interface FailedCallback {
		fun onDataError(@StringRes error: Int)
	}

	fun dispose()
}