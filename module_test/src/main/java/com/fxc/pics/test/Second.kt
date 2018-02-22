package com.fxc.pics.test

import android.support.v4.util.Pair
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
		image_view.setImageURI("https://images.unsplash.com/photo-1499218727621-7642e7bfa048?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjE5NTE4fQ&s=3ca7cde76bec8962ed36a80751a0dc3b")
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(image_view, KEY))
	}
}