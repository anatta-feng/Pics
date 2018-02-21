package com.fxc.pics.views.collapse

import android.animation.ValueAnimator
import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.v4.view.NestedScrollingParent
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.OverScroller
import com.fxc.pics.views.R
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.round

/**
 * wing fold list, like QQ Music's discover UI
 * @author fxc
 * @date 2018/2/19
 */
class CollapsingLayout : LinearLayout, NestedScrollingParent {
	companion object {
		private const val TAG = "CollapsingLayout"
	}

	constructor(context: Context) : super(context)
	constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init(attrs)
		initAppBar()
		initAnimator()
	}

	private val appBarLayout = AppBarLayout(context)

	private var backgroundLayoutResId = -1

	private var infoLayoutResId = -1
	private var headHeight = 0

	private val mScroller = OverScroller(context)

	private lateinit var mOffsetAnamator : ValueAnimator

	init {
		val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
		appBarLayout.layoutParams = params
		addView(appBarLayout, 0)
	}

	private fun init(attrs: AttributeSet) {
		val array = context.obtainStyledAttributes(attrs, R.styleable.CollapsingLayout)
		backgroundLayoutResId = array.getResourceId(R.styleable.CollapsingLayout_background_layout, -1)
		infoLayoutResId = array.getResourceId(R.styleable.CollapsingLayout_info_layout, -1)
		headHeight = array.getDimension(R.styleable.CollapsingLayout_head_height, 0f).toInt()
		array.recycle()
	}

	private fun initAppBar() {
		if (backgroundLayoutResId != -1) {
			View.inflate(context, backgroundLayoutResId, appBarLayout)
		}
		if (infoLayoutResId != -1) {
			View.inflate(context, infoLayoutResId, appBarLayout)
		}
	}

	private fun initAnimator() {
		mOffsetAnamator = ValueAnimator()
		mOffsetAnamator.interpolator = LinearInterpolator()
		mOffsetAnamator.addUpdateListener {
			val value = it.animatedValue
			if (value is Int) {
				scrollTo(0, value)
			}
		}
	}

	override fun onStartNestedScroll(child: View, target: View, @ViewCompat.ScrollAxis axes: Int): Boolean {
		Log.d(TAG, "onStartNestedScroll")
		return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
	}

	override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
		Log.d(TAG, "onNestedPreScroll dy $dy target $target")
		val hiddenTop = dy > 0 && scrollY < headHeight
		//TODO [canScrollVertically] 可以用来判断 RecyclerView 是否可以继续滚动
		val showTop = dy < 0 && scrollY > 0 && target.canScrollVertically(-1)
		if (hiddenTop || showTop) {
			scrollBy(0, dy)
			consumed[1] = dy
		}
	}

	override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
		Log.d(TAG, "onNestedPreFling y $velocityY")
		if (scrollY >= headHeight) return false
		fling(velocityY.toInt())
		return true
	}

	override fun onNestedFling(target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
		var consum = false
		if (target is RecyclerView && velocityY < 0) {
			val firstChild = target.getChildAt(0)
			val childAdapterPosition = target.getChildAdapterPosition(firstChild)
			consum = childAdapterPosition > 3
		}
		if (!consum) {
			animateScroll(velocityY, computeDuration(0), consum)
		}
		return true
	}

	private fun animateScroll(velocityY: Float, duration: Int, consumed: Boolean) {
		val currentOffset = scrollY
		val topHeight = 1
		mOffsetAnamator.cancel()
		mOffsetAnamator.duration = min(duration, 600).toLong()
		if (velocityY > 0) {
			mOffsetAnamator.setIntValues(currentOffset, topHeight)
			mOffsetAnamator.start()
		} else {
			if (!consumed) {
				mOffsetAnamator.setIntValues(currentOffset, 0)
				mOffsetAnamator.start()
			}
		}
	}

	private fun computeDuration(dy: Int): Int {
		val distance = if (dy > 0) {
			abs(1 - scrollY)
		} else {
			abs(scrollY)
		}
		val delta = abs(dy)
		return if (delta > 0) {
			(3 * round(1000 * (distance / delta).toFloat())).toInt()
		} else {
			val distanceRatio = distance / height
			(distanceRatio + 1) * 150
		}
	}

	private fun fling(dy: Int) {
		Log.d(TAG, "fling dy $dy")
	}

	override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec)
		headHeight = appBarLayout.height
	}
}