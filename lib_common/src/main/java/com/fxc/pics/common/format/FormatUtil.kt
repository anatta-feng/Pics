package com.fxc.pics.common.format

import java.text.NumberFormat

/**
 * @author fxc
 * @date 2018/3/4
 */
fun formatWithThousandPoints(src: Int): String {
	val format = NumberFormat.getNumberInstance()
	return format.format(src)
}