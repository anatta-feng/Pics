package com.fxc.pics

import android.content.Intent
import android.os.Handler
import android.support.v4.app.SharedElementCallback
import android.support.v4.util.Pair
import android.util.Log
import android.view.View
import com.fxc.pics.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
class WelcomeActivity : BaseActivity() {

	override fun getContentViewId(): Int {
		return R.layout.activity_welcome
	}

	override fun initWidget() {
		//TODO EventBus 接受信息
		startActivityByShareElement(HashMap(), Class.forName("com.fxc.pics.pic.picHome.PicActivity"), Pair.create(welcome_title, "key_pic_title"), Pair.create(welcome_subtitle, "key_pic_subtitle"))
		setExitSharedElementCallback(object : SharedElementCallback() {
			override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
				super.onMapSharedElements(names, sharedElements)

			}
		})
	}

	override fun onActivityReenter(resultCode: Int, data: Intent?) {
		super.onActivityReenter(resultCode, data)

	}
}