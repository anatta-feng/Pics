package com.fxc.pics.pic.picHome

import android.support.design.widget.Snackbar
import android.support.v4.app.SharedElementCallback
import android.util.Log
import android.view.View
import com.fxc.pics.common.base.BaseFragment
import com.fxc.pics.pic.R
import com.fxc.pics.pic.base.ToolBarActivity
import com.fxc.pics.pic.picHome.adapter.PicHomeFragmentAdapter
import com.fxc.pics.pic.picHome.fragments.PicDiscoverFragment
import com.fxc.pics.pic.picHome.fragments.PicHomeFragment
import kotlinx.android.synthetic.main.pic_activity_pic.*

class PicActivity : ToolBarActivity<PicPresenterImp>() {

	companion object {
		private const val TAG = "PicActivity"
	}

	private val fragments = ArrayList<BaseFragment<*>>()

	override fun error(failReason: String) {
	}

	override fun initPresenter(): PicPresenterImp = PicPresenterImp(this)

	override fun getMenuViewId(): Int = R.menu.pic_search

	override fun getContentViewId(): Int = R.layout.pic_activity_pic

	override fun beforeInitWidget() {
		super.beforeInitWidget()
		postponeEnterTransition()
	}

	override fun initWidget() {
		super.initWidget()
		initViewPager()
		initBottomNavigation()
		initToolBar(R.id.pic_tool_bar)
		setTitle(R.id.pic_tv_title, getString(R.string.pic_list_title))
		initListener()
	}

	private fun initListener() {
		setMenuOnItemClickListener {
			val id = it.itemId
			return@setMenuOnItemClickListener when (id) {
				R.id.test -> {
					Snackbar.make(window.decorView, "asd", Snackbar.LENGTH_SHORT).show()
					true
				}
				else ->
					false
			}
		}

		setEnterSharedElementCallback(object : SharedElementCallback() {
			override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
				super.onMapSharedElements(names, sharedElements)
				Log.d(TAG, "onMapSharedElements  names ${names?.get(0)}")
			}
		})
	}

	private fun initBottomNavigation() {
		pic_main_Navigation.setOnNavigationItemSelectedListener {

			val id = it.itemId
			return@setOnNavigationItemSelectedListener when (id) {
				R.id.pic_home -> {
					pic_main_viewPager.currentItem = 0
					true
				}
				R.id.pic_discover -> {
					pic_main_viewPager.currentItem = 1
					true
				}
				else ->
					false
			}
		}
	}

	private fun initViewPager() {
		addFragments()
		val adapter = PicHomeFragmentAdapter(fragments, supportFragmentManager)
		pic_main_viewPager.adapter = adapter
	}

	private fun addFragments() {
		fragments.add(PicHomeFragment.newInstance())
		fragments.add((PicDiscoverFragment.newInstance()))
	}

}
