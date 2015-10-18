package cn.fantasymaker.lsqandroidutils.base;

import java.util.List;

import android.widget.BaseAdapter;

/**
 * Base adapter for list view<br>
 * <b>getView()</b> method should be overrided by sub classes
 * @author Li Shaoqing
 * @param <T>
 */
public abstract class BaseListViewAdapter<T> extends BaseAdapter{
	/**
	 * List which contains data.
	 */
	protected List<T> baselist;
	
	/**
	 * Instanciation method
	 * @param list a List object which contains data
	 */
	public BaseListViewAdapter(List<T> list){
		this.baselist = list;
	}

	@Override
	public int getCount() {
		//default is list' size.
		return baselist.size();
	}

	@Override
	public Object getItem(int position) {
		//default is elements in list
		return baselist.get(position);
	}

	@Override
	public long getItemId(int position) {
		//default is position
		return position;
	}

	//getView() should be overrided by sub classes
}
