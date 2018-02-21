package com.fxc.pics.network

import android.content.Context
import android.net.ConnectivityManager

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
fun isNetworkAvailable(ctx: Context): Boolean {
	val manager = ctx.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager? ?: return false
	val networkInfo = manager.activeNetworkInfo ?: return false
	return networkInfo.isAvailable
}