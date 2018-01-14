package com.fxc.pics.pic.network.requests

import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.url.APPLICATION_ID
import com.fxc.pics.pic.network.url.PATH_RANDOM_PHOTO
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
internal interface GetRandomPic {
	@GET("$PATH_RANDOM_PHOTO?client_id=$APPLICATION_ID")
	fun getRandomPic(): Observable<RandomPicEntity>
}