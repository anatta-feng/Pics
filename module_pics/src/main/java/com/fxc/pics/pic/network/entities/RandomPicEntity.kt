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
	 * description : ""
	 * urls : {"raw":"https://images.unsplash.com/photo-1438824086897-500332bf6e9b","full":"https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=42978c556878f71d60325c31ba073346","regular":"https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=9bd2e774a4027255d9586118d00de45d","small":"https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=1986722851cc0c4a58255bacbcfa6376","thumb":"https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=67e86743c8a1492c0485e86f34365b45","custom":"https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&h=1920&fit=crop&s=e315959f32f31e24b9309ff364539d75"}
	 * categories : []
	 * links : {"self":"https://api.unsplash.com/photos/UvgzVZimyWU","html":"https://unsplash.com/photos/UvgzVZimyWU","download":"https://unsplash.com/photos/UvgzVZimyWU/download","download_location":"https://api.unsplash.com/photos/UvgzVZimyWU/download"}
	 * liked_by_user : false
	 * likes : 132
	 * user : {"id":"Ja-XQ6jb1fo","updated_at":"2017-12-27T06:06:05-05:00","username":"kwncy","name":"Quincy Alivio","first_name":"Quincy","last_name":"Alivio","twitter_username":"kwncy","portfolio_url":"http://work.kwncy.com/","bio":"I am a graphic designer from the Philippines who loves to travel and take pictures in film.","location":"Cebu, Philippines","links":{"self":"https://api.unsplash.com/users/kwncy","html":"https://unsplash.com/@kwncy","photos":"https://api.unsplash.com/users/kwncy/photos","likes":"https://api.unsplash.com/users/kwncy/likes","portfolio":"https://api.unsplash.com/users/kwncy/portfolio","following":"https://api.unsplash.com/users/kwncy/following","followers":"https://api.unsplash.com/users/kwncy/followers"},"profile_image":{"small":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc","medium":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358","large":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d"},"total_likes":0,"total_photos":9,"total_collections":0}
	 * current_user_collections : []
	 * slug : ""
	 * location : {"title":"Lambug","name":"Lambug","city":"","country":"","position":{"latitude":9.853208,"longitude":123.368611}}
	 * exif : {"make":"Pentax","model":"Pentax Super A","exposure_time":"","aperture":"","focal_length":"","iso":""}
	 * views : 1126040
	 * downloads : 7841
	 */

	var id: String = ""
	var created_at: String = ""
	var updated_at: String = ""
	var width: Int = 0
	var height: Int = 0
	var color: String = ""
	var description: String = ""
	var urls: UrlsBean = UrlsBean()
	var links: LinksBean = LinksBean()
	var isLiked_by_user: Boolean = false
	var likes: Int = 0
	var user: UserBean = UserBean()
	var slug: String = ""
	var location: LocationBean = LocationBean()
	var exif: ExifBean = ExifBean()
	var views: Int = 0
	var downloads: Int = 0
	var categories: List<CategoryBean> = ArrayList()
	var current_user_collections: List<CurrentUserCollectionBean> = ArrayList()

	class UrlsBean {
		/**
		 * raw : https://images.unsplash.com/photo-1438824086897-500332bf6e9b
		 * full : https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=42978c556878f71d60325c31ba073346
		 * regular : https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=9bd2e774a4027255d9586118d00de45d
		 * small : https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=1986722851cc0c4a58255bacbcfa6376
		 * thumb : https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=67e86743c8a1492c0485e86f34365b45
		 * custom : https://images.unsplash.com/photo-1438824086897-500332bf6e9bixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&h=1920&fit=crop&s=e315959f32f31e24b9309ff364539d75
		 */

		var raw: String = ""
		var full: String = ""
		var regular: String = ""
		var small: String = ""
		var thumb: String = ""
		var custom: String = ""
	}

	class LinksBean {
		/**
		 * self : https://api.unsplash.com/photos/UvgzVZimyWU
		 * html : https://unsplash.com/photos/UvgzVZimyWU
		 * download : https://unsplash.com/photos/UvgzVZimyWU/download
		 * download_location : https://api.unsplash.com/photos/UvgzVZimyWU/download
		 */

		var self: String = ""
		var html: String = ""
		var download: String = ""
		var download_location: String = ""
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
		 * profile_image : {"small":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc","medium":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358","large":"https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d"}
		 * total_likes : 0
		 * total_photos : 9
		 * total_collections : 0
		 */

		var id: String = ""
		var updated_at: String = ""
		var username: String = ""
		var name: String = ""
		var first_name: String = ""
		var last_name: String = ""
		var twitter_username: String = ""
		var portfolio_url: String = ""
		var bio: String = ""
		var location: String = ""
		var links: LinksBeanX = LinksBeanX()
		var profile_image: ProfileImageBean = ProfileImageBean()
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

			var self: String = ""
			var html: String = ""
			var photos: String = ""
			var likes: String = ""
			var portfolio: String = ""
			var following: String = ""
			var followers: String = ""
		}

		class ProfileImageBean {
			/**
			 * small : https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc
			 * medium : https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358
			 * large : https://images.unsplash.com/placeholder-avatars/extra-large.jpgixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d
			 */

			var small: String = ""
			var medium: String = ""
			var large: String = ""
		}
	}

	class LocationBean {
		/**
		 * title : Lambug
		 * name : Lambug
		 * city : ""
		 * country : ""
		 * position : {"latitude":9.853208,"longitude":123.368611}
		 */

		var title: String = ""
		var name: String = ""
		var city: Any = ""
		var country: Any = ""
		var position: PositionBean = PositionBean()

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
		 * exposure_time : ""
		 * aperture : ""
		 * focal_length : ""
		 * iso : ""
		 */

		var make: String = ""
		var model: String = ""
		var exposure_time: Any = ""
		var aperture: Any = ""
		var focal_length: Any = ""
		var iso: Any = ""
	}

	class CategoryBean {

		/**
		 * id : 6
		 * title : People
		 * photo_count : 9844
		 * links : {"self":"https://api.unsplash.com/categories/6","photos":"https://api.unsplash.com/categories/6/photos"}
		 */

		var id: Int = 0
		var title: String = ""
		var photo_count: Int = 0
		var links: LinksBean = LinksBean()

		class LinksBean {
			/**
			 * self : https://api.unsplash.com/categories/6
			 * photos : https://api.unsplash.com/categories/6/photos
			 */

			var self: String = ""
			var photos: String = ""
		}
	}

	class CurrentUserCollectionBean {

		var id: Int = 0
		var title: String = ""
		var published_at: String = ""
		var updated_at: String = ""
		var isCurated: Boolean = false
		var cover_photo: CoverPhotoBean = CoverPhotoBean()
		var user: UserBeanX = UserBeanX()
		var links: LinksBeanXXXX = LinksBeanXXXX()

		class CoverPhotoBean {
			/**
			 * id : xCmvrpzctaQ
			 * width : 7360
			 * height : 4912
			 * color : #040C14
			 * likes : 12
			 * liked_by_user : false
			 * description : A man drinking a coffee.
			 * user : {"id":"eUO1o53muso","username":"crew","name":"James Example","first_name":"James","last_name":"Example","twitter_username":"crew","portfolio_url":"https://crew.co/","bio":"Work with the best designers and developers without breaking the bank.","location":"Montreal","total_likes":0,"total_photos":74,"total_collections":52,"profile_image":{"small":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32","medium":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64","large":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128"},"links":{"self":"https://api.unsplash.com/users/crew","html":"http://unsplash.com/crew","photos":"https://api.unsplash.com/users/crew/photos","likes":"https://api.unsplash.com/users/crew/likes","portfolio":"https://api.unsplash.com/users/crew/portfolio"}}
			 * urls : {"raw":"https://images.unsplash.com/photo-1452457807411-4979b707c5be","full":"https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy","regular":"https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max","small":"https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=400&fit=max","thumb":"https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=200&fit=max"}
			 * categories : [{"id":6,"title":"People","photo_count":9844,"links":{"self":"https://api.unsplash.com/categories/6","photos":"https://api.unsplash.com/categories/6/photos"}}]
			 * links : {"self":"https://api.unsplash.com/photos/xCmvrpzctaQ","html":"https://unsplash.com/photos/xCmvrpzctaQ","download":"https://unsplash.com/photos/xCmvrpzctaQ/download","download_location":"https://api.unsplash.com/photos/xCmvrpzctaQ/download"}
			 */

			var id: String = ""
			var width: Int = 0
			var height: Int = 0
			var color: String = ""
			var likes: Int = 0
			var isLiked_by_user: Boolean = false
			var description: String = ""
			var user: UserBean = UserBean()
			var urls: UrlsBean = UrlsBean()
			var links: LinksBeanX = LinksBeanX()
			var categories: List<CategoriesBean> = ArrayList()

			class UserBean {
				/**
				 * id : eUO1o53muso
				 * username : crew
				 * name : James Example
				 * first_name : James
				 * last_name : Example
				 * twitter_username : crew
				 * portfolio_url : https://crew.co/
				 * bio : Work with the best designers and developers without breaking the bank.
				 * location : Montreal
				 * total_likes : 0
				 * total_photos : 74
				 * total_collections : 52
				 * profile_image : {"small":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32","medium":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64","large":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128"}
				 * links : {"self":"https://api.unsplash.com/users/crew","html":"http://unsplash.com/crew","photos":"https://api.unsplash.com/users/crew/photos","likes":"https://api.unsplash.com/users/crew/likes","portfolio":"https://api.unsplash.com/users/crew/portfolio"}
				 */

				var id: String = ""
				var username: String = ""
				var name: String = ""
				var first_name: String = ""
				var last_name: String = ""
				var twitter_username: String = ""
				var portfolio_url: String = ""
				var bio: String = ""
				var location: String = ""
				var total_likes: Int = 0
				var total_photos: Int = 0
				var total_collections: Int = 0
				var profile_image: ProfileImageBean = ProfileImageBean()
				var links: LinksBean = LinksBean()

				class ProfileImageBean {
					/**
					 * small : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32
					 * medium : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64
					 * large : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128
					 */

					var small: String = ""
					var medium: String = ""
					var large: String = ""
				}

				class LinksBean {
					/**
					 * self : https://api.unsplash.com/users/crew
					 * html : http://unsplash.com/crew
					 * photos : https://api.unsplash.com/users/crew/photos
					 * likes : https://api.unsplash.com/users/crew/likes
					 * portfolio : https://api.unsplash.com/users/crew/portfolio
					 */

					var self: String = ""
					var html: String = ""
					var photos: String = ""
					var likes: String = ""
					var portfolio: String = ""
				}
			}

			class UrlsBean {
				/**
				 * raw : https://images.unsplash.com/photo-1452457807411-4979b707c5be
				 * full : https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy
				 * regular : https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max
				 * small : https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=400&fit=max
				 * thumb : https://images.unsplash.com/photo-1452457807411-4979b707c5beixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=200&fit=max
				 */

				var raw: String = ""
				var full: String = ""
				var regular: String = ""
				var small: String = ""
				var thumb: String = ""
			}

			class LinksBeanX {
				/**
				 * self : https://api.unsplash.com/photos/xCmvrpzctaQ
				 * html : https://unsplash.com/photos/xCmvrpzctaQ
				 * download : https://unsplash.com/photos/xCmvrpzctaQ/download
				 * download_location : https://api.unsplash.com/photos/xCmvrpzctaQ/download
				 */

				var self: String = ""
				var html: String = ""
				var download: String = ""
				var download_location: String = ""
			}

			class CategoriesBean {
				/**
				 * id : 6
				 * title : People
				 * photo_count : 9844
				 * links : {"self":"https://api.unsplash.com/categories/6","photos":"https://api.unsplash.com/categories/6/photos"}
				 */

				var id: Int = 0
				var title: String = ""
				var photo_count: Int = 0
				var links: LinksBeanXX = LinksBeanXX()

				class LinksBeanXX {
					/**
					 * self : https://api.unsplash.com/categories/6
					 * photos : https://api.unsplash.com/categories/6/photos
					 */

					var self: String = ""
					var photos: String = ""
				}
			}
		}

		class UserBeanX {
			/**
			 * id : eUO1o53muso
			 * updated_at : 2016-07-10T11:00:01-05:00
			 * username : crew
			 * name : Crew
			 * portfolio_url : https://crew.co/
			 * bio : Work with the best designers and developers without breaking the bank.
			 * location : Montreal
			 * total_likes : 0
			 * total_photos : 74
			 * total_collections : 52
			 * profile_image : {"small":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32","medium":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64","large":"https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128"}
			 * links : {"self":"https://api.unsplash.com/users/crew","html":"https://unsplash.com/crew","photos":"https://api.unsplash.com/users/crew/photos","likes":"https://api.unsplash.com/users/crew/likes","portfolio":"https://api.unsplash.com/users/crew/portfolio"}
			 */

			var id: String = ""
			var updated_at: String = ""
			var username: String = ""
			var name: String = ""
			var portfolio_url: String = ""
			var bio: String = ""
			var location: String = ""
			var total_likes: Int = 0
			var total_photos: Int = 0
			var total_collections: Int = 0
			var profile_image: ProfileImageBeanX = ProfileImageBeanX()
			var links: LinksBeanXXX = LinksBeanXXX()

			class ProfileImageBeanX {
				/**
				 * small : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32
				 * medium : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64
				 * large : https://images.unsplash.com/profile-1441298102341-b7ba36fdc35cixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128
				 */

				var small: String = ""
				var medium: String = ""
				var large: String = ""
			}

			class LinksBeanXXX {
				/**
				 * self : https://api.unsplash.com/users/crew
				 * html : https://unsplash.com/crew
				 * photos : https://api.unsplash.com/users/crew/photos
				 * likes : https://api.unsplash.com/users/crew/likes
				 * portfolio : https://api.unsplash.com/users/crew/portfolio
				 */

				var self: String = ""
				var html: String = ""
				var photos: String = ""
				var likes: String = ""
				var portfolio: String = ""
			}
		}

		class LinksBeanXXXX {
			/**
			 * self : https://api.unsplash.com/collections/206
			 * html : https://unsplash.com/collections/206
			 * photos : https://api.unsplash.com/collections/206/photos
			 */

			var self: String = ""
			var html: String = ""
			var photos: String = ""
		}
	}

}
