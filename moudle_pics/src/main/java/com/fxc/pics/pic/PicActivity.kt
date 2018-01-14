package com.fxc.pics.pic

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import com.facebook.drawee.backends.pipeline.Fresco
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.views.color.reverse
import kotlinx.android.synthetic.main.pic_activity_pic.*
import kotlin.math.abs

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
		vp_desc_parent.background.alpha = 230
	}

	fun setDescLayoutColor(color: String) {
		val bgColor = Color.parseColor(color)
		val textColor = reverse(bgColor)
		vp_desc_parent.background = ColorDrawable(bgColor)
		tv_description.setTextColor(textColor)
		tv_author_name.setTextColor(textColor)
	}

	fun setPicDescription(description: String?) {
		tv_description.text = if (TextUtils.isEmpty(description)) "Nothing..." else description
	}

	fun setAuthorName(name: String?) {
		tv_author_name.text = getString(R.string.pic_author_name).format(name)
	}

	fun setImageURI(url: String) {
		image_view.controller = Fresco.newDraweeControllerBuilder().setUri(url).build()
	}

}
