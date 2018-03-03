package com.fxc.pics.pic.picDetail

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.facebook.imagepipeline.image.ImageInfo
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.pic.R
import kotlinx.android.synthetic.main.pic_fragment_pic_detail.view.*

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragment : PresenterFragment<PicDetailFragmentPresenterImp, PicDetailActivity>() {

	companion object {
		const val KEY_IMAGE = "key_image"

		const val KEY_SELECT_POSITION = "select_position"

		fun getInstance(position: Int): PicDetailFragment {
			val instance = PicDetailFragment()
			val bundle = Bundle()
			bundle.putInt(KEY_SELECT_POSITION, position)
			instance.arguments = bundle
			return instance
		}
	}

	override fun initPresenter(): PicDetailFragmentPresenterImp = PicDetailFragmentPresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_pic_detail

	override fun beforeInitWidget() {
		super.beforeInitWidget()
	}

	override fun initWidget() {
		super.initWidget()
		initRecyclerView()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(rootView.pic_detail_image, KEY_IMAGE))
		initListener()
	}

	private fun initListener() {
		rootView.pic_detail_image.listener = { id: String, imageInfo: ImageInfo?, animatable: Animatable? ->
			activity.startPostponedEnterTransition()
		}
	}

	private fun initRecyclerView() {
		rootView.pic_detail_related_list.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VISIBLE)
	}

	override fun error(failReason: String) {

	}

	fun setDetailImageUrl(url: String) {
		rootView.pic_detail_image.setUrl(url)
	}

	fun getSharedElements(): Array<View> {
		return arrayOf(rootView.pic_detail_image)
	}
}