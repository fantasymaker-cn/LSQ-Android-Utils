package cn.fantasymaker.lsqandroidutils.utils;

import android.graphics.Rect;
/**
 * Convenience util for calculating actual progress value as per current progress.<br>
 * For example, if you want to calculate each actual value from 30~150 as per 
 * 0%~100%, you can use this util.<br>
 * function:<br>
 * - int<br>
 * - float<br>
 * - argb<br>
 * - rect
 * @author Li Shaoqing
 */
public class ProgressUtil {
	
	private ProgressUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
    /**
     * Calculate progress value
     * @param percent current percent value
     * @param startValue start value of progress
     * @param endValue end value of progress
     * @return actual progress value
     */
    public static int getInt(float percent, int startValue, int endValue) {
        return (int) (startValue + percent * (endValue - startValue));
    }

    /**
     * Calculate progress value
     * @param percent current percent value
     * @param startValue start value of progress
     * @param endValue end value of progress
     * @return actual progress value
     */
    public static Float getFloat(float percent, Number startValue, Number endValue) {
        float startFloat = startValue.floatValue();
        return startFloat + percent * (endValue.floatValue() - startFloat);
    }

    /**
     * Calculate progress value
     * @param percent current percent value
     * @param startValue start value of progress
     * @param endValue end value of progress
     * @return actual progress value
     */
    public static Object getArgb(float percent, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int) ((startA + (int) (percent * (endA - startA))) << 24)
                | (int) ((startR + (int) (percent * (endR - startR))) << 16)
                | (int) ((startG + (int) (percent * (endG - startG))) << 8)
                | (int) ((startB + (int) (percent * (endB - startB))));
    }
    
    /**
     * Calculate progress value
     * @param percent current percent value
     * @param startValue start value of progress
     * @param endValue end value of progress
     * @return actual progress value
     */
    public static Rect getRect(float percent, Rect startValue, Rect endValue) {
        return new Rect(startValue.left + (int)((endValue.left - startValue.left) * percent),
                startValue.top + (int)((endValue.top - startValue.top) * percent),
                startValue.right + (int)((endValue.right - startValue.right) * percent),
                startValue.bottom + (int)((endValue.bottom - startValue.bottom) * percent));
    }
}
