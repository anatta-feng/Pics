package com.fxc.pics

import android.os.Bundle
import com.fxc.pics.common.base.BaseActivity
import com.fxc.pics.network.test

class MainActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		test()
	}

}
