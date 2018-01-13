package com.fxc.pics.pic.network.requests

import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.url.APPLICATION_ID
import com.fxc.pics.pic.network.url.PATH_RANDOM_PHONT
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
internal interface GetRandomPic {
	@GET("$PATH_RANDOM_PHONT?client_id=$APPLICATION_ID&w=1080&h=1920")
	fun getRandomPic(): Observable<RandomPicEntity>
}