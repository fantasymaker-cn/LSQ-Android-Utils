package cn.fantasymaker.lsqandroidutils.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Convenience toast showing util. Less memory consuming, shorter method name
 * @author Li Shaoqing
 */
public class ToastUtil {
	
	private ToastUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
    private static Toast sToast;

    /**
     * show a toast in a short time 
     * @param context a context
     * @param msg the message to be displayed
     */
    public static void toastShort(Context context, String msg) {
    	//single instance
        if (sToast == null) {
        	//create an Toast object without showing out
            sToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        //set text to be displayed
        sToast.setText(msg);
        //show this toast
        sToast.show();
    }
    
    /**
     * show a toast in a long time 
     * @param context a context
     * @param msg the message to be displayed
     */
    public static void toastLong(Context context, String msg) {
    	//single instance
    	if (sToast == null) {
    		//create an Toast object without showing out
    		sToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
    	}
    	//set text to be displayed
    	sToast.setText(msg);
    	//show this toast
    	sToast.show();
    }
}
