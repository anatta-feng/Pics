package com.fxc.pics.test

import android.os.Bundle
import android.support.v4.util.Pair
import com.fxc.pics.common.base.BaseActivity
import kotlinx.android.synthetic.main.test_activity_layout.*

class TestActivity : BaseActivity() {
	override fun getContentViewId(): Int {
		return R.layout.test_activity_layout
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val data = ArrayList<String>()
		for (i in 0..50) {
			data.add("Asdasd")
		}
		image.setImageURI("https://images.unsplash.com/photo-1499218727621-7642e7bfa048?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjE5NTE4fQ&s=3ca7cde76bec8962ed36a80751a0dc3b")
		image.setOnClickListener {
			startActivityByShareElement(HashMap(), Second::class.java, Pair(image, Second.KEY))
		}

	}
}
