package com.fxc.pics.common.base

import android.app.Application
import com.fxc.pics.common.IApplicationDelegate
import com.fxc.pics.common.IBaseActivityDelegate
import com.fxc.pics.common.classdected.DelegateBean
import com.fxc.pics.common.classdected.getAppAndBaseDelegates

/**
 * BaseApplication
 * @author fxc
 * @date 2018/1/8
 */
abstract class BaseApplication : Application() {

	companion object {
		private const val TAG = "BaseApplication"

		private const val ROOT_PACKAGE = "com.fxc.pics.base"
		private lateinit var delegates: DelegateBean<IApplicationDelegate, IBaseActivityDelegate>

		fun getActivityDelegates(): List<IBaseActivityDelegate> {
			return delegates.activities
		}
	}

	override fun onCreate() {
		super.onCreate()
		delegates = getAppAndBaseDelegates(this, IApplicationDelegate::class.java, IBaseActivityDelegate::class.java, ROOT_PACKAGE)
		for (app in delegates.applications) {
			app.onCreate()
		}
	}

	override fun onTerminate() {
		super.onTerminate()
		for (app in delegates.applications) {
			app.onTerminate()
		}
	}

	override fun onLowMemory() {
		super.onLowMemory()
		for (app in delegates.applications) {
			app.onLowMemory()
		}
	}

	override fun onTrimMemory(level: Int) {
		super.onTrimMemory(level)
		for (app in delegates.applications) {
			app.onTrimMemory(level)
		}
	}

}