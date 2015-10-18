package cn.fantasymaker.lsqandroidutils.utils;

import android.annotation.SuppressLint;
import android.os.Handler;

/**
 * Simple Async task util
 * @author Li Shaoqing
 */
public abstract class SimpleAsyncTaskUtil {
	
	//handle message to do 
	@SuppressLint("HandlerLeak") 
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			afterThreadTask();
		};
	};
	
	/**
	 * task to be done before child thread
	 */
	public abstract void preThreadTask();
	
	/**
	 * task to be done in child thread
	 */
	public abstract void inThreadTask();
	
	/**
	 * task to be done after child thread
	 */
	public abstract void afterThreadTask();
	
	/**
	 * execute tasks in sequence
	 */
	public void execute(){
		preThreadTask();
		new Thread(){
			public void run() {
				inThreadTask();
				handler.sendEmptyMessage(0);
			};
		}.start();
	}
	
}
