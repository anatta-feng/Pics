package com.fxc.pics.common.base

import android.app.Application
import com.fxc.pics.common.getObjectsWithInterface

/**
 * BaseApplication
 * @author fxc
 * @date 2018/1/8
 */
abstract class BaseApplication : Application() {
	private lateinit var mApplicationDelegates: List<IApplicationDelegate>

	companion object {
		private const val ROOT_PACKAGE = "com.fxc.pics.base"
		private const val TAG = "BaseApplication"
	}

	override fun onCreate() {
		super.onCreate()
		mApplicationDelegates = getObjectsWithInterface(this, IApplicationDelegate::class.java, ROOT_PACKAGE)
		for (app in mApplicationDelegates) {
			app.onCreate()
		}
	}

	override fun onTerminate() {
		super.onTerminate()
		for (app in mApplicationDelegates) {
			app.onTerminate()
		}
	}

	override fun onLowMemory() {
		super.onLowMemory()
		for (app in mApplicationDelegates) {
			app.onLowMemory()
		}
	}

	override fun onTrimMemory(level: Int) {
		super.onTrimMemory(level)
		for (app in mApplicationDelegates) {
			app.onTrimMemory(level)
		}
	}

}