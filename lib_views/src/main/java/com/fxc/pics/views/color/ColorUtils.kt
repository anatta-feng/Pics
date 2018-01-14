package com.fxc.pics.views.color

import android.graphics.Color
import kotlin.math.abs

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
fun reverse(color: String): Int {
	return reverse(Color.parseColor(color))
}

fun reverse(color: Int): Int {
	val red = Color.red(color)
	val green = Color.green(color)
	val blue = Color.blue(color)
	return Color.rgb(abs(red - 255), abs(green - 255), abs(blue - 255))
}