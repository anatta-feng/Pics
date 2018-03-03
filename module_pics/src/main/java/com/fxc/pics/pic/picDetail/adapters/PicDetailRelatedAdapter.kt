package com.fxc.pics.pic.picDetail.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicRelatedEntity
import com.fxc.pics.views.images.FrescoUtils
import kotlinx.android.synthetic.main.pic_related_item_layout.view.*

/**
 * @author fxc
 * @date 2018/3/3
 */
class PicDetailRelatedAdapter(data: List<PicRelatedEntity.ResultsBean>) : RecyclerView.Adapter<PicDetailRelatedAdapter.ViewHolder>() {
	private val mData = data
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pic_related_item_layout, parent, false))
	}

	override fun getItemCount(): Int = mData.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val bean = mData[position]
		val ratio = FrescoUtils.getAspectRatio(bean.width, bean.height)
		holder.image.aspectRatio = ratio
		holder.image.setUrl(bean.urls.small)
		holder.likeView.likeCount = bean.likes
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		internal val image = itemView.pic_related_item_image
		internal val likeView = itemView.pic_related_item_likeView
	}
}