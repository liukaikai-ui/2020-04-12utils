package com.kiki.comcom.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil
 * @Description: 随机数处理的工具类
 * @author lk
 * @date 2020年3月26日
 *
 */
public class RandomUtil {

	// 方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对
	public static int random(int min, int max) {
		Random random = new Random();
		return min + random.nextInt(max - min + 1);
	}

	// 方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。
	public static int[] subRandom(int min, int max, int subs) {
		if (subs > (max - min + 1)) {
			throw new RuntimeException("数组太大，无法生成随机数组!");
		} else {
			int[] array = new int[subs];

			HashSet<Integer> set = new HashSet<Integer>();// 用来存放中间数据，主要是用来过滤重复数据
			while (set.size() != subs) {// set的元素个数不等于subs，则继续循环
				set.add(random(min, max));
			}

			int i = 0;
			for (Integer integer : set) {
				array[i] = integer;
				i++;
			}
			return array;
		}

	}

	// 方法3：返回1个1-9,a-Z之间的随机字符。
	public static char randomCharacter() {
		String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		char cha = str.charAt(random(0, str.length()-1));
		return cha;
	}
	
	//返回1-9的随机数字
	public static String randomCharacter(int length) {
		String str = "123456789";
		String result="";
		for (int i = 0; i < length; i++) {
			result += str.charAt(random(0, str.length()-1));
		}
		return result;
	}

	// 方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(randomCharacter());
		}
		return sb.toString();
	}
}
