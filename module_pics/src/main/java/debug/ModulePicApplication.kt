package debug

import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.listener.RequestLoggingListener
import com.fxc.pics.common.base.BaseApplication
import com.fxc.pics.pic.BuildConfig

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplication : BaseApplication() {
	override fun onCreate() {
		super.onCreate()
		if (BuildConfig.DEBUG) {
			val requestListeners = HashSet<RequestListener>()
			requestListeners.add(RequestLoggingListener())
			val config = ImagePipelineConfig.newBuilder(this)
					.setRequestListeners(requestListeners)
					.build()
			Fresco.initialize(this, config)
		} else {
			Fresco.initialize(this)
		}
	}
}