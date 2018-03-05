package com.fxc.pics.pic.picDetail

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import com.facebook.imagepipeline.image.ImageInfo
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.common.format.formatWithThousandPoints
import com.fxc.pics.pic.R
import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.PicRelatedEntity
import com.fxc.pics.pic.picDetail.adapters.PicDetailRelatedAdapter
import com.fxc.pics.views.recyclerView.WrapRecyclerView
import com.fxc.pics.views.recyclerView.itemDecoration.SpaceItemDecoration
import kotlinx.android.synthetic.main.pic_author_info_block.view.*
import kotlinx.android.synthetic.main.pic_detail_author_info.view.*
import kotlinx.android.synthetic.main.pic_fragment_pic_detail.view.*

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragment : PresenterFragment<PicDetailFragmentPresenterImp, PicDetailActivity>() {

	companion object {
		const val KEY_IMAGE = "key_image"
		const val KEY_INFO_GROUP = "key_info_group"

		const val KEY_SELECT_POSITION = "select_position"

		fun getInstance(position: Int): PicDetailFragment {
			val instance = PicDetailFragment()
			val bundle = Bundle()
			bundle.putInt(KEY_SELECT_POSITION, position)
			instance.arguments = bundle
			return instance
		}
	}

	private lateinit var headerView: View
	private val relatedData = ArrayList<PicRelatedEntity.ResultsBean>()

	private lateinit var recyclerView: WrapRecyclerView

	override fun initPresenter(): PicDetailFragmentPresenterImp = PicDetailFragmentPresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_pic_detail

	override fun beforeInitWidget() {
		super.beforeInitWidget()
	}

	override fun initWidget() {
		super.initWidget()
		initRecyclerView()
		initHeadView()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair(rootView.pic_detail_image, KEY_IMAGE))
		initListener()
	}

	private fun initListener() {
		rootView.pic_detail_image.listener = { id: String, imageInfo: ImageInfo?, animatable: Animatable? ->
		}
		recyclerView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener{
			override fun onPreDraw(): Boolean {
				recyclerView.viewTreeObserver.removeOnPreDrawListener(this)
				activity.startPostponedEnterTransition()
				return true
			}

		})
		recyclerView.setOnItemLongClickListener { _, _ ->
			true
		}
	}

	private fun initRecyclerView() {
		recyclerView = rootView.pic_detail_related_list
		recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
		recyclerView.adapter = PicDetailRelatedAdapter(relatedData)
		recyclerView.addItemDecoration(SpaceItemDecoration(40, 35))
	}

	private fun initHeadView() {
		headerView = LayoutInflater.from(context).inflate(R.layout.pic_detail_author_info, recyclerView, false)
		headerView.pic_author_info_likes.pic_pic_info_title.text = getString(R.string.pic_info_title_likes)
		headerView.pic_author_info_downloads.pic_pic_info_title.text = getString(R.string.pic_info_title_downloads)
		headerView.pic_author_info_views.pic_pic_info_title.text = getString(R.string.pic_info_title_views)
		recyclerView.addHeaderView(headerView)
		recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
			override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
				super.onScrolled(recyclerView, dx, dy)
			}

			override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
				ViewConfiguration.getTouchSlop()
				super.onScrollStateChanged(recyclerView, newState)
			}
		})
	}

	override fun error(failReason: String) {

	}

	fun setDetailImageUrl(url: String) {
		rootView.pic_detail_image.setUrl(url)
	}

	fun getSharedElements(): Array<View> {
		return arrayOf(rootView.pic_detail_image)
	}

	fun setAuthorInfo(user: PicListEntity.UserBean) {
		headerView.pic_author_info_cover.setUrl(user.profile_image.medium)
		headerView.pic_author_info_name.text = user.name
	}

	fun setPhotoDetail(bean: PicDetailEntity) {
		headerView.pic_author_info_likes.pic_pic_info_count.text = formatWithThousandPoints(bean.likes)
		headerView.pic_author_info_downloads.pic_pic_info_count.text = formatWithThousandPoints(bean.downloads)
		headerView.pic_author_info_views.pic_pic_info_count.text = formatWithThousandPoints(bean.views)
	}

	fun setRelatedPicData(data: List<PicRelatedEntity.ResultsBean>) {
		relatedData.addAll(data)
		recyclerView.adapter.notifyDataSetChanged()
	}

}