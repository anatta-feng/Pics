package com.fxc.pics.views.viewPager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import com.fxc.pics.views.R

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
class NoScrollViewPager : ViewPager {
	var isPagingEnabled = false

	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
		initAttrs(attrs)
	}

	private fun initAttrs(attrs: AttributeSet) {
		val array = context.obtainStyledAttributes(attrs, R.styleable.NoScrollViewPager)
		val count = array.indexCount
		(0 until count)
				.map{array.getIndex(it)}
				.forEach {
					when (it) {
						R.styleable.NoScrollViewPager_pagingEnable -> {
							isPagingEnabled = array.getBoolean(it, false)
						}
					}
				}
		array.recycle()
	}

	override fun onTouchEvent(ev: MotionEvent?): Boolean {
		return isPagingEnabled && super.onTouchEvent(ev)
	}

	override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
		return isPagingEnabled && super.onInterceptTouchEvent(ev)
	}
}