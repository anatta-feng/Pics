package com.fxc.pics.pic

import android.util.Log
import com.fxc.pics.common.base.BasePresenter
import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.getRandomPic
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
class PicPresenterImp(view: PicActivity) : BasePresenter<PicActivity>(view) {

	override fun onCreate() {
		super.onCreate()
		requestRandomPic()
	}

	private fun requestRandomPic() {
		Log.i("asd", "requestRandomPic")
		getRandomPic()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(object : Observer<RandomPicEntity> {
					override fun onNext(t: RandomPicEntity) {
						Log.i("asd", t.urls?.regular)
					}

					override fun onSubscribe(d: Disposable) {
						Log.i("asd", "onSubscribe")
					}

					override fun onError(e: Throwable) {
						Log.i("asd", "onError")
					}

					override fun onComplete() {
						Log.i("asd", "onComplete")
					}

				})

	}

}