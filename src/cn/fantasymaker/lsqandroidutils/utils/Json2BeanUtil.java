package cn.fantasymaker.lsqandroidutils.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Convenience util for Json-JavaBean converting.<br>
 * @dependency gson-2.2.1.jar
 * @author Li Shaoqing
 */
public class Json2BeanUtil {
	
	private Json2BeanUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static Gson gson = new Gson();

	/**
	 * Convert a Json string to a JavaBean
	 * @param json the Json string to be converted from
	 * @param clazz the class to be converted to
	 * @return an object of specific Class
	 * @throws JsonSyntaxException
	 */
	public static <T> T jsonToBean(String json,Class<T> clazz) throws JsonSyntaxException {
		if(gson == null){
			gson = new Gson();
		}
		return gson.fromJson(json, clazz);
	}
	
	/**
	 * Convert a JavaBean to a Json string
	 * @param clazz javabean to be converted from
	 * @return json string
	 */
	public static <T> String beanToJson(Class<T> clazz){
		if(gson == null){
			gson = new Gson();
		}
		return gson.toJson(clazz);
	}
}
