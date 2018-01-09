package com.fxc.pics.common

import android.app.Application
import android.util.Log

/**
 *
 * @author fxc
 * @date 2018/1/8
 */
abstract class BaseApplication : Application() {

	override fun onCreate() {
		super.onCreate()
		for (i in 2..10) {
			Log.i("asd", "ss " + i)
		}
	}

}