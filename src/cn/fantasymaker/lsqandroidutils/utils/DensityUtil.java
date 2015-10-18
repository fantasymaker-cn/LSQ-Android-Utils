package cn.fantasymaker.lsqandroidutils.utils;

import android.content.Context;

/**
 * Convenience util for converting density related
 * @author Li Shaoqing
 */
public class DensityUtil {
	
	private DensityUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}

	/**
	 * Convert from Dip to Px as per phone screen
	 * @param context Context object
	 * @param dpValue the Dip value to be converted from
	 * @return a Px value
	 */
	public static int dpToPx(Context context, float dpValue) {  
		// Get Screen density as scale
		final float scale = context.getResources().getDisplayMetrics().density;
		// +0.5f: used to 4 she 5 ru
	    return (int) (dpValue * scale + 0.5f); 
	}  
	
	/**
	 * Convert from Px to Dip as per phone screen
	 * @param context Context object
	 * @param pxValue the Px value to be converted from
	 * @return a Dip value
	 */
	public static int pxToDp(Context context, float pxValue) {  
		// Get Screen density as scale
		final float scale = context.getResources().getDisplayMetrics().density;
		// +0.5f: used to 4 she 5 ru
		return (int) (pxValue / scale + 0.5f);  
	}
}
