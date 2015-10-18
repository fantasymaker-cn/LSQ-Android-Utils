package cn.fantasymaker.lsqandroidutils.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Convenience util for converting a Chinese charactor to its Pinyin string<br>
 * Some charactors may have multi-pronunciation<br>
 * <b>* Based on pinyin4j-2.5.0.jar</b>
 * @author Li Shaoqing
 */
public class PinyinUtil {

	private PinyinUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}
	
	private static HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
	
	//case type constant
	/**
	 * format pinyin in upper case, such as "WO"
	 */
	public static final Object CASETYPE_UPPERCASE = HanyuPinyinCaseType.UPPERCASE;
	/**
	 * format pinyin in lower case, such as "wo"
	 */
	public static final Object CASETYPE_LOWERCASE = HanyuPinyinCaseType.LOWERCASE;
	
	//tone type constant
	/**
	 * format tone in pinyin symbol type. <b>Must use with VCHARTYPE_WITH_U_UNICODE or it will throw an exception</b>
	 */
	public static final Object TONETYPE_WITH_TONE_MARK = HanyuPinyinToneType.WITH_TONE_MARK;
	/**
	 * format tone in number type, such as "ni3", "hao3"
	 */
	public static final Object TONETYPE_WITH_TONE_NUMBER = HanyuPinyinToneType.WITH_TONE_NUMBER;
	/**
	 * do not show tone
	 */
	public static final Object TONETYPE_WITHOUT_TONE = HanyuPinyinToneType.WITHOUT_TONE;
	
	//v char pronounce type
	/**
	 * use "u:" to represent "u(yu1)"
	 */
	public static final Object VCHARTYPE_WITH_U_AND_COLON = HanyuPinyinVCharType.WITH_U_AND_COLON;
	/**
	 * use pinyin symbol to represent "u(yu1)"
	 */
	public static final Object VCHARTYPE_WITH_U_UNICODE = HanyuPinyinVCharType.WITH_U_UNICODE;
	/**
	 * use "v" to represent "u(yu1)"
	 */
	public static final Object VCHARTYPE_WITH_V = HanyuPinyinVCharType.WITH_V;
	
	
	public static String[] getPinyin(char singleHanzi, Object caseType, Object toneType, Object vCharType) throws BadHanyuPinyinOutputFormatCombination{
		//set formats
		hanyuPinyinOutputFormat.setCaseType((HanyuPinyinCaseType)caseType);
		hanyuPinyinOutputFormat.setToneType((HanyuPinyinToneType)toneType);
		hanyuPinyinOutputFormat.setVCharType((HanyuPinyinVCharType)vCharType);
		//get result and return
		return PinyinHelper.toHanyuPinyinStringArray(singleHanzi, hanyuPinyinOutputFormat);
	}
}
