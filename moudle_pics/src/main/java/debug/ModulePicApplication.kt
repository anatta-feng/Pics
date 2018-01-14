package debug

import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.fxc.pics.common.base.BaseApplication

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplication : BaseApplication() {
	override fun onCreate() {
		super.onCreate()
		Fresco.initialize(this)
		Log.w("qwe", "ModulePicApplication onCreate")
	}
}