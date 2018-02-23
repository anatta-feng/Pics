package com.fxc.pics.views.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class WrapRecyclerView : RecyclerView {
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
	constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

	private var mAdapter: WrapRecyclerViewAdapter? = null

	override fun setAdapter(adapter: Adapter<*>?) {
		mAdapter = adapter as? WrapRecyclerViewAdapter ?: WrapRecyclerViewAdapter(adapter)
		Log.d("asdxzc", "mA $mAdapter")
		super.setAdapter(mAdapter)
//		mAdapter?.unregisterAdapterDataObserver(getObserver())
//		mAdapter?.registerAdapterDataObserver(getObserver())

	}

	fun addHeaderView(view: View) {
		mAdapter?.addHeaderView(view)
	}

	fun addFooterView(view: View) {
		mAdapter?.addFooterView(view)
	}

	fun removeHeaderView(view: View) {
		mAdapter?.removeHeaderView(view)
	}

	fun removeFooterView(view: View) {
		mAdapter?.removeFooterView(view)
	}

	private fun getObserver(): AdapterDataObserver {
		val observerFiled = RecyclerView::class.java.getDeclaredField("mObserver")
		observerFiled.isAccessible = true
		return observerFiled.get(this) as AdapterDataObserver
	}

	fun setOnItemClickListener(listener: (View, Int) -> Unit) {
		mAdapter?.setOnItemClickListener(listener)
	}

	fun setOnItemLongClickListener(listener: (View, Int) -> Boolean) {
		mAdapter?.setOnItemLongClickListener(listener)
	}
}