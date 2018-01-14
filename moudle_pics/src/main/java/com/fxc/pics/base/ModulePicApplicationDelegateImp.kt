package com.fxc.pics.base

import android.app.Application
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.fxc.pics.common.IApplicationDelegate
import com.fxc.pics.common.base.BaseApplication

/**
 * Module Pic's Application DelegateImp, execute in [BaseApplication].
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplicationDelegateImp : IApplicationDelegate {
	override fun onCreate(ctx: Application) {
		Fresco.initialize(ctx)
	}

	override fun onTerminate(ctx: Application) {
	}

	override fun onLowMemory(ctx: Application) {
	}

	override fun onTrimMemory(level: Int, ctx: Application) {
	}

}