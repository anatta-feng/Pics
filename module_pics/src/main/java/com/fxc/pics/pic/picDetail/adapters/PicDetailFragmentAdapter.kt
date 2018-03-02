package com.fxc.pics.pic.picDetail.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.fxc.pics.pic.picDetail.PicDetailFragment

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragmentAdapter(list: List<Fragment>, manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
	private val mData = list
	override fun getItem(position: Int): Fragment {
		return PicDetailFragment.getInstance()
	}

	override fun getCount(): Int = mData.size
}