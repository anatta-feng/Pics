package com.fxc.pics.pic.picDetail

import android.support.v4.util.Pair
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.pic.R
import kotlinx.android.synthetic.main.pic_activity_pic_detail.*

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDetailActivity : PresenterActivity<PicDetailPresenterImp>() {

	companion object {
		const val KEY_IMAGE = "key_image"
		const val KEY_PIC_ID = "pic_id"
	}

	override fun initPresenter(): PicDetailPresenterImp {
		return PicDetailPresenterImp(this)
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic_detail
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair.create(pic_detail_image, KEY_IMAGE))
	}

	override fun error(failReason: String) {
	}
}