package cn.fantasymaker.lsqandroidutils.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;

/**
 * Convenience util for get process info
 * @author Li Shaoqing
 */
public class ProcessUtil {
	
	private ProcessUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static ActivityManager am = null;
	
	/**
	 * get running processes
	 * @return list of running process
	 */
	public static List<RunningAppProcessInfo> getRunningProcesses(Context context){
		if(am == null){
			am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		}
		return am.getRunningAppProcesses();
	}
	
	/**
	 * get amount of running processes
	 * @param context context
	 * @return amount of running process
	 */
	public static int getRunningProcessAmount(Context context){
		return getRunningProcesses(context).size();
	}
}
