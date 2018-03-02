package com.fxc.pics.base

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.listener.RequestLoggingListener
import com.fxc.pics.common.IApplicationDelegate
import com.fxc.pics.common.base.BaseApplication
import com.fxc.pics.pic.BuildConfig
import com.fxc.pics.views.images.FrescoUtils

/**
 * Module Pic's Application DelegateImp, execute in [BaseApplication].
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplicationDelegateImp : IApplicationDelegate {
	override fun onCreate(ctx: Application) {
		if (BuildConfig.DEBUG) {
			val requestListeners = HashSet<RequestListener>()
			requestListeners.add(RequestLoggingListener())
			val config = ImagePipelineConfig.newBuilder(ctx)
					.setRequestListeners(requestListeners)
					.setDownsampleEnabled(true)
					.build()
			Fresco.initialize(ctx, config)
		} else {
			Fresco.initialize(ctx)
		}
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