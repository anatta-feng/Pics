package com.fxc.pics.pic.picDetail.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.ViewGroup
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.picDetail.PicDetailFragment

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragmentAdapter(list: ArrayList<PicListEntity>, manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
	private val mData = list
	internal var fragment: PicDetailFragment? = null
	override fun getItem(position: Int): Fragment {
		return PicDetailFragment.getInstance(position)
	}

	override fun getCount(): Int = mData.size

	override fun setPrimaryItem(container: ViewGroup?, position: Int, `object`: Any?) {
		super.setPrimaryItem(container, position, `object`)
		fragment = `object` as PicDetailFragment?
	}
}