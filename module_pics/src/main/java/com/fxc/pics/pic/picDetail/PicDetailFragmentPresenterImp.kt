package com.fxc.pics.pic.picDetail

import android.util.Log
import com.fxc.pics.common.base.BasePresenter
import com.fxc.pics.pic.network.DataSource
import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.getPhotoDetail

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
		position = view.getStartParams().getInt(PicDetailFragment.KEY_SELECT_POSITION)
		entity = view.mActivity.queryPicEntity(position)
		getPhotoDetail(entity.id)

	}

	private fun getPhotoDetail(id: String) {
		getPhotoDetail(id, object : DataSource.Callback<PicDetailEntity> {
			override fun onDataLoaded(data: PicDetailEntity) {
				view.setPhotoDetail(data)
			}

			override fun onDataError(error: Int) {
			}
		})
	}

	override fun onStart() {
		super.onStart()
		view.setDetailImageUrl(entity.urls.small)
		view.setAuthorInfo(entity.user)
	}
}