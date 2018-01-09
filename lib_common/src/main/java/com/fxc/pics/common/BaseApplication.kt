package com.fxc.pics.common

import android.app.Application

/**
 *
 * @author fxc
 * @date 2018/1/8
 */
abstract class BaseApplication : Application() {

	companion object {
		private const val ROOT_PACKAGE = "com.fxc.pics"
		private const val TAG = "BaseApplication"
	}

	override fun onCreate() {
		super.onCreate()
	}

}