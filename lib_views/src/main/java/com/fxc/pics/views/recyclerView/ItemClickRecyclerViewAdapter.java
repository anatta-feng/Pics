package com.fxc.pics.views.recyclerView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author fxc
 * @date 2018/2/23
 */

public class ItemClickRecyclerViewAdapter extends BaseAdapter {

	ItemClickRecyclerViewAdapter(RecyclerView.Adapter adapter) {
		super(adapter);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return mAdapter.onCreateViewHolder(parent, viewType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
		mAdapter.onBindViewHolder(holder, position);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(v, position);
			}
		});
		holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				return onItemLongClickListener.onItemLongClick(v, position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return mAdapter.getItemCount();
	}

	private OnItemClickListener onItemClickListener = new DefaultOnItemClickListener();
	private OnItemLongClickListener onItemLongClickListener = new DefaultOnItemLongClickListener();

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
		this.onItemLongClickListener = onItemLongClickListener;
	}

	public interface OnItemClickListener {
		void onItemClick(View item, int position);
	}

	public interface OnItemLongClickListener {
		boolean onItemLongClick(View item, int position);
	}

}
