package com.fxc.pics.common.base

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.fxc.pics.common.BaseContract

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
abstract class PresenterFragment<Presenter : BaseContract.Presenter, Activity : FragmentActivity> : BaseFragment<Activity>(), BaseContract.View<Presenter, Bundle> {

	protected lateinit var mPresenter: Presenter

	override fun setPresenter(presenter: Presenter) {
		lifecycle.addObserver(presenter)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		initPresenter()
	}

	abstract fun initPresenter(): Presenter

	final override fun getStringResource(stringId: Int): String {
		return getString(stringId)
	}

	override fun getStartParams(): Bundle {
		return arguments
	}
}
