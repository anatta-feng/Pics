package com.fxc.pics.pic.picHome

import android.util.Log
import com.fxc.pics.common.base.BasePresenter
import com.fxc.pics.pic.network.DataSource
import com.fxc.pics.pic.network.entities.PicListEntity
import com.fxc.pics.pic.network.entities.RandomPicEntity
import com.fxc.pics.pic.network.getPicList
import com.fxc.pics.pic.network.getRandomPic

/**
 *
 * @author fxc
 * @date 2018/1/13
 */
class PicPresenterImp(view: PicActivity) : BasePresenter<PicActivity>(view) {
	companion object {
		const val TAG = "PicPresenterImp"
	}

	override fun onCreate() {
		super.onCreate()
		requestRandomPic()
	}

	private fun requestRandomPic() {
		Log.i(TAG, "requestRandomPic")
		getRandomPic(object : DataSource.Callback<RandomPicEntity> {
			override fun onDataLoaded(data: RandomPicEntity) {
				Log.d(TAG, "onDataLoaded $data")
				view.setTitleImage(data.urls.thumb)
			}

			override fun onDataError(error: Int) {
				Log.d(TAG, "getRandomPic error $error")
			}

		})

		getPicList(1, object : DataSource.Callback<List<PicListEntity>> {
			override fun onDataLoaded(data: List<PicListEntity>) {
				Log.d(TAG, "getPicList ${data.size}")
				view.notifyListChanged(data)
			}

			override fun onDataError(error: Int) {
				Log.w(TAG, "getPic error $error")
			}

		})

	}

}