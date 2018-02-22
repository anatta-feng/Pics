package com.fxc.pics.views.color

import android.graphics.Bitmap
import android.graphics.Color
import android.support.v7.graphics.Palette
import kotlin.math.abs

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
object ColorUtils {
	/**
	 * 对颜色做取反处理
	 * @param color 待取反颜色
	 * @return 取反后的颜色
	 */
	fun reverse(color: String): Int {
		return reverse(Color.parseColor(color))
	}

	/**
	 * 对颜色做取反处理
	 * @param color 待取反颜色
	 * @return 取反后的颜色
	 */
	fun reverse(color: Int): Int {
		val red = Color.red(color)
		val green = Color.green(color)
		val blue = Color.blue(color)
		return Color.rgb(abs(red - 255), abs(green - 255), abs(blue - 255))
	}

	/**
	 * 解析图片中出现较多的集中色彩
	 * @param pic 待分析图片
	 * @param listener 回调
	 * @return [IntArray] index 有小到大的色彩分别代表：[活力颜色, 亮的活力颜色, 暗的活力颜色, 柔色, 亮的柔色, 暗的柔色]
	 *                      其中，[活力颜色] 最不可能为0，其次是[亮的活力颜色], 其他均有概率为0
	 */
	fun parsePicColor(pic: Bitmap, listener: (IntArray) -> Unit) {
		Palette.Builder(pic).generate {
			val array = IntArray(6)
			array[0] = if (it.vibrantSwatch != null) it.vibrantSwatch!!.rgb else 0
			array[1] = if (it.lightVibrantSwatch != null) it.lightVibrantSwatch!!.rgb else 0
			array[2] = if (it.darkVibrantSwatch != null) it.darkVibrantSwatch!!.rgb else 0
			array[3] = if (it.mutedSwatch != null) it.mutedSwatch!!.rgb else 0
			array[4] = if (it.lightMutedSwatch != null) it.lightMutedSwatch!!.rgb else 0
			array[5] = if (it.darkMutedSwatch != null) it.darkMutedSwatch!!.rgb else 0
			listener(array)
		}

	}
}
