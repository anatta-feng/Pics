package com.fxc.pics.common.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.common.events.EventUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.EventBusException

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
abstract class BaseFragment : Fragment() {
	protected lateinit var rootView: View

	companion object {
		private const val TAG = "BaseFragment"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		try {
			EventUtil.register(this)
		} catch (exception: EventBusException) {
			Log.w(TAG, "${this.javaClass} has no public methods with the @Subscribe annotation")
		}
	}

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

	@LayoutRes
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

	override fun onDestroy() {
		super.onDestroy()
		EventUtil.unregister(this)
	}
}