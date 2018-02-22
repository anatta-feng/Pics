package com.fxc.adapter

import android.support.v7.widget.RecyclerView

/**
 *
 * @author fxc
 * @date 2018/1/15
 */
abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
	private val mData = ArrayList<T>()
	override fun getItemCount(): Int {
		return mData.size
	}

	fun getData():List<T> {
		return mData
	}

	fun refreshData(data: List<T>) {
		if (data.isEmpty()) return
		mData.clear()
		appendData(data)
	}

	fun appendData(data: List<T>) {
		if (data.isEmpty()) return
		mData.addAll(data)
		notifyDataSetChanged()
	}
}