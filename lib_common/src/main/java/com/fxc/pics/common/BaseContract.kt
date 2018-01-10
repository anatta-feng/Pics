package com.fxc.pics.common

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent

/**
 *
 * @author fxc
 * @date 2018/1/10
 */
interface BaseContract {
	interface View<in T : Presenter> {
		fun getStringResource(stringId: Int): String
		fun error(failReason: String)
		fun setPresenter(presenter: T)
		fun getIntentData(): Intent?
	}

	interface Presenter : LifecycleObserver {
		@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
		fun onCreate()

		@OnLifecycleEvent(Lifecycle.Event.ON_START)
		fun onStart()

		fun onNewIntent(intent: Intent?)

		@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
		fun onResume()

		@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
		fun onPause()

		@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
		fun onStop()

		@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
		fun onDestroy()
	}
}