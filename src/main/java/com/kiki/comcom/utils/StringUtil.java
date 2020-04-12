package com.kiki.comcom.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串处理的工具类
 * @author lk
 * @date 2020年3月26日
 *
 */
public class StringUtil {

	// 方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 (5分)
	public static boolean hasLength(String src) {
		return null!=src && src.length()>0;
	}

	// 方法2：判断源字符串是否有值，空引号(空白字符串)也算没值 空格也算没值
	public static boolean hasText(String src) {
		return null!=src && src.trim().length()>0;
	}
	
	//判断源字符串是否是手机号码
	public static boolean isPhone(String phone) {
		//手机号的正则
		String regex ="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(phone);

		boolean isMatch = m.matches();

		return isMatch;
	}
	
	//判断源字符串是否是邮箱
	public static boolean isEmail(String email) {
		String regEx1 ="^([A-z0-9]+[-|\\.]?)+[a-z0-9A-Z]@([A-z0-9]+(-[A-z0-9]+)?\\.)+[A-z]{2,}$";
		Pattern p = Pattern.compile(regEx1);

		Matcher m = p.matcher(email);

		boolean isMatch = m.matches();
		return isMatch;
	}
	

	//返回一个随机的中文汉字  简体中文
	public static String randomChineseString() {
		
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(40)));// 区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// 位码，0xA0打头，范围第1~94列
	
		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // 区位码组合成汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
		
	}
	// 方法3：返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体)范围内，例如“中呀被”(5分)
	public static String randomChineseString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(randomChineseString());
		}
		return sb.toString();
		
		// TODO 实现代码
	}

	// 方法4：返回中文姓名，必须以真实姓开头，百家姓在“六、附百家姓”里，名使用1-2个随机汉字(8分)，内部调用randomChineseString()方法(3分)。返回示例：“刘呀被”、“欧阳及为”
	public static String generateChineseName() {
		//中国百家姓
		   String[] str= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闽","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","锺","徐","丘","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麹","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","斜","厉","戎","祖","武","符","刘","景","詹","束","龙","叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","郤","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄","阙","东","欧","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空","曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","竺","权","逑","盖","益","桓","公","晋","楚","阎","法","汝","鄢","涂","钦","岳","帅","缑","亢","况","后","有","琴","商","牟","佘","佴","伯","赏","墨","哈","谯","笪","年","爱","阳","佟","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","锺离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","丌官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良","拓拔","夹谷","宰父","谷梁","段干","百里","东郭","南门","呼延","归","海","羊舌","微生","梁丘","左丘","东门","西门","南宫"};		
			//1 从数组中随机获取一个姓氏
			String name1 =str[RandomUtil.random(0, str.length-1)];	
			//2 获取名字
			String name2 =randomChineseString(RandomUtil.random(1, 2));
			return name1 +name2;
	}
	
	/**
	 * 
	    * @Title: isPosOrNegIntegerOrFloat
	    * @Description: 判断字符串是否是整数或者浮点数
	    * @param @param str
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isPosOrNegIntegerOrFloat(String str) {
		if(!StringUtil.hasLength(str)) {
			return false;
		}else {
			Pattern pattern = Pattern.compile("^[-\\+]?(0|[1-9]\\d*)(\\.\\d+)?$");
	        boolean rst = pattern.matcher(str).matches();
	        
	        return rst;
		}
	}
	
	/**
	 * 
	    * @Title: isPosOrNegFloat
	    * @Description: 判断字符串是否是浮点数
	    * @param @param str
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	static boolean isPosOrNegFloat(String str) {
		if(!StringUtil.hasLength(str)) {
			return false;
		}else {
			Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+[.{1}][\\d]+$");
	        boolean rst = pattern.matcher(str).matches();
	        
	        return rst;
		}
	}
	
	/**
	 * 
	    * @Title: isPosOrNegInteger
	    * @Description: 判断是否是整数
	    * @param @param str
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	static boolean isPosOrNegInteger(String str) {
        if (!StringUtil.hasLength(str)) {
            return false;
        }else {
        	 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
             boolean rst = pattern.matcher(str).matches();
      
             return rst;
        }
 
       
	}

	/**
	 * 
	    * @Title: isNegative
	    * @Description: 判断是否是负数
	    * @param @param str
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	static boolean isNegative(String str) {
		if (!StringUtil.hasLength(str)) {
			return false;
		}else {
			Pattern pattern = Pattern.compile("^[\\-][\\d]+$");
			boolean rst = pattern.matcher(str).matches();
		      
            return rst;
		}
	}
	
	/**
	 * 
	 * @Title: isPositive
	 * @Description: 判断是否是正数
	 * @param @param str
	 * @param @return    参数
	 * @return boolean    返回类型
	 * @throws
	 */
	static boolean isPositive(String str) {
		if (!StringUtil.hasLength(str)) {
			return false;
		}else {
			Pattern pattern = Pattern.compile("^[\\+]?[\\d]+$");
			boolean rst = pattern.matcher(str).matches();
			
			return rst;
		}
	}
	
	/**
	 * 功能说明：实现判断传入的字符串是否为包含http的url地址
	 */
	public static boolean isHttpUrl(String src){
		try {
			URL url = new URL(src);
			url.openStream();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("不是合法的url");
		return false;
		
	}

}
