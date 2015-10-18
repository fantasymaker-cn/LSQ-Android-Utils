package cn.fantasymaker.lsqandroidutils.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * base activity template 
 * @author Li Shaoqing
 */
public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Configurations before initializations
		configBeforeInit();
		//init views
		initViews();
		//init others
        initOthers();
        //set listeners
        setListeners();
        //init action bar
        initActionBar();
        //add this activity to stack in order to use exitApp() in BaseApplication
        BaseApplication.addActivity(this);
	}
	
	/**
	 * Configurations before initializations, 
	 * such as requestWindowFeature()
	 */
	protected abstract void configBeforeInit();
	
	/**
	 * init content view and init inner views here
	 */
    protected abstract void initViews();
    
    /**
     * set listeners for views here
     */
    protected abstract void setListeners();
    
    /**
     * init action bar here
     */
    protected abstract void initActionBar();
    
    /**
     * init others here
     */
    protected abstract void initOthers();
   
    
}
