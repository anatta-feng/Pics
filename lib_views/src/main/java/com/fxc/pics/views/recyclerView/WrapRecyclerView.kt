package com.fxc.pics.views.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
open class WrapRecyclerView : RecyclerView {
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
	constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

	private var mWrapAdapter: WrapRecyclerViewAdapter? = null
	private var mAdapter: RecyclerView.Adapter<*>? = null

	private val mDataObserver = RecyclerViewObserver()

	override fun setAdapter(adapter: Adapter<*>?) {
		mAdapter?.unregisterAdapterDataObserver(mDataObserver)
		mAdapter = adapter
		mWrapAdapter = adapter as? WrapRecyclerViewAdapter ?: WrapRecyclerViewAdapter(adapter)
		super.setAdapter(mWrapAdapter)
		mAdapter?.registerAdapterDataObserver(mDataObserver)
		mWrapAdapter?.adjustSpanSize(this)
	}

	fun addHeaderView(view: View) {
		mWrapAdapter?.addHeaderView(view)
	}

	fun addFooterView(view: View) {
		mWrapAdapter?.addFooterView(view)
	}

	fun removeHeaderView(view: View) {
		mWrapAdapter?.removeHeaderView(view)
	}

	fun removeFooterView(view: View) {
		mWrapAdapter?.removeFooterView(view)
	}

	fun setOnItemClickListener(listener: (View, Int) -> Unit) {
		mWrapAdapter?.setOnItemClickListener(listener)
	}

	fun setOnItemLongClickListener(listener: (View, Int) -> Boolean) {
		mWrapAdapter?.setOnItemLongClickListener(listener)
	}

	override fun getChildAdapterPosition(child: View?): Int {
		var headCount = 0
		if (mWrapAdapter != null) {
			headCount = mWrapAdapter?.headerCount!!
		}
		return super.getChildAdapterPosition(child) - headCount
	}

	private inner class RecyclerViewObserver : AdapterDataObserver() {
		override fun onChanged() {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyDataSetChanged没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyDataSetChanged()
		}

		override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyDataSetChanged没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyItemRemoved(positionStart)
		}

		override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyItemMoved没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyItemMoved(fromPosition, toPosition)
		}

		override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyItemChanged没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyItemChanged(positionStart)
		}

		override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyItemChanged没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyItemChanged(positionStart, payload)
		}

		override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
			if (mAdapter == null) return
			// 观察者  列表Adapter更新 包裹的也需要更新不然列表的notifyItemInserted没效果
			if (mWrapAdapter !== mAdapter)
				mWrapAdapter?.notifyItemInserted(positionStart)
		}

	}
}