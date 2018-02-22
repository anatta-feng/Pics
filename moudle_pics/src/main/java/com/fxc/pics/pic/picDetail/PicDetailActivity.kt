package com.fxc.pics.pic.picDetail

import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.pic.R

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDetailActivity : PresenterActivity<PicDetailPresenterImp>() {
	override fun initPresenter(): PicDetailPresenterImp {
		return PicDetailPresenterImp(this)
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic_detail
	}

	override fun error(failReason: String) {
	}
}