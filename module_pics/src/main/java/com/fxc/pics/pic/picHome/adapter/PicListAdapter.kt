package com.fxc.pics.pic.picHome.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.views.images.FrescoUtils.getAspectRatio
import kotlinx.android.synthetic.main.pic_fragment_pics_list_item.view.*

/**
 *
 * @author fxc
 * @date 2018/2/21
 */
class PicListAdapter(data: List<PicListEntity>) : RecyclerView.Adapter<PicListAdapter.ViewHolder>() {
	private val data = data
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pic_fragment_pics_list_item, parent, false))
	}

	override fun getItemCount(): Int {
		return data.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val bean = data[position]
		holder.image.setImageURI(bean.urls.small)
		holder.name.text = bean.user.name
		holder.userCover.setImageURI(bean.user.profile_image.small)
		holder.likeView.likeCount = bean.likes
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val image = itemView.item_image!!
		val name = itemView.user_name!!
//		val infoGroup = itemView.pic_list_info_group!!
		val userCover = itemView.user_cover!!
		val likeView = itemView.item_likeView!!
	}
}