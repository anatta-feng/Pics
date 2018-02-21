package com.fxc.pics.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.test_activity_main.*

class TestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.test_activity_layout)
		val data = ArrayList<String>()
		for (i in 0..50) {
			data.add("Asdasd")
		}
		recycler_view.adapter = TestAdapter(data)
		recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

	}
}
