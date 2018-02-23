package com.fxc.pics.test

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
			data.add("Asdasd $i")
		}
//		val adapter = WrapRecyclerViewAdapter(TestAdapter(data))
		val adapter = TestAdapter(data)
		image.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		image.adapter = adapter
		val header = View(this)
		val params = ViewGroup.LayoutParams(200, 200)
		header.background = ColorDrawable(resources.getColor(R.color.test_colorAccent))
		header.layoutParams = params
		header.setOnClickListener {
			image.removeHeaderView(it)
		}
		image.addHeaderView(header)
		image.setOnItemClickListener { view, position ->
			Toast.makeText(this@TestActivity, "remove ${data[position]}  position $position  size${data.size}", Toast.LENGTH_SHORT).show()
			data.removeAt(position)
			adapter.notifyDataSetChanged()
		}
	}
}
