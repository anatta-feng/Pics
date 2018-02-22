package com.fxc.pics.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class TestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.test_activity_layout)
		val data = ArrayList<String>()
		for (i in 0..50) {
			data.add("Asdasd")
		}

	}
}
