package com.fxc.pics.common

import android.content.Intent

/**
 *
 * @author fxc
 * @date 2018/1/10
 */
interface IBaseActivityDelegate {
	fun onCreate()

	fun onStart()

	fun onNewIntent(intent: Intent?)

	fun onResume()

	fun onPause()

	fun onStop()

	fun onDestroy()
}