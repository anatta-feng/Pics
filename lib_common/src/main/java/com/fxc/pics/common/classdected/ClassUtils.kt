@file:Suppress("UNCHECKED_CAST")

package com.fxc.pics.common.classdected

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import dalvik.system.DexFile
import java.io.File
import java.io.IOException
import java.util.regex.Pattern

/**
 *
 * @author fxc
 * @date 2018/1/8
 */
private const val TAG = "ClassUtil"
private const val PREFS_FILE = "multidex.version"
private const val KEY_DEX_NUMBER = "dex.number"
private val SECONDARY_FOLDER_NAME = "code_cache${File.separator}secondary-dexes"
private const val EXTRACTED_NAME_EXT = ".classes"
private const val EXTRACTED_SUFFIX = ".zip"
private const val VM_WITH_MULTI_DEX_VERSION_MAJOR = 2
private const val VM_WITH_MULTI_DEX_VERSION_MINOR = 1

internal fun <T, K> getAppAndBaseDelegates(ctx: Context, application: Class<T>, baseActivity: Class<K>, path: String): DelegateBean<T, K> {
	if (!application.isInterface || !baseActivity.isInterface) {
		Log.w(TAG, "the class is not a interface")
	}
	val delegates = DelegateBean<T, K>()
	try {
		val classFileNames = getFileNameByPackageName(ctx, path)
		for (classFile in classFileNames) {
			val target = Class.forName(classFile)
			Log.d(TAG, "getClass " + target)
			if (!target.isInterface && application.isAssignableFrom(target)) {
				delegates.applications.add(target.getConstructor().newInstance() as T)
			} else if (!target.isInterface && baseActivity.isAssignableFrom(target)) {
				delegates.activities.add(target.getConstructor().newInstance() as K)
			}
		}
		if (delegates.activities.size == 0) {
			Log.e(TAG, "No activity files were found, check your configuration please!")
		}
		if (delegates.applications.size == 0) {
			Log.e(TAG, "No application files were found, check your configuration please!")
		}
	} catch (e: Exception) {
		e.stackTrace
		Log.e(TAG, "getObjectsWithInterface error. ${e.message}")
	}
	return delegates
}

fun <T> getObjectsWithInterface(ctx: Context, clazz: Class<T>, paths: List<String>): List<T> {
	val objectList = ArrayList<T>()
	for (path in paths) {
		objectList.addAll(getObjectsWithInterface(ctx, clazz, path))
	}
	return objectList
}

fun <T> getObjectsWithInterface(ctx: Context, clazz: Class<T>, path: String): List<T> {
	if (!clazz.isInterface) {
		Log.w(TAG, "the class is not a interface")
	}
	val objectList = ArrayList<T>()
	try {
		val classFileNames = getFileNameByPackageName(ctx, path)
		for (classFile in classFileNames) {
			val target = Class.forName(classFile)
			if (!target.isInterface && clazz.isAssignableFrom(target)) {
				objectList.add(target.getConstructor().newInstance() as T)
			}
		}
		if (objectList.size == 0) {
			Log.e(TAG, "No files were found, check your configuration please!")
		}
	} catch (e: Exception) {
		e.stackTrace
		Log.e(TAG, "getObjectsWithInterface error. ${e.message}")
	}
	return objectList
}

private fun getFileNameByPackageName(ctx: Context, path: String): List<String> {
	val classNames = ArrayList<String>()
	val dexPaths = getSourcePaths(ctx)
	for (dexPath in dexPaths) {
		var dexFile: DexFile? = null
		try {
			dexFile = if (dexPath.endsWith(EXTRACTED_SUFFIX)) {
				DexFile.loadDex(dexPath, "$dexPath.temp", 0)
			} else {
				DexFile(dexPath)
			}
			for (className in dexFile!!.entries()) {
				if (className.contains(path)) {
					classNames.add(className)
				}
			}
		} catch (ignore: Throwable) {
			Log.e(TAG, "Scan map file in dex files made error.", ignore)
		} finally {
			try {
				dexFile?.close()
			} catch (ignore: Throwable) {
			}
		}
	}
	return classNames
}

private fun getSourcePaths(ctx: Context): List<String> {
	val applicationInfo = ctx.packageManager.getApplicationInfo(ctx.packageName, 0)
	val sourceApk = File(applicationInfo.sourceDir)
	val extractedFilePrefix = sourceApk.name + EXTRACTED_NAME_EXT
	val sourcePaths = ArrayList<String>()
	sourcePaths.add(applicationInfo.sourceDir)
	if (!isVMMultiDexCapable()) {
		val totalDexNum = getMultiDexPreferences(ctx).getInt(KEY_DEX_NUMBER, 1)
		val dexDir = File(applicationInfo.sourceDir, SECONDARY_FOLDER_NAME)
		for (secondaryNum in 2..totalDexNum) {
			val fileName = extractedFilePrefix + secondaryNum + EXTRACTED_SUFFIX
			val extractedFile = File(dexDir, fileName)
			if (extractedFile.isFile) {
				sourcePaths.add(extractedFile.absolutePath)
			} else {
				throw IOException("Missing extracted secondary dex file'${extractedFile.path}")
			}
		}
	}

	return sourcePaths
}


private fun getMultiDexPreferences(ctx: Context): SharedPreferences {
	return ctx.getSharedPreferences(PREFS_FILE, if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) Context.MODE_PRIVATE else Context.MODE_PRIVATE or Context.MODE_MULTI_PROCESS)
}

private fun isVMMultiDexCapable(): Boolean {
	var isSupport = false
	val vmName: String
	if (isYunOS()) {
		vmName = "YunOS"
		isSupport = System.getProperty("java.vm.version").toInt() >= 21
	} else {
		vmName = "Android"
		val versionString = System.getProperty("java.vm.version")
		val matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(versionString)
		if (matcher.matches()) {
			try {
				val major = Integer.parseInt(matcher.group(1))
				val minor = Integer.parseInt(matcher.group(2))
				isSupport = major >= VM_WITH_MULTI_DEX_VERSION_MAJOR && minor >= VM_WITH_MULTI_DEX_VERSION_MINOR
			} catch (ignore: NumberFormatException) {
				// let isMultidexCapable be false
			}

		}
	}
	Log.i(TAG, "VM with name $vmName${if (isSupport) " has multiDex support" else " does not have multidex support"}")
	return isSupport
}

private fun isYunOS(): Boolean {
	val version = System.getProperty("ro.yunos.version")
	val vmName = System.getProperty("java.vm.name")
	return vmName != null && vmName.toLowerCase().contains("lemur") || version != null && version.trim().isNotEmpty()

}


