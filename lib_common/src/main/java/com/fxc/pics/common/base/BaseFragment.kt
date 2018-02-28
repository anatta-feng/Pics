package com.fxc.pics.common.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
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

	fun startActivityBySharedElement(params: HashMap<String, String>, clazz: Class<*>, vararg sharedElements: Pair<View, String>) {
		val intent = Intent()
		intent.setClass(context, clazz)
		for ((k, v) in params) {
			intent.putExtra(k, v)
		}
		val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, *sharedElements)
		ActivityCompat.startActivity(context, intent, options.toBundle())
	}

	fun bindShareElement(vararg shareElements: Pair<View, String>) {
		for (element in shareElements) {
			ViewCompat.setTransitionName(element.first, element.second)
		}
	}
}