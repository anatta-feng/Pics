package com.fxc.pics.pic.picDetail

import android.util.Log
import android.widget.Toast
import com.fxc.pics.common.base.BasePresenter
import com.fxc.pics.pic.network.DataSource
import com.fxc.pics.pic.network.NetworkObserver
import com.fxc.pics.pic.network.entities.PicDetailEntity
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.PicRelatedEntity
import com.fxc.pics.pic.network.getPhotoDetail
import com.fxc.pics.pic.network.getRelatedPhotos

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
		getRelatedImage(entity.id)

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

	private fun getRelatedImage(id: String) {
		getRelatedPhotos(id).subscribe(object : NetworkObserver<PicRelatedEntity>() {
			override fun onNext(t: PicRelatedEntity) {
				view.setRelatedPicData(t.results)
			}

			override fun onError(e: Throwable) {
				super.onError(e)
				Toast.makeText(view.context, "OnError ${e.cause}", Toast.LENGTH_SHORT).show()
			}
		})

	}

	override fun onStart() {
		super.onStart()
		view.setDetailImageUrl(entity.urls.small)
		view.setAuthorInfo(entity.user)
		view.setDetailImageUrl(entity.urls.regular)
	}
}