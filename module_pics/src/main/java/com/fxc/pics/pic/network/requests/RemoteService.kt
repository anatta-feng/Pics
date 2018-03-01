package com.fxc.pics.pic.network.requests

import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.url.APPLICATION_ID
import com.fxc.pics.pic.network.url.PATH_GET_PHOTO
import com.fxc.pics.pic.network.url.PATH_LIST_CURATED_PHOTO
import com.fxc.pics.pic.network.url.PATH_RANDOM_PHOTO
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


    @GET("$PATH_LIST_CURATED_PHOTO&$COUNT=30&$ORDER_BY=popular")
    fun listCuratedPhotos(@Query(PAGE) params: Int): Observable<List<PicListEntity>>

    @GET(PATH_GET_PHOTO)
    fun getPhotoDetail(@Path("id") id: String): Observable<PicDetailEntity>
}