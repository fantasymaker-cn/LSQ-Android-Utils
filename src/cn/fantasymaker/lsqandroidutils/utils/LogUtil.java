package cn.fantasymaker.lsqandroidutils.utils;

import android.util.Log;

/**
 * Convenience log util. Control showing log with a simple setting
 * @author Li Shaoqing
 */
public class LogUtil {
	
	private LogUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}

	/**
	 * controller of log showing
	 */
	public static boolean showLog = false;
	
	/**
	 * print a VERBOSE log
	 * @param tag tag
	 * @param msg Message to be shown
	 */
	public static void v(String tag, String msg){
		if(showLog && (msg != null)){
			Log.v(tag, msg);
		}
	}
	
	/**
	 * print a DEBUG log
	 * @param tag tag
	 * @param msg Message to be shown
	 */
	public static void d(String tag, String msg){
		if(showLog && (msg != null)){
			Log.d(tag, msg);
		}
	}
	
	/**
	 * print an INFO log
	 * @param tag tag
	 * @param msg Message to be shown
	 */
	public static void i(String tag, String msg){
		if(showLog && (msg != null)){
			Log.i(tag, msg);
		}
	}
	
	/**
	 * print a WARN log
	 * @param tag tag
	 * @param msg Message to be shown
	 */
	public static void w(String tag, String msg){
		if(showLog && (msg != null)){
			Log.w(tag, msg);
		}
	}
	
	/**
	 * print an ERROR log
	 * @param tag tag
	 * @param msg Message to be shown
	 */
	public static void e(String tag, String msg){
		if(showLog && (msg != null)){
			Log.e(tag, msg);
		}
	}
	
	/**
	 * print a VERBOSE log
	 * @param obj Object that use its class name to be as a tag
	 * @param msg Message to be shown
	 */
	public static void v(Object obj, String msg){
		if(showLog && (msg != null)){
			Log.v(obj.getClass().getSimpleName(), msg);
		}
	}
	
	/**
	 * print a DEBUG log
	 * @param obj Object that use its class name to be as a tag
	 * @param msg Message to be shown
	 */
	public static void d(Object obj, String msg){
		if(showLog && (msg != null)){
			Log.d(obj.getClass().getSimpleName(), msg);
		}
	}
	
	/**
	 * print an INFO log
	 * @param obj Object that use its class name to be as a tag
	 * @param msg Message to be shown
	 */
	public static void i(Object obj, String msg){
		if(showLog && (msg != null)){
			Log.i(obj.getClass().getSimpleName(), msg);
		}
	}
	
	/**
	 * print a WARN log
	 * @param obj Object that use its class name to be as a tag
	 * @param msg Message to be shown
	 */
	public static void w(Object obj, String msg){
		if(showLog && (msg != null)){
			Log.w(obj.getClass().getSimpleName(), msg);
		}
	}
	
	/**
	 * print an ERROR log
	 * @param obj Object that use its class name to be as a tag
	 * @param msg Message to be shown
	 */
	public static void e(Object obj, String msg){
		if(showLog && (msg != null)){
			Log.e(obj.getClass().getSimpleName(), msg);
		}
	}
}
