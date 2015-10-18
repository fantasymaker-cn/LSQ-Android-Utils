package cn.fantasymaker.lsqandroidutils.utils;

import android.os.Environment;
import android.os.StatFs;

/**
 * Convenience util for getting inner and external storage infos
 * @author Li Shaoqing
 */
@SuppressWarnings("deprecation")
public class StorageUtil {
	
	private StorageUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	/**
	 * get available size of external storage
	 * @return available size in byte
	 */
	public static long getAvailableExStorageSize(){
		//get SD card path
		String path = Environment.getExternalStorageDirectory().getPath();
        StatFs stat = new StatFs(path);
        return stat.getBlockSize() * stat.getAvailableBlocks();
	}
	
	/**
	 * get total size of external storage
	 * @return total size in byte
	 */
	public static long getTotalExStorageSize(){
		//get SD card path
		String path = Environment.getExternalStorageDirectory().getPath();
        StatFs stat = new StatFs(path);
        return stat.getBlockSize() * stat.getBlockCount();
	}
	
	/**
	 * get available size of inner storage
	 * @return available size in byte
	 */
	public static long getAvailableROMSize(){
		String path = Environment.getDataDirectory().getPath();
		StatFs stat = new StatFs(path);
        return stat.getBlockSize() * stat.getAvailableBlocks();
	}
	
	/**
	 * get total size of inner storage
	 * @return total size in byte
	 */
	public static long getTotalROMSize(){
		//get SD card path
		String path = Environment.getDataDirectory().getPath();
        StatFs stat = new StatFs(path);
        return stat.getBlockSize() * stat.getBlockCount();
	}
}
