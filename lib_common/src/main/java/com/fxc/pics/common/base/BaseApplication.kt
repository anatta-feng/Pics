package com.fxc.pics.common.base

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import com.fxc.pics.common.IApplicationDelegate
import com.fxc.pics.common.IBaseActivityDelegate
import com.fxc.pics.common.classdected.DelegateBean
import com.fxc.pics.common.classdected.getAppAndBaseDelegates
import com.fxc.pics.common.threads.Threads

/**
 * BaseApplication
 * @author fxc
 * @date 2018/1/8
 */
abstract class BaseApplication : Application() {

	companion object {
		private const val TAG = "BaseApplication"

		private const val ROOT_PACKAGE = "com.fxc.pics.base"
		@SuppressLint("StaticFieldLeak")
		private lateinit var app: Application
		private var delegates: DelegateBean<IApplicationDelegate, IBaseActivityDelegate> = DelegateBean()

		fun getActivityDelegates(): List<IBaseActivityDelegate> {
			return delegates.activities
		}

		fun getApplication(): Application {
			return app
		}
	}

	override fun onCreate() {
		super.onCreate()
		app = this
		delegates = getAppAndBaseDelegates(this, IApplicationDelegate::class.java, IBaseActivityDelegate::class.java, ROOT_PACKAGE)
		Log.d(TAG, "app onCreate ${delegates.applications.size}")
		for (app in delegates.applications) {
			app.onCreate(this)
		}
	}

	override fun onTerminate() {
		super.onTerminate()
		for (app in delegates.applications) {
			app.onTerminate(this)
		}
		Threads.shutdown()
	}

	override fun onLowMemory() {
		super.onLowMemory()
		for (app in delegates.applications) {
			app.onLowMemory(this)
		}
	}

	override fun onTrimMemory(level: Int) {
		super.onTrimMemory(level)
		for (app in delegates.applications) {
			app.onTrimMemory(level, this)
		}
	}

}