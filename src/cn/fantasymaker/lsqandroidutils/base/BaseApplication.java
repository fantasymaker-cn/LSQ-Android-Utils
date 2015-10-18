package cn.fantasymaker.lsqandroidutils.base;

import java.util.Stack;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;

/**
 * Application template. Init some global vars.<br>
 * <b>* Must config this class name instead of default application of AndroidManifest.xml</b><br>
 * eg:<br>
 * android:name="yourpackagename.BaseApplication"
 * @author Li Shaoqing
 */
public class BaseApplication extends Application {
	//save running activities
	private static Stack<Activity> activityStack;

	/*
	 * declare global var
	 */
	//global context
	private static Context context;
	//global main thread handler
	private static Handler mainHandler;
	//global sub thread handler
	private static Handler subHandler;
	
	/*
	 * Application's onCreate is app's first enterance
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		//init utils setting
		initUtils();
		//init global vars
		initGlobalVars();
	}

	/**
	 * init personal utils if there are
	 */
	private void initUtils() {
		//put your utils initializations here
		
	}

	/**
	 * init global var
	 */
	private void initGlobalVars() {
		context = this;
		mainHandler = new Handler();
		new Thread(){
			public void run() {
				//must have a looper when creating sub thread handler
				Looper.prepare();
				//start looping
				Looper.loop(); 
				//create 
				subHandler = new Handler();
			};
		}.start();
	}
	
	/**
	 * get Context
	 * @return
	 */
	public static Context getContext() {
		return context;
	}

	/**
	 * get main thread handler
	 * @return
	 */
	public static Handler getMainHandler() {
		return mainHandler;
	}
	
	/**
	 * get sub thread handler
	 */
	public static Handler getSubHandler(){
		return subHandler;
	}
	
	
	/**
	 * add activity to stack
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		if(activityStack == null){
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}
	
	/**
	 * get current activity
	 * @return
	 */
	public static Activity getCurrentActivity(){
		return activityStack.lastElement();
	}
	
	/**
	 * finish current activity
	 */
	public static void finishCurrentActivity(){
		finishActivity(getCurrentActivity());
	}
	
	/**
	 * finish a specified activity
	 * @param activity
	 */
	public static void finishActivity(Activity activity){
		if(activity != null){
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}
	
	/**
	 * finish a specified activity
	 * @param <T>
	 * @param activity
	 */
	public static <T> void finishActivity(Class<T> clazz){
		for(Activity activity : activityStack){
			if(activity.getClass().equals(clazz)){
				finishActivity(activity);
			}
		}
	}
	
	/**
	 * finish all activitis
	 */
	public static void finishAllActivity(){
		for(Activity activity : activityStack){
			if(activity != null){
				finishActivity(activity);
			}
		}
	}
	
	/**
	 * Exit app in a clean way. Including finish all activity, kill self process, exit jvm.<br>
	 * <b>NOTE:</b> You must call addActivity(Activity activity) in every Activity's onCreate() methods in order to make this works
	 */
	public static void exitApp(){
		finishAllActivity();
		Process.killProcess(Process.myPid());
		System.exit(0);
	}
}
