package com.fxc.pics.pic.picDetail

import com.fxc.pics.common.base.BasePresenter

/**
 * @author fxc
 * @date 2018/3/2
 */
class PicDetailFragmentPresenterImp(view: PicDetailFragment) : BasePresenter<PicDetailFragment>(view) {
	override fun onCreate() {
		super.onCreate()
//		getPhotoDetail(id, object : DataSource.Callback<PicDetailEntity> {
//			override fun onDataLoaded(data: PicDetailEntity) {
//				view.setImageUrl(data.urls.regular)
//			}
//
//			override fun onDataError(error: Int) {
//			}
//		})
	}
}