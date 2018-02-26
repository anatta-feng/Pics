package com.fxc.pics.pic.picHome.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.views.color.ColorUtils.reverse
import com.fxc.pics.views.images.FrescoUtils.getAspectRatio
import kotlinx.android.synthetic.main.pic_list_item.view.*

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
class PicListAdapter(data: List<PicListEntity>) : RecyclerView.Adapter<PicListAdapter.ViewHolder>() {
	private val data = data
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(View.inflate(parent.context, R.layout.pic_list_item, null))
	}

	override fun getItemCount(): Int {
		return data.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val bean = data[position]
		val ratio = getAspectRatio(bean.width, bean.height)
		holder.image.aspectRatio = ratio
		holder.image.setUrl(bean.urls.small)
		if (ratio > 1.8f) {
			holder.infoGroup.visibility = View.GONE
		}
		holder.infoGroup.background = ColorDrawable(Color.parseColor(bean.color))
		holder.name.text = bean.user.name
		holder.name.setTextColor(reverse(bean.color))
		holder.userCover.setImageURI(bean.user.profile_image.small)
		holder.likeCount.setTextColor(reverse(bean.color))
		holder.likeCount.text = bean.likes.toString()
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val image = itemView.item_image!!
		val name = itemView.user_name!!
		val infoGroup = itemView.pic_list_info_group!!
		val userCover = itemView.user_cover!!
		val likeCount = itemView.like_count!!
	}
}