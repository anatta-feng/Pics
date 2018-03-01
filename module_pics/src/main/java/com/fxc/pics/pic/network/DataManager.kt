package com.fxc.pics.pic.network

import com.fxc.pics.common.base.BaseApplication
import com.fxc.pics.network.isNetworkAvailable
import com.fxc.pics.pic.network.RetrofitManager.UNSPLASH
import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.RandomPicEntity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
/**
 * 获取一张随机图片
 */
internal fun getRandomPic(listener: DataSource.Callback<RandomPicEntity>) {
	if (!isNetworkAvailable(BaseApplication.getApplication())) {
		listener.onDataError(2)
		return
	}
	val command = RetrofitManager.remount(UNSPLASH)
	rxResponse(command.getRandomPic(), listener)

}

internal fun getPicList(page: Int, listener: DataSource.Callback<List<PicListEntity>>) {
	if (!isNetworkAvailable(BaseApplication.getApplication())) {
		listener.onDataError(2)
		return
	}
	val command = RetrofitManager.remount(UNSPLASH)
	rxResponse(command.listCuratedPhotos(page), listener)

}

internal fun getPhotoDetail(id: String, listener: DataSource.Callback<PicDetailEntity>) {
	if (!isNetworkAvailable(BaseApplication.getApplication())) {
		listener.onDataError(2)
		return
	}
	val command = RetrofitManager.remount(UNSPLASH)
	rxResponse(command.getPhotoDetail(id), listener)
}

private fun <T> rxResponse(observable: Observable<T>, callback: DataSource.Callback<T>) {
	observable.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(object : Observer<T> {
				override fun onComplete() {
				}

				override fun onSubscribe(d: Disposable) {
				}

				override fun onNext(t: T) {
					callback.onDataLoaded(t)
				}

				override fun onError(e: Throwable) {
					callback.onDataError(1)
				}

			})
}