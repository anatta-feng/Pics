package com.fxc.pics.common.threads

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 *
 * @author fxc
 * @date 2018/2/19
 */
object Threads {
	private val MAX_PROCESSORS = Runtime.getRuntime().availableProcessors()
	private const val THREAD_ALIVE_TIME = 3L
	private val fixPool = ThreadPoolExecutor(MAX_PROCESSORS, MAX_PROCESSORS, THREAD_ALIVE_TIME, TimeUnit.MINUTES, LinkedBlockingDeque<Runnable>())

	init {

	}

	fun exector(action: Runnable) {
		if (fixPool.isTerminating || fixPool.isTerminated || fixPool.isShutdown) {
			return
		}
		fixPool.execute(action)
	}

	fun exector(action: () -> Unit) {
		if (fixPool.isTerminating || fixPool.isTerminated || fixPool.isShutdown) {
			return
		}
		fixPool.execute { action.invoke() }
	}

	fun shutdown() {
		fixPool.shutdown()
	}
}