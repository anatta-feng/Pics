package com.fxc.pics.pic.network.url

/**
 * @author fxc
 * @date 2018/1/13
 */

internal const val U_API_HOST = "https://api.unsplash.com"
internal const val U_RELATED_HOST = "https://unsplash.com"
/**
 * 随机照片
 */
internal const val PATH_RANDOM_PHOTO = "/photos/random"
/**
 * 照片数据
 */
internal const val PATH_GET_PHOTO_STATISTICS = "/photos/{id}/statistics"
/**
 * 一列精选照片
 */
internal const val PATH_LIST_CURATED_PHOTO = "/photos/curated"

/**
 * 获取指定照片的详情
 */
internal const val PATH_GET_PHOTO = "/photos/{id}"
//POST
/**
 * 喜欢某张照片
 */
internal const val PATH_LIKE_A_PHOTO = "/photos/:id/like"

/**
 * 指定照片的相似照片
 */
internal const val PATH_PHOTO_RELATED = "/napi/photos/{id}/related"