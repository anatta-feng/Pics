package com.fxc.pics.common

import android.app.Application

/**
 * 需要向 Application 中注入逻辑操作需要在 {@link com.fxc.pics.base} 中新建实现类
 * @author fxc
 * @date 2018/1/10
 */

interface IApplicationDelegate {
	fun onCreate(ctx: Application)

	fun onTerminate(ctx: Application)

	fun onLowMemory(ctx: Application)

	fun onTrimMemory(level: Int, ctx: Application)

}