package com.fxc.pics.test

import android.support.v4.util.Pair
import android.transition.ChangeImageTransform
import com.fxc.pics.common.base.BaseActivity
import kotlinx.android.synthetic.main.test_activity_second.*

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class Second : BaseActivity() {
	companion object {
		val KEY = "qqq"
	}
	override fun getContentViewId(): Int {
		return R.layout.test_activity_second
	}

	override fun initWidget() {
		super.initWidget()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(image_view, KEY))
	}
}