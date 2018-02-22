package com.fxc.adapter

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxc.adapter.LoadMoreAdapter.Callback
import kotlin.math.abs

/**
 * 分页请求 RecyclerView Adapter
 * 在需要用到分页请求的 RecyclerView 处，此 Adapter 为 RecyclerView Adapter，业务逻辑实现 Adapter 作为构造参数传入[LoadMoreAdapter]
 * @param adapter 业务逻辑实现 Adapter 作为构造参数传入此 Adapter，需要继承自[BaseAdapter]
 * @param listener 两个参数[Int], [Callback]，一个当前页码，一个[Callback]回调有两个方法[Callback.onSuccess]，[Callback.onFailure]。
 * 下载回调，需要请求数据的时候会回调此方法，参数中会传入当前页数，在请求成功后需要调用。下
 * 载完成后需要调用 [Callback] 的 [Callback.onSuccess] 方法，将下载到的数据传入
 * @author fxc
 * @date 2018/1/15
 */
class LoadMoreAdapter<T>(adapter: BaseAdapter<T>, listener: (Int, Callback<T>) -> Unit) : BaseAdapter<T>() {
	private val mAdapter = adapter
	private val mListener = listener
	private var mPageIndex = 0
	private var isBusy = false
	private var hasMoreData = true

//	private val VIEW_TYPE_NO_MORE = R.layout.lib_load_more_no_more
//	private val VIEW_TYPE_LOADING = R.layout.lib_load_more_loading

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		if (abs(position - mAdapter.itemCount) < 3 && !isBusy && hasMoreData) {
			callRequestData()
		}
		if (!(holder is LoadingViewHolder || holder is NoMoreViewHolder)) {
			mAdapter.onBindViewHolder(holder, position)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//		return when (viewType) {
//			VIEW_TYPE_NO_MORE -> NoMoreViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
//			VIEW_TYPE_LOADING -> LoadingViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
//			else -> mAdapter.onCreateViewHolder(parent, viewType)
//		}
		return mAdapter.onCreateViewHolder(parent, viewType)
	}

	override fun getItemCount(): Int {
		return mAdapter.itemCount + 1
	}

	private fun callRequestData() {
		isBusy = true
		mListener(mPageIndex, object : Callback<T> {

			override fun onSuccess(data: List<T>) {
				if (data.isEmpty()) {
					hasMoreData = false
				}
				mPageIndex++
				mAdapter.appendData(data)
				isBusy = false
				Handler().post({
					notifyDataSetChanged()
				})
			}

			override fun onFailure() {
				isBusy = false
			}

			override fun onFinish() {
				hasMoreData = false
				isBusy = false
				notifyItemChanged(getData().size - 1)
			}

		})
	}

	override fun getItemViewType(position: Int): Int {
//		return if (position == itemCount - 1) {
//			if (hasMoreData) {
//				R.layout.lib_load_more_loading
//			} else {
//				R.layout.lib_load_more_no_more
//			}
//		} else {
//			mAdapter.getItemViewType(position)
//		}
		return mAdapter.getItemViewType(position)
	}

	internal class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	internal class NoMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

	interface Callback<in T> {
		fun onSuccess(data: List<T>)
		fun onFailure()
		fun onFinish()
	}

}