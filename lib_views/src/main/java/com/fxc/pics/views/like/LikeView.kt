package com.fxc.pics.views.like

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.fxc.pics.views.R
import com.fxc.pics.views.textView.UserNameTextView

/**
 *
 * @author fxc
 * @date 2018/2/27
 */
class LikeView : LinearLayout {
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet) : this(context, attrs, 0)
	constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init(attrs)
		orientation = HORIZONTAL
		initChild()
	}

	private var tvLikeCount = UserNameTextView(context)
	private var ibLikeIcon = ImageButton(context)

	private val ORDER_POSITIVE = 1
	private val ORDER_REVERSE = -1

	var order = ORDER_POSITIVE
	var likeCount = 0
		set(value) {
			field = value
			tvLikeCount.text = value.toString()
		}

	var likeIcon = ContextCompat.getDrawable(context, R.drawable.like_view_favor_selector)!!
		set(value) {
			field = value
			ibLikeIcon.setImageDrawable(value)
		}


	private fun initChild() {
		val countParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
		val iconParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
		iconParams.weight = 1.0f
		countParams.gravity = Gravity.CENTER_VERTICAL
		iconParams.gravity = Gravity.CENTER_VERTICAL
		tvLikeCount.layoutParams = countParams
		ibLikeIcon.layoutParams = iconParams
		ibLikeIcon.setImageDrawable(likeIcon)
		tvLikeCount.text = likeCount.toString()
		ibLikeIcon.background = ColorDrawable(ContextCompat.getColor(context, R.color.transparent))
		when (order) {

			ORDER_POSITIVE -> {
				addView(tvLikeCount)
				addView(ibLikeIcon, 0)
			}

			ORDER_REVERSE -> {
				addView(ibLikeIcon)
				addView(tvLikeCount, 0)
			}
		}
	}

	private fun init(attrs: AttributeSet) {
		val array = context.obtainStyledAttributes(attrs, R.styleable.LikeView)
		val n = array.indexCount
		(0 until n).map { array.getIndex(it) }
				.forEach {
					when (it) {
						R.styleable.LikeView_font -> tvLikeCount.typeface = ResourcesCompat.getFont(context, array.getResourceId(it, R.font.user_name_font))
						R.styleable.LikeView_order -> order = array.getInt(it, ORDER_POSITIVE)
						R.styleable.LikeView_likeIcon -> likeIcon = array.getDrawable(it)
					}
				}
		array.recycle()
	}

}