package com.fxc.pics.test

import android.support.v4.util.Pair
import android.util.Log
import android.widget.Toast
import com.fxc.pics.common.base.BaseActivity
import kotlinx.android.synthetic.main.test_activity_second.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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
		Log.d("asdzxcwq", "get ${intent.getSerializableExtra("asd")}")
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(image_view, KEY))
		EventUtil.post(Test())
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	fun event(test: Bean) {
		Toast.makeText(this, test.name, Toast.LENGTH_SHORT).show()
	}
}