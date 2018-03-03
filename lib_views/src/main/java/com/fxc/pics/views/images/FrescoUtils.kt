package com.fxc.pics.views.images

import android.content.ComponentCallbacks2
import android.content.Context
import android.net.Uri
import android.os.Looper
import android.util.Log
import com.facebook.datasource.BaseDataSubscriber
import com.facebook.datasource.DataSource
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.core.ImagePipelineFactory
import com.fxc.pics.views.images.suppliers.MemoryCacheSupplier
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 *
 * @author fxc
 * @date 2018/2/22
 */
object FrescoUtils {
	private val MAX_PROCESSORS = Runtime.getRuntime().availableProcessors()
	private const val THREAD_ALIVE_TIME = 60L
	private val frescoCacheExecutor = ThreadPoolExecutor(0, Int.MAX_VALUE, THREAD_ALIVE_TIME, TimeUnit.SECONDS, SynchronousQueue<Runnable>())

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

	fun isInCache(uri: Uri): Observable<Boolean> {

		val isInMemoryCache = Fresco.getImagePipeline().isInBitmapMemoryCache(uri)
		if (isInMemoryCache) {

			return Observable.create<Boolean> {
				it.onNext(isInMemoryCache)
			}
					.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread())
		}
		return Observable.create<Boolean> {
			it.onNext(Fresco.getImagePipeline().isInDiskCacheSync(uri))
		}
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())

	}

	fun isInCache(url: String): Observable<Boolean> {
		return isInCache(Uri.parse(url))
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
