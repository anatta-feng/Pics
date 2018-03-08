package com.fxc.pics.common.base

import android.content.Intent
import android.os.Bundle
import com.fxc.pics.common.BaseContract

/**
 *
 * @author fxc
 * @date 2018/1/10
 */
abstract class PresenterActivity<Presenter : BaseContract.Presenter> : BaseActivity(), BaseContract.View<Presenter, Intent> {
	protected lateinit var mPresenter: Presenter
	private var mIntent: Intent? = null


	override fun setPresenter(presenter: Presenter) {
		lifecycle.addObserver(presenter)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mIntent = intent
		mPresenter = initPresenter()
	}

	abstract fun initPresenter(): Presenter

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		mIntent = intent
		mPresenter.onNewIntent(intent)
	}

	override fun getStartParams(): Intent? {
		return mIntent
	}

	final override fun getStringResource(stringId: Int): String {
		return getString(stringId)
	}

}