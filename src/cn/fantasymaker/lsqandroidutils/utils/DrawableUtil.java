package cn.fantasymaker.lsqandroidutils.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * TODO need check and fill more functions
 * @author Li Shaoqing
 */
public class DrawableUtil {

	private DrawableUtil() throws InstantiationException{
		throw new InstantiationException("Instatiation is not allowed! Use static methods only!");
	}
	
	/**
	 * Create a rectangel shape drawable
	 * @param argb color in argb
	 * @param radius corner radius
	 * @return a rectangel shape
	 */
	public static GradientDrawable createRectangleShape(int argb, float radius){
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setCornerRadius(radius);
		drawable.setColor(argb);
		return drawable;
	}
	
	/**
	 * Create a rectangel shape drawable
	 * @param argb color in argb
	 * @param radiuses 4 corner radius, left-top, right-top, right-bottom, left-top
	 * @return a rectangel shape
	 */
	public static GradientDrawable createRectangleShape(int argb, float[] radiuses){
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setColor(argb);
		drawable.setCornerRadii(radiuses);
		return drawable;
	}
	
	/**
	 * Create a selector(StateListDrawable) drawable
	 * @param pressed drawable in pressed status
	 * @param normal drawable in normal status
	 * @return a selector(StateListDrawable) drawable
	 */
	public static StateListDrawable createSelector(Drawable pressed,Drawable normal){
		StateListDrawable drawable = new StateListDrawable();
		drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);//设置按下的图片
		drawable.addState(new int[]{}, normal);//设置默认的图片
		return drawable;
	}
	
	
}
