package cn.fantasymaker.lsqandroidutils.utils;

import java.util.Random;

import android.graphics.Color;

/**
 * TODO need to add more functions
 * @author Li Shaoqing
 */
public class ColorUtil {
	
	private ColorUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	/**
	 * get random color rgb value
	 * @return rgb color int
	 */
	public static int getRandomColor(){
		Random random = new Random();
		/*
		 * Better limiting value.
		 * if value is too small, it will appear lighter
		 * if value is too large, it will appear darker
		 */
		//limit within 50-199
		int red = random.nextInt(150) + 50;
		int green = random.nextInt(150) + 50;
		int blue = random.nextInt(150) + 50;
		//create a color int as per rgb and return
		return Color.rgb(red, green, blue);
	}
}
