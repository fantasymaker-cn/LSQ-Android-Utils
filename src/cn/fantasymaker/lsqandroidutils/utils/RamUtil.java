package cn.fantasymaker.lsqandroidutils.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;

/**
 * Convenience util for getting RAM infos
 * @author Li Shaoqing
 */
public class RamUtil {

	private RamUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static ActivityManager am = null;
	private static MemoryInfo outInfo = new MemoryInfo();
	
	/**
	 * get available size of ram. Work for API 16 and above.
	 * @return available size in byte
	 */
	public static long getAvailableRamSize(Context context){
		if(am == null){
			am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		}
		am.getMemoryInfo(outInfo);
		return outInfo.availMem;
	}
	/**
	 * get total size of ram. Work for API 16 and above.
	 * @return total size in byte
	 */
	public static long getTotalRamSize(Context context){
		if(am == null){
			am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		}
		am.getMemoryInfo(outInfo);
		return outInfo.totalMem;
	}
	
	/**
	 * get total size of ram. Work for all API levels.
	 * @return total size in byte
	 * @deprecated
	 */
	public static long getTotalRamSize(){
		StringBuilder sb = new StringBuilder();
		//read this file and pick up numbers
		File file = new File("/proc/meminfo");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String readLine = br.readLine();
			char[] charArray = readLine.toCharArray();
			for (char c : charArray) {
				if (c >='0' && c<='9') {
					sb.append(c);
				}
			}
			String string = sb.toString();
			long parseLong = Long.parseLong(string);
			return parseLong * 1024;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
