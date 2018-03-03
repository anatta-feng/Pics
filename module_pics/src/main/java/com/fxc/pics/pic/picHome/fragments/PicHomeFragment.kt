package com.fxc.pics.pic.picHome.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import com.fxc.pics.common.base.PresenterFragment
import com.fxc.pics.common.events.EventUtil
import com.fxc.pics.pic.R
import com.fxc.pics.pic.events.PicEvents
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.picDetail.PicDetailActivity
import com.fxc.pics.pic.picDetail.PicDetailFragment
import com.fxc.pics.pic.picHome.PicActivity
import com.fxc.pics.pic.picHome.adapter.PicListAdapter
import com.fxc.pics.views.images.FrescoUtils
import com.fxc.pics.views.recyclerView.itemDecoration.SpaceItemDecoration
import kotlinx.android.synthetic.main.pic_fragment_home.view.*
import kotlinx.android.synthetic.main.pic_fragment_pics_list_item.view.*
import kotlinx.android.synthetic.main.pic_home_head.view.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicHomeFragment : PresenterFragment<PicHomePresenterImp, PicActivity>() {

	companion object {
		fun newInstance(): PicHomeFragment {
			val fragment = PicHomeFragment()
			val bundle = Bundle()
			fragment.arguments = bundle
			return fragment
		}

		const val KEY_PIC_TITLE = "key_pic_title"
		const val KEY_PIC_SUBTITLE = "key_pic_subtitle"
		const val KEY_PIC_ITEM_IMAGE = "key_pic_item_image"
	}

	private val data = ArrayList<PicListEntity>()
	private var clickPosition: Int = 0

	private lateinit var mHeaderView: View

	override fun initPresenter(): PicHomePresenterImp = PicHomePresenterImp(this)

	override fun getContentViewId(): Int = R.layout.pic_fragment_home

	override fun error(failReason: String) {

	}

	override fun initWidget() {
		super.initWidget()
		initRecyclerView()
		mHeaderView = LayoutInflater.from(context).inflate(R.layout.pic_home_head, rootView.pic_home_recycler_view, false)
		rootView.pic_home_recycler_view.addHeaderView(mHeaderView)
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		bindShareElement(Pair.create(mHeaderView.user_title, KEY_PIC_TITLE),
				Pair.create(mHeaderView.pic_subtitle, KEY_PIC_SUBTITLE))
		initListener()

	}

	private fun initListener() {
		rootView.pic_home_recycler_view.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
			override fun onPreDraw(): Boolean {
				rootView.pic_home_recycler_view.viewTreeObserver.removeOnPreDrawListener(this)
				return true
			}
		})

		rootView.pic_home_recycler_view.setOnItemClickListener { view, position ->
			run {
				FrescoUtils.isInCache(data[position].urls.small)
						.subscribe {
							if (it) {
								clickPosition = position
								startDetailActivity(view, position)
							} else {
								notifyPicNotReady()
							}
						}
			}
		}
	}

	private fun notifyPicNotReady() {
		Snackbar.make(rootView, getString(R.string.pic_not_ready_alter), Snackbar.LENGTH_SHORT).show()
	}

	private fun startDetailActivity(view: View, position: Int) {
		val params = HashMap<String, String>()
		params[PicDetailActivity.KEY_PIC_ID] = data[position].id
		params[PicDetailActivity.KEY_PIC_URL] = data[position].urls.small
		startActivityBySharedElement(params, PicDetailActivity::class.java, Pair(view.item_image, PicDetailFragment.KEY_IMAGE))
	}

	private fun initRecyclerView() {
		rootView.pic_home_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
		rootView.pic_home_recycler_view.adapter = PicListAdapter(data)
		rootView.pic_home_recycler_view.addItemDecoration(SpaceItemDecoration(45, 70))
	}

	fun dataArrive(data: List<PicListEntity>) {
		this@PicHomeFragment.data.addAll(data)
		rootView.pic_home_recycler_view.adapter.notifyDataSetChanged()

		readyToCompete()
	}

	private fun readyToCompete() {
		//TODO 空指针
		activity.startPostponedEnterTransition()
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	fun onDetailReady(event: PicEvents.PicDetailReadyEvent) {
		EventUtil.post(PicEvents.PicEnterDetailEvent(data, clickPosition))
	}

}