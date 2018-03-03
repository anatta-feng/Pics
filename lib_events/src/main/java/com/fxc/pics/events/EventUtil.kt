package com.fxc.pics.events

import org.greenrobot.eventbus.EventBus

/**
 * @author fxc
 * @date 2018/3/3
 */
object EventUtil {
	var eventBus = EventBus.getDefault()

	fun post(event: Any) {
		eventBus.post(event)
	}

	fun isRegister(subscribe: Any) {
		eventBus.isRegistered(subscribe)
	}
}