package com.trey.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 209. 第一个只出现一次的字符
 *
 * 给出一个字符串，找出第一个只出现一次的字符。
 *
 * 样例
 * 样例 1:
 * 	输入: "abaccdeff"
 * 	输出:  'b'
 *
 * 	解释:
 * 	'b' 是第一个出现一次的字符
 *
 *
 * 样例 2:
 * 	输入: "aabccd"
 * 	输出:  'b'
 *
 * 	解释:
 * 	'b' 是第一个出现一次的字符
 *
 * 挑战
 * 不使用额外的存储空间。
 *
 * @FileName: FirstUniqChar.java
 * @Description: FirstUniqChar.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/26 17:08
 */
public class FirstUniqChar {

	/**
	 * 思路：
	 *      必须遍历所有元素，因为需要确保所找元素只出现一次
	 * 简单做法：
	 *      第一次遍历，将所有c作为key，塞入map里
	 *      第二次顺序遍历，发现map.get(key)为1，则输出
	 * 挑战（不占用额外空间）
	 *
	 * @param str
	 * @return
	 */
	public char firstUniqChar(String str) {
		// Write your code here
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0; i < str.length();i++) {
			String c = String.valueOf(str.charAt(i));
			Integer integer = map.get(c);
			if(integer == null) {
				map.put(c,1);
			} else {
				integer++;
				map.put(c,integer);
			}
		}
		for(int i = 0; i< str.length(); i++) {
			String c = String.valueOf(str.charAt(i));
			Integer integer = map.get(c);
			if(integer == 1) {
				return str.charAt(i);
			}
		}
		return '0';
	}


	/**
	 * 不占用额外空间
	 * @param str
	 * @return
	 */
	public char firstUniqChar2(String str) {
		// Write your code here
		if(str.length() == 0) return '0';
		for(int i = 0; i < str.length(); i++) {
			boolean b = false;
			for( int j = 0; j < str.length(); j++) {
				if(i == j) {
					continue;
				}
				if(str.charAt(i) == str.charAt(j)) {
					b = true;
					break;
				}
			}
			if(!b) {
				return str.charAt(i);
			}
		}
		return str.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(new FirstUniqChar().firstUniqChar("ababababababcddddf"));
		System.out.println(new FirstUniqChar().firstUniqChar2("ababababababcddddf"));
	}

}
