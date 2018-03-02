package com.fxc.pics.views.images

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.fxc.pics.views.images.suppliers.MemoryCacheSupplier
import com.facebook.imagepipeline.core.ImagePipelineFactory
import android.content.ComponentCallbacks2


/**
 *
 * @author fxc
 * @date 2018/2/22
 */
object FrescoUtils {
	fun getAspectRatio(width: Int, height: Int): Float {
		val ratio = width.toFloat() / height.toFloat()
		return when {
			ratio < 0.7f -> 0.7f
			ratio > 1.6f -> 1.6f
			else -> ratio
		}
	}

	fun frescoInit(ctx: Context) {
		val config = ImagePipelineConfig.newBuilder(ctx)
				.setBitmapMemoryCacheParamsSupplier(MemoryCacheSupplier(ctx))
				.build()
		Fresco.initialize(ctx, config)
	}

	fun trimMemory(level: Int) {
		try {
			if (level >= ComponentCallbacks2.TRIM_MEMORY_MODERATE) { // 60
				ImagePipelineFactory.getInstance().imagePipeline.clearMemoryCaches()
			}
		} catch (e: Exception) {
		}
	}

	fun clearAllMemoryCaches() {
		Fresco.getImagePipeline().clearCaches()
	}
}
