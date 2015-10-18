package cn.fantasymaker.lsqandroidutils.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * Convenience util for getting app infos<br>
 * functions:<br>
 * - get version name<br>
 * - get version code
 * @author Li Shaoqing
 */
public class AppUtil {
	
	private AppUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static PackageManager pm = null;

	/**
	 * get version name of this app
	 * @param context context
	 * @return version name
	 */
	public static String getVersionName(Context context) {
		if(pm == null){
			pm = context.getPackageManager();
		}
		try {
			return pm.getPackageInfo(context.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get version code of this app
	 * @param context context
	 * @return version code
	 */
	public static int getVersionCode(Context context) {
		if(pm == null){
			pm = context.getPackageManager();
		}
		try {
			return pm.getPackageInfo(context.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
