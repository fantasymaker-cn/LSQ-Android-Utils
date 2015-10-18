package cn.fantasymaker.lsqandroidutils.utils;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Convenience util for Image operation. functions:<br>
 * - resizing image<br>
 * - converting image between different datatypes, such as Drawable, Bitmap, byte array.
 * @author Li Shaoqing
 */
public class ImageUtil {
	
	private ImageUtil() throws InstantiationException{
		throw new InstantiationException("Instatiation is not allowed! Use static methods only!");
	}
	
    /**
     * convert Bitmap to byte array
     * @param bitmap bitmap to be converted
     * @return a byte array
     */
    public static byte[] bitmapToByte(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //compress bitmap to an output stream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        //convert the output stream to a byte array and return
        return out.toByteArray();
    }
	
    /**
     * convert byte array to Bitmap
     * @param b byte array to be converted
     * @return a bitmap object
     */
    public static Bitmap byteToBitmap(byte[] b) {
        return (b == null || b.length == 0)? null : BitmapFactory.decodeByteArray(b, 0, b.length);
    }
    
    /**
     * convert Drawable to byte array
     * @param drawable drawable to be converted
     * @return a byte array
     */
    public static byte[] drawableToByte(Drawable drawable) {
        return drawable == null? null : bitmapToByte(drawableToBitmap(drawable));
    }

    /**
     * convert byte array to Drawable
     * @param b byte array to be converted
     * @return a drawable object
     */
    public static Drawable byteToDrawable(byte[] b) {
    	return (b == null || b.length == 0) ? null : bitmapToDrawable(byteToBitmap(b));
    }

	/**
	 * convert a Drawable to a Bitmap
	 * @param drawable the Drawable object to be converted
	 * @return a Bitmap object
	 */
	public static Bitmap drawableToBitmap(Drawable drawable){
		return drawable == null? null : ((BitmapDrawable)drawable).getBitmap(); 
	}
	
    /**
     * convert Bitmap to Drawable
     * @param bitmap bitmap to be converted
     * @return a drawable object
     */
    @SuppressWarnings("deprecation")
	public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return bitmap == null? null : new BitmapDrawable(bitmap);
    }
    
    /**
     * resize image to a target size
     * @param oriBitmap bitmap to be resized
     * @param targetWidth target width
     * @param targetHeight target height
     * @return a scaled new bitmap
     */
    public static Bitmap resizeImage(Bitmap oriBitmap, int targetWidth, int targetHeight) {
        return oriBitmap == null? null : resizeImageByScale(oriBitmap, (float) targetWidth / oriBitmap.getWidth(), (float) targetHeight / oriBitmap.getHeight());
    }

    /**
     * resize image by specified scale of width and height
     * @param oriBitmap bitmap to be resized
     * @param scaleOfWidth sacle of width
     * @param scaleOfHeight scale of height
     * @return a scaled new bitmap
     */
    public static Bitmap resizeImageByScale(Bitmap oriBitmap, float scaleOfWidth, float scaleOfHeight) {
        if (oriBitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(scaleOfWidth, scaleOfHeight);
        return Bitmap.createBitmap(oriBitmap, 0, 0, oriBitmap.getWidth(), oriBitmap.getHeight(), matrix, true);
    }
}
