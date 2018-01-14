package com.fxc.pics.pic

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.views.color.reverse
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

	override fun afterInitWidget() {
		super.afterInitWidget()
		image_view.setOnClickListener {
			vp_desc_parent.visibility = when (vp_desc_parent.visibility) {
				View.VISIBLE -> View.GONE
				else -> View.VISIBLE
			}
		}
	}

	fun setDescLayoutColor(color: String) {
		val bgColor = Color.parseColor(color)
		val textColor = reverse(bgColor)
		vp_desc_parent.background = ColorDrawable(bgColor)
		vp_desc_parent.background.alpha = 230
		tv_description.setTextColor(textColor)
		tv_author_name.setTextColor(textColor)
		vp_desc_parent.visibility = View.VISIBLE
	}

	fun setPicDescription(description: String?) {
		tv_description.text = if (TextUtils.isEmpty(description)) "Nothing..." else description
	}

	fun setAuthorName(name: String?) {
		tv_author_name.text = getString(R.string.pic_author_name).format(name)
	}

	fun setImageURI(url: String) {
		image_view.setUrl(url)
	}

	fun setImageMultiURL(lowResUrl: String, highResUrl: String) {
		image_view.setMultiUrl(lowResUrl, highResUrl)
	}

}
