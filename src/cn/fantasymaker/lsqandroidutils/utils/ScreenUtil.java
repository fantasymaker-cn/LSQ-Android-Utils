package cn.fantasymaker.lsqandroidutils.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class ScreenUtil {

	private ScreenUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static WindowManager wm = null;
	private static DisplayMetrics outMetrics;
	
	/**
	 * Get screen width in pixel
	 * @param context Context object
	 * @return screen width in pixel
	 */
	public static int getScreenWidth(Context context){
		if(wm == null){
			wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		}
		if(outMetrics == null){
			outMetrics = new DisplayMetrics();
		}
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}
	
	/**
	 * Get screen height in pixel
	 * @param context Context object
	 * @return screen height in pixel
	 */
	public static int getScreenHeight(Context context){
		if(wm == null){
			wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		}
		if(outMetrics == null){
			outMetrics = new DisplayMetrics();
		}
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}
	
	/** 
	 * Get height of status bar
	 * @param v 
	 * @return
	 */
	public static int getStatusBarHeight(View v) {
		if (v == null) {
			return 0;
		}
		Rect frame = new Rect();
		v.getWindowVisibleDisplayFrame(frame);
		return frame.top;
	}
}
