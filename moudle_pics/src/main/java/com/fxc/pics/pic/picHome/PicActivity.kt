package com.fxc.pics.pic.picHome

import android.util.Log
import android.view.Menu
import com.fxc.pics.common.base.BaseActivity
import com.fxc.pics.common.base.BaseFragment
import com.fxc.pics.pic.R
import com.fxc.pics.pic.picHome.adapter.PicHomeFragmentAdapter
import com.fxc.pics.pic.picHome.fragments.PicDiscoverFragment
import com.fxc.pics.pic.picHome.fragments.PicHomeFragment
import kotlinx.android.synthetic.main.pic_activity_pic.*
import kotlinx.android.synthetic.main.pic_activity_title.*

class PicActivity : BaseActivity() {
	private val fragments = ArrayList<BaseFragment>()
	override fun getContentViewId(): Int = R.layout.pic_activity_pic

	override fun initWidget() {
		super.initWidget()
		initViewPager()
		initBottomNavigation()
		setSupportActionBar(pic_tool_bar)
		Log.d("asdzc", "su $supportActionBar")
//		supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

	override fun afterInitWidget() {
		super.afterInitWidget()

	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.test, menu)
		return super.onCreateOptionsMenu(menu)
	}
}
