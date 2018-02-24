package com.fxc.pics.views.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * @author fxc
 * @date 2018/2/24
 */

class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	protected RecyclerView.Adapter mAdapter;

	public BaseAdapter(RecyclerView.Adapter adapter) {
		this.mAdapter = adapter;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return mAdapter.onCreateViewHolder(parent, viewType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		mAdapter.onBindViewHolder(holder, position);
	}

	@Override
	public int getItemCount() {
		return mAdapter.getItemCount();
	}
}
