package com.fxc.pics.views.images

/**
 *
 * @author fxc
 * @date 2018/2/22
 */
object FrescoUtils {
	fun getAspectRatio(width: Int, height: Int): Float {
		val ratio = width.toFloat() / height.toFloat()
		if (ratio < 0.7f) {
			return 0.7f
		}
		return ratio
	}
}
