package cn.fantasymaker.lsqandroidutils.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Convenience util for io operation<br>
 * functions:<br>
 * - close streams
 * @author Li Shaoqing
 */
public class IOUtil {
	
	private IOUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}

	/**
	 * Close a stream in a safe way and release the memory
	 * @param stream
	 */
	public static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			stream = null;
		}
	}
}
