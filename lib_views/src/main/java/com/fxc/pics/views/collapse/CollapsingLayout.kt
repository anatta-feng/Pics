package com.fxc.pics.views.collapse

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.NestedScrollingParent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxc.pics.views.R
import kotlin.math.abs

/**
 * wing fold list, like QQ Music's discover UI
 * @author fxc
 * @date 2018/2/19
 */
open class CollapsingLayout : CoordinatorLayout, NestedScrollingParent {
	companion object {
		private const val TAG = "CollapsingLayout"
	}

	constructor(context: Context) : super(context)
	constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init(attrs)
		initAppBar()
		initHeadView()
		setHeadParallax()
	}

	private val appBarLayout = AppBarLayout(context)
	private val collapsingLayout = CollapsingToolbarLayout(context)

	private lateinit var headBackgroundView: View
	private lateinit var headInfoView: View
	private val headGradientColorView: View = View(context)
	var headGradientBackground: Drawable? = null
		set(value) {
			field = value
			headGradientColorView.background = value
		}
	var backgroundLayoutResId = -1

	var infoLayoutResId = -1

	var backgroundParallaxMultiplier = 0f
		set(value) {
			field = value
			setHeadParallax()
		}
	var infoParallaxMultiplier = 0f
		set(value) {
			field = value
			setHeadParallax()
		}

	var isHeadGradient = false

	private var headHeight = 0

	private fun init(attrs: AttributeSet) {
		val array = context.obtainStyledAttributes(attrs, R.styleable.CollapsingLayout)
		val n = array.indexCount
		(0 until n)
			.map { array.getIndex(it) }
			.forEach {
				when (it) {
					R.styleable.CollapsingLayout_backgroundLayout ->
						backgroundLayoutResId = array.getResourceId(it, -1)
					R.styleable.CollapsingLayout_infoLayout ->
						infoLayoutResId = array.getResourceId(it, -1)
					R.styleable.CollapsingLayout_head_backgroundParallaxMultiplier ->
						backgroundParallaxMultiplier = array.getFloat(it, 0f)
					R.styleable.CollapsingLayout_head_infoParallaxMultiplier ->
						infoParallaxMultiplier = array.getFloat(it, 0f)
					R.styleable.CollapsingLayout_head_isGradient ->
						isHeadGradient = array.getBoolean(it, false)
					R.styleable.CollapsingLayout_head_gradientBackground -> {
						headGradientBackground = array.getDrawable(it)
						headGradientColorView.background = headGradientBackground
					}
				}
			}
		array.recycle()
	}

	private fun initAppBar() {
		val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
		appBarLayout.layoutParams = params
		addView(appBarLayout, 0)
		appBarLayout.addOnOffsetChangedListener(GradientColorOffsetListener())
	}

	private fun initHeadView() {
		val params = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
		collapsingLayout.layoutParams = params
		appBarLayout.addView(collapsingLayout, 0)
		headBackgroundView = if (backgroundLayoutResId != -1) {
			LayoutInflater.from(context).inflate(backgroundLayoutResId, collapsingLayout, false)
		} else {
			View(context)
		}

		headInfoView = if (infoLayoutResId != -1) {
			LayoutInflater.from(context).inflate(infoLayoutResId, collapsingLayout, false)
		} else {
			View(context)
		}

		collapsingLayout.addView(headBackgroundView)
		collapsingLayout.addView(headInfoView)
		headGradientColorView.alpha = 0f
		collapsingLayout.addView(headGradientColorView)
	}

	private fun setHeadParallax() {
		val backgroundParams = headBackgroundView.layoutParams as CollapsingToolbarLayout.LayoutParams
		val infoParams = headInfoView.layoutParams as CollapsingToolbarLayout.LayoutParams
		backgroundParams.collapseMode = COLLAPSE_MODE_PARALLAX
		infoParams.collapseMode = COLLAPSE_MODE_PARALLAX
		backgroundParams.parallaxMultiplier = backgroundParallaxMultiplier
		infoParams.parallaxMultiplier = infoParallaxMultiplier
	}

	override fun onFinishInflate() {
		super.onFinishInflate()
		initBehavior()
	}

	private fun initBehavior() {
		if (childCount < 2) {
			return
		}
		(1 until childCount)
				.map { getChildAt(it) }
				.forEach {
					val params = it.layoutParams as LayoutParams
					params.behavior = AppBarLayout.ScrollingViewBehavior()
				}
	}

	override fun onLayoutChild(child: View?, layoutDirection: Int) {
		super.onLayoutChild(child, layoutDirection)
		headHeight = appBarLayout.height
	}

	private inner class GradientColorOffsetListener : AppBarLayout.OnOffsetChangedListener {
		override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
			if (!isHeadGradient) {
				return
			}
			if (verticalOffset > 0) {
				return
			}
			val offset = abs(verticalOffset)
			val fraction = 1.0f / headHeight
			val alpha = fraction * offset
			headGradientColorView.alpha = alpha
		}
	}


}