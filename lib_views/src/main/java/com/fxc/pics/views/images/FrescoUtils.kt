package com.fxc.pics.views.images

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
object FrescoUtils {
	fun getAspectRatio(width: Int, height: Int): Float {
		val ratio = width.toFloat() / height.toFloat()
		return when {
			ratio < 0.7f -> 0.7f
			ratio > 1.6f -> 1.6f
			else -> ratio
		}
	}
}
