package com.fxc.pics.pic.picHome.fragments

import android.os.Bundle
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.pic.R

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

	override fun initPresenter(): PicHomePresenterImp = PicHomePresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_home

	override fun error(failReason: String) {

	}
}