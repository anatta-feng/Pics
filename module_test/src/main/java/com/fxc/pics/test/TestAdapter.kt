package com.fxc.pics.test

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.test_item_layout.view.*

/**
 *
 * @author fxc
 * @date 2018/2/20
 */
class TestAdapter(data: ArrayList<String>) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {
	private val data = data

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(View.inflate(parent.context, R.layout.test_item_layout, null))
	}

	override fun getItemCount(): Int {
		return data.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.text.text = data[position]
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val text: TextView = itemView.text_view
	}
}