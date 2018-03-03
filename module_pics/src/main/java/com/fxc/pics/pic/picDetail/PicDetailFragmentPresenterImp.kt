package com.fxc.pics.pic.picDetail

import android.util.Log
import com.fxc.pics.common.base.BasePresenter
import com.fxc.pics.pic.network.entities.PicListEntity

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragmentPresenterImp(view: PicDetailFragment) : BasePresenter<PicDetailFragment>(view) {
	companion object {
		private const val TAG = "PicDetailFragmentP"
	}

	private var position = 0
	private lateinit var entity:PicListEntity
	override fun onCreate() {
		super.onCreate()
		Log.w(TAG, "onCreate")
		position = view.getStartParams().getInt(PicDetailFragment.KEY_SELECT_POSITION)
		entity = view.mActivity.queryPicEntity(position)
		Log.e(TAG, "position $position")
//		getPhotoDetail(id, object : DataSource.Callback<PicDetailEntity> {
//			override fun onDataLoaded(data: PicDetailEntity) {
//				view.setImageUrl(data.urls.regular)
//			}
//
//			override fun onDataError(error: Int) {
//			}
//		})
	}

	override fun onStart() {
		super.onStart()
		view.setDetailImageUrl(entity.urls.small)
	}

	override fun onPause() {
		super.onPause()
		Log.w(TAG, "onPause")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.i(TAG, "onDestroy")
	}
}