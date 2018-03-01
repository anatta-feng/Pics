package com.fxc.pics.pic.base

import android.support.annotation.IdRes
import android.support.annotation.MenuRes
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.fxc.pics.common.BaseContract
import com.fxc.pics.common.base.PresenterActivity

/**
 *
 * @author fxc
 * @date 2018/2/28
 */
abstract class ToolBarActivity<Presenter : BaseContract.Presenter> : PresenterActivity<Presenter>() {

	private var toolBar: Toolbar? = null

	fun initToolBar(@IdRes viewId: Int) {
		toolBar = findViewById(viewId)
		if (toolBar !is Toolbar) {
			throw IllegalArgumentException("The is not ToolBar")
		}
		setSupportActionBar(toolBar)
	}

	fun setDisplayHomeAsUpEnabled(enabled: Boolean) {
		supportActionBar?.setDisplayHomeAsUpEnabled(enabled)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(getMenuViewId(), menu)
		return super.onCreateOptionsMenu(menu)
	}

	fun setMenuOnItemClickListener(listener: (MenuItem) -> Boolean) {
		toolBar?.setOnMenuItemClickListener { listener.invoke(it) }
	}

	fun setTitle(@IdRes id: Int, title: String) {
		val view = findViewById<TextView>(id)
		view.text = title
	}

	@MenuRes
	abstract fun getMenuViewId(): Int
}