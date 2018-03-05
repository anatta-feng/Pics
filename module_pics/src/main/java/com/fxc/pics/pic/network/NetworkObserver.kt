package com.fxc.pics.pic.network

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author fxc
 * @date 2018/3/4
 */
open class NetworkObserver<T> : Observer<T> {
	override fun onComplete() {

	}

	override fun onSubscribe(d: Disposable) {
	}

	override fun onNext(t: T) {
	}

	override fun onError(e: Throwable) {
	}
}