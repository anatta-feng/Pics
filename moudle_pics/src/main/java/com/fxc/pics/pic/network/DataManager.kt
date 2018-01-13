package com.fxc.pics.pic.network

import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.requests.GetRandomPic
import io.reactivex.Observable

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
internal fun getRandomPic():Observable<RandomPicEntity> {
	val request = RetrofitManager.getRetrofit(RetrofitManager.UNSPLASH)
	val command = request.create(GetRandomPic::class.java)
	return command.getRandomPic()
}