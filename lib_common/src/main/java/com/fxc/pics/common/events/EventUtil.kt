package com.fxc.pics.common.events

import org.greenrobot.eventbus.EventBus

/**
 * @author fxc
 * @date 2018/3/3
 */
object EventUtil {
	var eventBus: EventBus = EventBus.getDefault()

	fun post(event: Any) {
		eventBus.post(event)
	}

	fun register(subscribe: Any) {
		eventBus.register(subscribe)
	}

	fun unregister(subscribe: Any) {
		eventBus.unregister(subscribe)
	}

	fun isRegister(subscribe: Any) {
		eventBus.isRegistered(subscribe)
	}
}