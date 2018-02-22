package com.fxc.pics.pic.picHome.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicHomeFragmentAdapter(list: List<Fragment>, manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
	private val mData = list
	override fun getItem(position: Int): Fragment = mData[position]

	override fun getCount(): Int = mData.size

	override fun getItemPosition(`object`: Any?): Int {
		return PagerAdapter.POSITION_NONE
	}
}