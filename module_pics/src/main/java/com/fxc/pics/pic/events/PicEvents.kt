package com.fxc.pics.pic.events

import com.fxc.pics.events.Events
import com.fxc.pics.pic.network.entities.PicListEntity

/**
 * @author fxc
 * @date 2018/3/3
 */
class PicEvents : Events() {
	class PicDetailReadyEvent
	data class PicEnterDetailEvent(val data: List<PicListEntity>)
}