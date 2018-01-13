package com.fxc.pics.pic.network

import com.fxc.pics.pic.network.url.HOST
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
internal object RetrofitManager {
	private val RETROFIT_MAP = HashMap<String, Retrofit>()
	private val mClient = OkHttpClient()
	private val mConverterFactory = GsonConverterFactory.create(GsonBuilder().create())
	val UNSPLASH = "unsplash"
	init {
		createRetrofit()
	}

	private fun createRetrofit() {
		RETROFIT_MAP.put(UNSPLASH,
				Retrofit.Builder()
						.baseUrl(HOST)
						.client(mClient)
						.addConverterFactory(mConverterFactory)
						.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
						.build())
	}

	fun getRetrofit(name: String): Retrofit {
		if (!RETROFIT_MAP.containsKey(name)) {
			throw IllegalArgumentException("A illegal retrofit key")
		}
		return RETROFIT_MAP[name]!!
	}
}