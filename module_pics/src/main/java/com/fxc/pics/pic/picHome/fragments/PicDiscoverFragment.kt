package com.fxc.pics.pic.picHome.fragments

import android.os.Bundle
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.pic.R
import com.fxc.pics.pic.picHome.PicActivity

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDiscoverFragment : PresenterFragment<PicDiscoverPresenterImp, PicActivity>() {

	companion object {
		fun newInstance() : PicDiscoverFragment {
			val fragment = PicDiscoverFragment()
			val bundle = Bundle()
			fragment.arguments = bundle
			return fragment
		}
	}

	override fun initPresenter(): PicDiscoverPresenterImp = PicDiscoverPresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_discover

	override fun error(failReason: String) {

	}
}