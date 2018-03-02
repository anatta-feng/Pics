package com.fxc.pics.base

import android.app.Application
import com.fxc.pics.common.IApplicationDelegate
import com.fxc.pics.common.base.BaseApplication
import com.fxc.pics.views.images.FrescoUtils

/**
 * Module Pic's Application DelegateImp, execute in [BaseApplication].
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplicationDelegateImp : IApplicationDelegate {
	override fun onCreate(ctx: Application) {
		FrescoUtils.frescoInit(BaseApplication.getApplication())
	}

	override fun onTerminate(ctx: Application) {
	}

	override fun onLowMemory(ctx: Application) {
		FrescoUtils.clearAllMemoryCaches()
	}

	override fun onTrimMemory(level: Int, ctx: Application) {
		FrescoUtils.trimMemory(level)
	}

}