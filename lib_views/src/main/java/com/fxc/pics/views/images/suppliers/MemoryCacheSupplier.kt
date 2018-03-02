package com.fxc.pics.views.images.suppliers

import android.app.ActivityManager
import android.content.Context
import com.facebook.common.internal.Supplier
import com.facebook.common.util.ByteConstants
import com.facebook.imagepipeline.cache.MemoryCacheParams
import kotlin.math.min

/**
 * @author fxc
 * @date 2018/3/2
 */
class MemoryCacheSupplier(context: Context) : Supplier<MemoryCacheParams> {
	private val MAX_CACHE_ENTRIES = 56
	private val MAX_CACHE_EVICTION_SIZE = 5
	private val MAX_CACHE_EVICTION_ENTRIES = 5

	private val mActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
	override fun get(): MemoryCacheParams {
		return MemoryCacheParams(getMaxCacheSize(), MAX_CACHE_ENTRIES, MAX_CACHE_EVICTION_SIZE, MAX_CACHE_EVICTION_ENTRIES, 1)
	}

	private fun getMaxCacheSize(): Int {
		val maxMemory = min(mActivityManager.memoryClass * ByteConstants.MB, Int.MAX_VALUE)
		return when {
			maxMemory < 32 * ByteConstants.MB -> 4 * ByteConstants.MB
			maxMemory < 64 * ByteConstants.MB -> 6 * ByteConstants.MB
			else -> maxMemory / 5
		}
	}
}