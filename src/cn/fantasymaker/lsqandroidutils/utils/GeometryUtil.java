package cn.fantasymaker.lsqandroidutils.utils;

import android.graphics.PointF;

/**
 * Convenience util for geometry operation.<br>
 * function:<br>
 * - getDistanceBetween2Points<br>
 * - getMiddlePoint<br>
 * - getPointByPercent<br>
 * - getIntersectionPoints
 * @author Li Shaoqing
 */
public class GeometryUtil {
	
	private GeometryUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	/**
	 * Calculate distance between 2 points
	 * @param p1 a point
	 * @param p2 another point
	 * @return distance between 2 points
	 */
	public static float getDistanceBetween2Points(PointF p1, PointF p2) {
		return (float) Math.sqrt(Math.pow(p1.y - p2.y, 2) + Math.pow(p1.x - p2.x, 2));
	}
	
	/**
	 * Get middle point between p1 and p2.
	 * @param p1 a point
	 * @param p2 another point
	 * @return middle point object
	 */
	public static PointF getMiddlePoint(PointF p1, PointF p2) {
		return new PointF((p1.x + p2.x) / 2.0f, (p1.y + p2.y) / 2.0f);
	}
	
	/**
	 * Get point between p1 and p2 by percent.
	 * @param p1 a point
	 * @param p2 another point
	 * @param percent given percent to calculate target point
	 * @return target point in given percent distance
	 */
	public static PointF getPointByPercent(PointF p1, PointF p2, float percent) {
		return new PointF(evaluateValue(percent, p1.x , p2.x), evaluateValue(percent, p1.y , p2.y));
	}
	
	/*
	 * 内部使用, 由getPointByPercent调用
	 * 根据分度值，计算从start到end中，fraction位置的值。fraction范围为0 -> 1
	 * @param fraction
	 * @param start
	 * @param end
	 * @return
	 */
	private static float evaluateValue(float fraction, Number start, Number end){
		return start.floatValue() + (end.floatValue() - start.floatValue()) * fraction;
	}
	
	/**
     * Get 2 points by a line which intersection between center of circle and circle with given slope.
     * 获取通过指定圆心, 斜率为slope的直线与圆的交点。
     * @param centerPoint The center point of circle
     * @param radius The circle radius (r)
     * @param slope The slope of line which cross the pMiddle.
     * @return
     */
    public static PointF[] getIntersectionPoints(PointF centerPoint, float radius, Double slope) {
    	//must have 2 points
        PointF[] points = new PointF[2];
        float radian, xOffset = 0, yOffset = 0; 
        if(slope != null){
            radian= (float) Math.atan(slope);
            xOffset = (float) (Math.cos(radian) * radius);
            yOffset = (float) (Math.sin(radian) * radius);
        }else {
            xOffset = radius;
            yOffset = 0;
        }
        points[0] = new PointF(centerPoint.x + xOffset, centerPoint.y + yOffset);
        points[1] = new PointF(centerPoint.x - xOffset, centerPoint.y - yOffset);
        return points;
    }
}