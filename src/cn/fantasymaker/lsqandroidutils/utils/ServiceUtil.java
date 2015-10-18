package cn.fantasymaker.lsqandroidutils.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;

/**
 * Convenience util for service operation
 * @author Li Shaoqing
 */
public class ServiceUtil {
	
	private ServiceUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static ActivityManager am = null;

	/**
	 * whether the given service is running
	 * @param context context
	 * @param clazz service class to be checked
	 * @return true if the service is running; otherwise false
	 */
	public static boolean isRungingService(Context context, Class<? extends Service> clazz) {
		if(am == null){
			am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		}
		List<RunningServiceInfo> list = am.getRunningServices(Integer.MAX_VALUE);
		for (RunningServiceInfo info : list) {
			ComponentName service = info.service;
			String className = service.getClassName();
			if (className.equals(clazz.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * get names of all running service
	 * @param context context
	 * @return a list of running services' names
	 */
	public static List<String> getAllRunningServiceName(Context context){
		if(am == null){
			am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		}
		List<String> runningServices = new ArrayList<String>();
		List<RunningServiceInfo> list = am.getRunningServices(Integer.MAX_VALUE);
		for (RunningServiceInfo info : list) {
			ComponentName service = info.service;
			String className = service.getClassName();
			runningServices.add(className);
		}
		return runningServices;
	}
}
