package com.fxc.pics.pic.network.url

/**
 * @author fxc
 * @date 2018/1/13
 */

internal const val HOST = "http://api.unsplash.com"
/**
 * 随机照片
 */
internal const val PATH_RANDOM_PHOTO = "/photos/random?client_id=$APPLICATION_ID"
/**
 * 照片数据
 */
internal const val PATH_GET_PHOTO_STATISTICS = "/photos/{id}/statistics"
/**
 * 一列精选照片
 */
internal const val PATH_LIST_CURATED_PHOTO = "/photos/curated?client_id=$APPLICATION_ID"
//POST
/**
 * 喜欢某张照片
 */
internal const val PATH_LIKE_A_PHOTO = "/photos/:id/like"