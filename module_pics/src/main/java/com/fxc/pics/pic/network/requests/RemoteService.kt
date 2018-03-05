package com.fxc.pics.pic.network.requests

import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.PicRelatedEntity
import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.url.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
interface RemoteService {
	companion object {
		private const val PAGE = "page"
		private const val COUNT = "per_page"
		private const val ORDER_BY = "order_by"
	}

	@GET(PATH_RANDOM_PHOTO)
	fun getRandomPic(): Observable<RandomPicEntity>


	@GET(PATH_LIST_CURATED_PHOTO)
	fun listCuratedPhotos(@Query(PAGE) params: Int, @Query(COUNT) count:Int, @Query(ORDER_BY) orderBy:String): Observable<List<PicListEntity>>

	@GET(PATH_GET_PHOTO)
	fun getPhotoDetail(@Path("id") id: String): Observable<PicDetailEntity>

	@GET(PATH_PHOTO_RELATED)
	fun getRelatedPhotos(@Path("id") id: String): Observable<PicRelatedEntity>
}