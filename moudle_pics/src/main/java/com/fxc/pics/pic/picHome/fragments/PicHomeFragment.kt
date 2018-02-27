package com.fxc.pics.pic.picHome.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.facebook.drawee.view.SimpleDraweeView
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.picHome.adapter.PicListAdapter
import com.fxc.pics.views.recyclerView.itemDecoration.SpaceItemDecoration
import kotlinx.android.synthetic.main.pic_fragment_home.view.*

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicHomeFragment : PresenterFragment<PicHomePresenterImp>() {

	companion object {
		fun newInstance() : PicHomeFragment {
			val fragment = PicHomeFragment()
			val bundle = Bundle()
			fragment.arguments = bundle
			return fragment
		}
	}

	private val data = ArrayList<PicListEntity>()
	private lateinit var mHeaderView: View

	override fun initPresenter(): PicHomePresenterImp = PicHomePresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_home

	override fun error(failReason: String) {

	}

	override fun initWidget() {
		super.initWidget()
		initRecyclerView()
		mHeaderView = LayoutInflater.from(context).inflate(R.layout.pic_home_head, rootView.pic_home_recycler_view, false)
		rootView.pic_home_recycler_view.addHeaderView(mHeaderView)

	}

	private fun initRecyclerView() {
//		rootView.pic_home_recycler_view.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
		rootView.pic_home_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
		rootView.pic_home_recycler_view.adapter = PicListAdapter(data)
		rootView.pic_home_recycler_view.addItemDecoration(SpaceItemDecoration(45, 70))
	}

	fun dataArrive(data: List<PicListEntity>) {
		this@PicHomeFragment.data.addAll(data)
		rootView.pic_home_recycler_view.adapter.notifyDataSetChanged()
	}

	fun setHeaderUrl(regular: String) {
//		mHeaderView.setImageURI(regular)
	}
}