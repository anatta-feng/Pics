package com.fxc.pics.pic

import com.fxc.pics.common.base.PresenterActivity
import kotlinx.android.synthetic.main.pic_activity_pic.*

class PicActivity : PresenterActivity<PicPresenterImp>() {
	override fun initPresenter(): PicPresenterImp {
		return PicPresenterImp(this)
	}

	override fun error(failReason: String) {
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic
	}

	fun setAuthorName(name: String) {
		tv_author_name.text = getString(R.string.pic_author_name).format(name)
	}

}
