package com.fxc.pics.pic.picDetail

import android.support.v4.app.SharedElementCallback
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import com.fxc.pics.common.base.PresenterActivity
import com.fxc.pics.common.events.EventUtil
import com.fxc.pics.pic.R
import com.fxc.pics.pic.events.PicEvents
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.picDetail.adapters.PicDetailFragmentAdapter
import kotlinx.android.synthetic.main.pic_activity_pic_detail.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class PicDetailActivity : PresenterActivity<PicDetailPresenterImp>() {

	companion object {
		private const val TAG = "PicDetailActivity"
		const val KEY_PIC_ID = "pic_id"
		const val KEY_PIC_URL = "pic_url"
	}

	private var data = ArrayList<PicListEntity>()
	private var selectPosition: Int = 0

	private var mIsReturning = false

	override fun initPresenter(): PicDetailPresenterImp {
		return PicDetailPresenterImp(this)
	}

	override fun getContentViewId(): Int {
		return R.layout.pic_activity_pic_detail
	}

	override fun beforeInitWidget() {
		super.beforeInitWidget()
		postponeEnterTransition()
		setEnterSharedElementCallback(PicDetailEnterSharedCallback())
	}

	override fun initWidget() {
		super.initWidget()
		initViewPager()
	}

	override fun afterInitWidget() {
		super.afterInitWidget()
		EventUtil.post(PicEvents.PicDetailReadyEvent())
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	fun recieveList(event: PicEvents.PicEnterDetailEvent) {
		data.addAll(event.data)
		pic_vp_detail_viewPager.adapter = PicDetailFragmentAdapter(data, supportFragmentManager)
		selectPosition = event.position
		Log.d("asdqw", "position $selectPosition  ss ${event.position}")

		pic_vp_detail_viewPager.setCurrentItem(selectPosition, true)
	}

	fun queryPicEntity(position: Int): PicListEntity {
		return data[position]
	}

	private fun initViewPager() {
		pic_vp_detail_viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
			override fun onPageSelected(position: Int) {
				selectPosition = position
			}

		})
	}

	override fun finishAfterTransition() {
		mIsReturning = true
		super.finishAfterTransition()
	}

	override fun error(failReason: String) {
	}

	private inner class PicDetailEnterSharedCallback : SharedElementCallback() {
		override fun onMapSharedElements(names: MutableList<String>, sharedElements: MutableMap<String, View>) {
			super.onMapSharedElements(names, sharedElements)
			if (!mIsReturning) {
				return
			}
			val fragment = (pic_vp_detail_viewPager.adapter as PicDetailFragmentAdapter).fragment
			val sharedElement = fragment?.getSharedElements()
			if (sharedElement == null) {
				names.clear()
				sharedElements.clear()
			} else {
				names.clear()
				sharedElements.clear()
				for (element in sharedElement) {
					names.add(element.transitionName)
					sharedElements[element.transitionName] = element
				}

			}

		}
	}
}