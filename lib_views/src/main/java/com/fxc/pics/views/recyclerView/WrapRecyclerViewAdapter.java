package com.fxc.pics.views.recyclerView;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author fxc
 * @date 2018/2/23
 */

class WrapRecyclerViewAdapter extends ItemClickRecyclerViewAdapter {

	private SparseArray<View> mHeaderViews;
	private SparseArray<View> mFooterViews;

	private int BASE_ITEM_TYPE_HEADER = 100000;
	private int BASE_ITEM_TYPE_FOOTER = 100000;


	public WrapRecyclerViewAdapter(RecyclerView.Adapter adapter) {
		super(adapter);
		mHeaderViews = new SparseArray<>();
		mFooterViews = new SparseArray<>();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (isHeaderViewType(viewType)) {
			View header = mHeaderViews.get(viewType);
			return createHeaderOrFooterViewHolder(header);
		}
		if (isFooterViewType(viewType)) {
			View footer = mFooterViews.get(viewType);
			return createHeaderOrFooterViewHolder(footer);
		}
		return super.onCreateViewHolder(parent, viewType);
	}

	private RecyclerView.ViewHolder createHeaderOrFooterViewHolder(View view) {
		return new RecyclerView.ViewHolder(view) {
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (isHeaderPosition(position) || isFooterPosition(position)) {
			return;
		}
		final int index = position - mHeaderViews.size();
		super.onBindViewHolder(holder, index);
	}

	private boolean isHeaderViewType(int viewType) {
		return mHeaderViews.indexOfKey(viewType) >= 0;
	}

	private boolean isFooterViewType(int viewType) {
		return mFooterViews.indexOfKey(viewType) >= 0;
	}

	private boolean isHeaderPosition(int position) {
		return position < mHeaderViews.size();
	}

	private boolean isFooterPosition(int position) {
		return position >= (mAdapter.getItemCount() + mHeaderViews.size());
	}

	@Override
	public int getItemCount() {
		return mAdapter.getItemCount() + mHeaderViews.size() + mFooterViews.size();
	}

	public void addHeaderView(View view) {
		int position = mHeaderViews.indexOfValue(view);
		if (position < 0) {
			mHeaderViews.put(BASE_ITEM_TYPE_HEADER++, view);
		}
		notifyDataSetChanged();
	}

	public void addFooterView(View view) {
		int position = mFooterViews.indexOfValue(view);
		if (position < 0) {
			mFooterViews.put(BASE_ITEM_TYPE_FOOTER++, view);
		}
		notifyDataSetChanged();
	}

	public void removeHeaderView(View view) {
		int index = mHeaderViews.indexOfValue(view);
		if (index < 0) return;
		mHeaderViews.removeAt(index);
		notifyDataSetChanged();
	}

	public void removeFooterView(View view) {
		int index = mFooterViews.indexOfValue(view);
		if (index < 0) return;
		mFooterViews.removeAt(index);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		if (isHeaderPosition(position)) {
			return mHeaderViews.keyAt(position);
		}
		if (isFooterPosition(position)) {
			position = position - mHeaderViews.size() - mAdapter.getItemCount();
			return mFooterViews.keyAt(position);
		}
		position = position - mHeaderViews.size();
		return mAdapter.getItemViewType(position);
	}

	public void adjustSpanSize(RecyclerView view) {
		final RecyclerView.LayoutManager manager = view.getLayoutManager();
		if (manager instanceof GridLayoutManager) {
			((GridLayoutManager) manager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
				@Override
				public int getSpanSize(int position) {
					boolean isHeaderOrFooter = isHeaderPosition(position) || isFooterPosition(position);
					return isHeaderOrFooter ? ((GridLayoutManager) manager).getSpanCount() : 1;
				}
			});
		}
	}

}
