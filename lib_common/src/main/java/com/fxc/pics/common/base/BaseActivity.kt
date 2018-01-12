package com.fxc.pics.common.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * BaseActivity
 * @author fxc
 * @date 2018/1/10
 */
abstract class BaseActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		for (app in BaseApplication.getActivityDelegates()) {
			app.onCreate()
		}
	}

	override fun onStart() {
		super.onStart()
		for (app in BaseApplication.getActivityDelegates()) {
			app.onStart()
		}
	}

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		for (app in BaseApplication.getActivityDelegates()) {
			app.onNewIntent(intent)
		}
	}

	override fun onResume() {
		super.onResume()
		for (app in BaseApplication.getActivityDelegates()) {
			app.onResume()
		}
	}

	override fun onPause() {
		super.onPause()
		for (app in BaseApplication.getActivityDelegates()) {
			app.onPause()
		}
	}

	override fun onStop() {
		super.onStop()
		for (app in BaseApplication.getActivityDelegates()) {
			app.onStop()
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		for (app in BaseApplication.getActivityDelegates()) {
			app.onDestroy()
		}
	}

}