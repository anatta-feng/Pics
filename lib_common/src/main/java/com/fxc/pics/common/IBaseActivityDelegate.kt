package com.fxc.pics.common

import android.content.Intent

/**
 * 需要向 Application 中注入逻辑操作需要在 {@link com.fxc.pics.base} 中新建实现类
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