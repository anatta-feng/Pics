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
	companion object {
		const val TAG = "PicPresenterImp"
	}

	override fun onCreate() {
		super.onCreate()
		requestRandomPic()
	}

	private fun requestRandomPic() {
		Log.i(TAG, "requestRandomPic")
		getRandomPic()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(object : Observer<RandomPicEntity> {
					override fun onNext(entity: RandomPicEntity) {
						Log.d(TAG, entity.toString())
						view.setPicDescription(entity.description)
						view.setAuthorName(entity.user.name)
						view.setImageMultiURL(entity.urls.thumb, entity.urls.regular)
						view.setDescLayoutColor(entity.color)
					}

					override fun onSubscribe(d: Disposable) {
					}

					override fun onError(e: Throwable) {
					}

					override fun onComplete() {
					}

				})

	}

}