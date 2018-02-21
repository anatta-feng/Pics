package com.fxc.pics.pic

import com.fxc.pics.common.base.PresenterActivity

class PicActivity : PresenterActivity<PicPresenterImp>() {
	override fun initPresenter(): PicPresenterImp {
		return PicPresenterImp(this)
	}

	override fun error(failReason: String) {
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
	}

}
