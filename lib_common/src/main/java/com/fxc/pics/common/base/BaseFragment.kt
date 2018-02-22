package com.fxc.pics.common.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
abstract class BaseFragment : Fragment() {
	protected lateinit var rootView: View

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val resId = getContentViewId()
		if (resId != 0)
			rootView = inflater.inflate(resId, container, false)
		else
			throw RuntimeException("Please set a correct resId!")
		beforeInitWidget()
		initWidget()
		afterInitWidget()
		return rootView
	}

	protected open fun beforeInitWidget() {

	}

	protected open fun initWidget() {

	}

	protected open fun afterInitWidget() {

	}

	abstract fun getContentViewId(): Int

}