package com.fxc.pics.common.base;

import android.content.Intent;

import com.fxc.pics.common.BaseContract;

import org.jetbrains.annotations.Nullable;

/**
 * @author fxc
 * @date 2018/1/10
 */

public abstract class BasePresenter<View extends BaseContract.View> implements BaseContract.Presenter {

	private View mView;

	public BasePresenter(View view) {
		setView(view);
	}

	@SuppressWarnings("unchecked")
	protected void setView(View view) {
		this.mView = view;
		mView.setPresenter(this);
	}

	public View getView() {
		return mView;
	}


	@Override
	public void onCreate() {

	}

	@Override
	public void onStart() {

	}

	@Override
	public void onNewIntent(@Nullable Intent intent) {

	}

	@Override
	public void onResume() {

	}

	@Override
	public void onPause() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void onDestroy() {

	}
}
