package com.trey.lintcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 53 翻转字符串中的单词
 * 说明
 *      单词的构成：无空格字母构成一个单词
 *      输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 *      如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 * 样例
 *      给出s = "the sky is blue"，返回"blue is sky the"
 * @FileName: ReverseWord.java
 * @Description: ReverseWord.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/15 17:39
 */
public class ReverseWord {


	public String reverseWords(String s) {
		// write your code here
		List<String> list = Arrays.asList(s.trim().split(" "));
		Collections.reverse(list);
		StringBuilder str = new StringBuilder();
		list.forEach(ss -> {
			if(!"".equals(ss)) {
				str.append(ss).append(" ");
			}
		});

		return str.substring(0,str.length()-1);
	}

	public static void main(String[] args) {
		String s = "  i  am     a  boy  ";
		System.out.println(new ReverseWord().reverseWords(s));
	}
}
