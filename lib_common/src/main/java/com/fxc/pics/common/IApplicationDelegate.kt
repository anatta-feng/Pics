package com.fxc.pics.common

/**
 * 需要向 Application 中注入逻辑操作需要在 {@link com.fxc.pics.base} 中新建实现类
 * @author fxc
 * @date 2018/1/10
 */

interface IApplicationDelegate {
	fun onCreate()

	fun onTerminate()

	fun onLowMemory()

	fun onTrimMemory(level: Int)

}