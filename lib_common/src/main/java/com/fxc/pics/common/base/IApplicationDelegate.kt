package com.fxc.pics.common.base

/**
 *
 * @author fxc
 * @date 2018/1/10
 */
interface IApplicationDelegate {
	fun onCreate()

	fun onTerminate()

	fun onLowMemory()

	fun onTrimMemory(level: Int)

}