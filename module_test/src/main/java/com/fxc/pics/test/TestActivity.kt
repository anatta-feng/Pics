package com.fxc.pics.test

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.common.base.BaseActivity
import com.fxc.pics.views.recyclerView.WrapRecyclerViewAdapter
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
		val adapter = WrapRecyclerViewAdapter(TestAdapter(data))
		image.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		image.adapter = adapter
		val header = View(this)
		val params = ViewGroup.LayoutParams(200, 200)
		header.background = ColorDrawable(resources.getColor(R.color.test_colorAccent))
		header.layoutParams = params
		adapter.addHeaderView(header)
	}
}
