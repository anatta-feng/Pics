package com.fxc.pics.common.check;

/**
 * @author fxc
 * @date 2018/3/3
 */

public class CheckCell {
	private boolean isReady;

	public synchronized boolean isReady() {
		if (!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return isReady;
	}

	public synchronized void setReady(boolean isReady) {
		if (isReady) {
			notifyAll();
		}
		this.isReady = isReady;
	}
}
