package com.fxc.pics.pic.network.interceptors

import com.fxc.pics.pic.network.url.APPLICATION_ID
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author fxc
 * @date 2018/3/4
 */
class AuthorizationInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val newRequest = chain.request().newBuilder()
				.addHeader("Authorization", "Client-ID $APPLICATION_ID")
//				.addHeader("client_id", APPLICATION_ID)
				.build()
		return chain.proceed(newRequest)
	}
}