package com.fxc.pics.pic.network.entities

/**
 * @author fxc
 * @date 2018/1/13
 */

class RandomPicEntity {

	/**
	 * id : UvgzVZimyWU
	 * created_at : 2015-08-05T21:23:29-04:00
	 * updated_at : 2017-10-29T18:13:09-04:00
	 * width : 3091
	 * height : 2048
	 * color : #81827B
	 * description : null
	 * urls : {"raw":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b","full":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=42978c556878f71d60325c31ba073346","regular":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=9bd2e774a4027255d9586118d00de45d","small":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=1986722851cc0c4a58255bacbcfa6376","thumb":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=67e86743c8a1492c0485e86f34365b45","custom":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&h=1920&fit=crop&s=e315959f32f31e24b9309ff364539d75"}
	 * categories : []
	 * links : {"self":"https://api.unsplash.com/photos/UvgzVZimyWU","html":"https://unsplash.com/photos/UvgzVZimyWU","download":"https://unsplash.com/photos/UvgzVZimyWU/download","download_location":"https://api.unsplash.com/photos/UvgzVZimyWU/download"}
	 * liked_by_user : false
	 * likes : 132
	 * user : {"id":"Ja-XQ6jb1fo","updated_at":"2017-12-27T06:06:05-05:00","username":"kwncy","name":"Quincy Alivio","first_name":"Quincy","last_name":"Alivio","twitter_username":"kwncy","portfolio_url":"http://work.kwncy.com/","bio":"I am a graphic designer from the Philippines who loves to travel and take pictures in film.","location":"Cebu, Philippines","links":{"self":"https://api.unsplash.com/users/kwncy","html":"https://unsplash.com/@kwncy","photos":"https://api.unsplash.com/users/kwncy/photos","likes":"https://api.unsplash.com/users/kwncy/likes","portfolio":"https://api.unsplash.com/users/kwncy/portfolio","following":"https://api.unsplash.com/users/kwncy/following","followers":"https://api.unsplash.com/users/kwncy/followers"},"profile_image":{"small":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc","medium":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358","large":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d"},"total_likes":0,"total_photos":9,"total_collections":0}
	 * current_user_collections : []
	 * slug : null
	 * location : {"title":"Lambug","name":"Lambug","city":null,"country":null,"position":{"latitude":9.853208,"longitude":123.368611}}
	 * exif : {"make":"Pentax","model":"Pentax Super A","exposure_time":null,"aperture":null,"focal_length":null,"iso":null}
	 * views : 1126040
	 * downloads : 7841
	 */

	var id: String? = null
	var created_at: String? = null
	var updated_at: String? = null
	var width: Int = 0
	var height: Int = 0
	var color: String? = null
	var description: Any? = null
	var urls: UrlsBean? = null
	var links: LinksBean? = null
	var isLiked_by_user: Boolean = false
	var likes: Int = 0
	var user: UserBean? = null
	var slug: Any? = null
	var location: LocationBean? = null
	var exif: ExifBean? = null
	var views: Int = 0
	var downloads: Int = 0
	var categories: List<*>? = null
	var current_user_collections: List<*>? = null

	class UrlsBean {
		/**
		 * raw : https://images.unsplash.com/photo-1438824086897-500332bf6e9b
		 * full : https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=42978c556878f71d60325c31ba073346
		 * regular : https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=9bd2e774a4027255d9586118d00de45d
		 * small : https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=1986722851cc0c4a58255bacbcfa6376
		 * thumb : https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=67e86743c8a1492c0485e86f34365b45
		 * custom : https://images.unsplash.com/photo-1438824086897-500332bf6e9b?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&h=1920&fit=crop&s=e315959f32f31e24b9309ff364539d75
		 */

		var raw: String? = null
		var full: String? = null
		var regular: String? = null
		var small: String? = null
		var thumb: String? = null
		var custom: String? = null
	}

	class LinksBean {
		/**
		 * self : https://api.unsplash.com/photos/UvgzVZimyWU
		 * html : https://unsplash.com/photos/UvgzVZimyWU
		 * download : https://unsplash.com/photos/UvgzVZimyWU/download
		 * download_location : https://api.unsplash.com/photos/UvgzVZimyWU/download
		 */

		var self: String? = null
		var html: String? = null
		var download: String? = null
		var download_location: String? = null
	}

	class UserBean {
		/**
		 * id : Ja-XQ6jb1fo
		 * updated_at : 2017-12-27T06:06:05-05:00
		 * username : kwncy
		 * name : Quincy Alivio
		 * first_name : Quincy
		 * last_name : Alivio
		 * twitter_username : kwncy
		 * portfolio_url : http://work.kwncy.com/
		 * bio : I am a graphic designer from the Philippines who loves to travel and take pictures in film.
		 * location : Cebu, Philippines
		 * links : {"self":"https://api.unsplash.com/users/kwncy","html":"https://unsplash.com/@kwncy","photos":"https://api.unsplash.com/users/kwncy/photos","likes":"https://api.unsplash.com/users/kwncy/likes","portfolio":"https://api.unsplash.com/users/kwncy/portfolio","following":"https://api.unsplash.com/users/kwncy/following","followers":"https://api.unsplash.com/users/kwncy/followers"}
		 * profile_image : {"small":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc","medium":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358","large":"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d"}
		 * total_likes : 0
		 * total_photos : 9
		 * total_collections : 0
		 */

		var id: String? = null
		var updated_at: String? = null
		var username: String? = null
		var name: String? = null
		var first_name: String? = null
		var last_name: String? = null
		var twitter_username: String? = null
		var portfolio_url: String? = null
		var bio: String? = null
		var location: String? = null
		var links: LinksBeanX? = null
		var profile_image: ProfileImageBean? = null
		var total_likes: Int = 0
		var total_photos: Int = 0
		var total_collections: Int = 0

		class LinksBeanX {
			/**
			 * self : https://api.unsplash.com/users/kwncy
			 * html : https://unsplash.com/@kwncy
			 * photos : https://api.unsplash.com/users/kwncy/photos
			 * likes : https://api.unsplash.com/users/kwncy/likes
			 * portfolio : https://api.unsplash.com/users/kwncy/portfolio
			 * following : https://api.unsplash.com/users/kwncy/following
			 * followers : https://api.unsplash.com/users/kwncy/followers
			 */

			var self: String? = null
			var html: String? = null
			var photos: String? = null
			var likes: String? = null
			var portfolio: String? = null
			var following: String? = null
			var followers: String? = null
		}

		class ProfileImageBean {
			/**
			 * small : https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc
			 * medium : https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358
			 * large : https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d
			 */

			var small: String? = null
			var medium: String? = null
			var large: String? = null
		}
	}

	class LocationBean {
		/**
		 * title : Lambug
		 * name : Lambug
		 * city : null
		 * country : null
		 * position : {"latitude":9.853208,"longitude":123.368611}
		 */

		var title: String? = null
		var name: String? = null
		var city: Any? = null
		var country: Any? = null
		var position: PositionBean? = null

		class PositionBean {
			/**
			 * latitude : 9.853208
			 * longitude : 123.368611
			 */

			var latitude: Double = 0.toDouble()
			var longitude: Double = 0.toDouble()
		}
	}

	class ExifBean {
		/**
		 * make : Pentax
		 * model : Pentax Super A
		 * exposure_time : null
		 * aperture : null
		 * focal_length : null
		 * iso : null
		 */

		var make: String? = null
		var model: String? = null
		var exposure_time: Any? = null
		var aperture: Any? = null
		var focal_length: Any? = null
		var iso: Any? = null
	}
}
