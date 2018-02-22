package debug

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 *
 * @author fxc
 * @date 2018/1/14
 */
class ModulePicApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		Fresco.initialize(this)

	}
}