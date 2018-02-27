package com.fxc.pics.views.textView

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.fxc.pics.views.R

/**
 *
 * @author fxc
 * @date 2018/2/27
 */
class UserNameTextView : AppCompatTextView {
	constructor(context: Context?) : super(context)
	constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
	constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

	init {
		typeface = ResourcesCompat.getFont(context, R.font.user_name_font)
	}
}