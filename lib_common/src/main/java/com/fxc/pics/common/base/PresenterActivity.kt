package com.fxc.pics.common.base

import android.content.Intent
import android.os.Bundle
import com.fxc.pics.common.BaseContract

/**
 *
 * @author fxc
 * @date 2018/1/10
 */
abstract class PresenterActivity<Presenter : BaseContract.Presenter> : BaseActivity(), BaseContract.View<Presenter> {
	protected lateinit var mPresenter: Presenter
	private var mIntent: Intent? = null


	override fun setPresenter(presenter: Presenter) {
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mIntent = intent
		initPresenter()
		val resId = getContentViewId()
		if (resId != 0)
			setContentView(resId)
		else
			throw RuntimeException("Please set a correct resId!")
		beforeInitWidget()
		initWidget()
		afterInitWidget()
	}

	private fun beforeInitWidget() {

	}

	abstract fun initWidget()

	private fun afterInitWidget() {

	}

	abstract fun getContentViewId(): Int

	abstract fun initPresenter(): Presenter

	override fun onNewIntent(intent: Intent?) {
		super.onNewIntent(intent)
		mIntent = intent
		mPresenter.onNewIntent(intent)
	}

	override final fun getIntentData(): Intent? {
		return mIntent
	}

	override final fun getStringResource(stringId: Int): String {
		return getString(stringId)
	}

	override abstract fun error(failReason: String)
}