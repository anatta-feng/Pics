package com.fxc.pics.pic.picHome

import android.support.v7.widget.StaggeredGridLayoutManager
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.picHome.adapter.PicListAdapter
import kotlinx.android.synthetic.main.pic_activity_head_background.*
import kotlinx.android.synthetic.main.pic_activity_pic.*

class PicActivity : PresenterActivity<PicPresenterImp>() {
	private val data = ArrayList<PicListEntity>()
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
		pic_recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
		pic_recycler_view.adapter = PicListAdapter(data)
	}

	fun setTitleImage(url: String) {
		pic_activity_background.setUrl(url)
	}

	fun notifyListChanged(data: List<PicListEntity>) {
		this@PicActivity.data.addAll(data)
		pic_recycler_view.adapter.notifyDataSetChanged()
	}

}
