package com.trey.lintcode.easy;

import java.util.Arrays;

/**
 * 407. 加一
 *
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 *
 * 该数字按照数位高低进行排列，最高位的数在列表的最前面。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[1,2,3]
 * 输出：[1,2,4]
 * 样例 2：
 *
 * 输入：[9,9,9]
 * 输出：[1,0,0,0]
 *
 *
 * @FileName: PlusOne.java
 * @Description: PlusOne.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/28 20:21
 */
public class PlusOne {


	/**
	 * 思路：
	 *      从最后一位开始遍历，最后一位+1
	 *      利用一个临时变量存储进位数1
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		// write your code here
		int len = digits.length;
		int  carry = 0;
		for(int i = len - 1; i >= 0; i--) {
			int temp;
			if(i == len - 1) {
				temp = digits[i] + 1;
			} else {
				temp = digits[i] + carry;
			}
			digits[i] = temp % 10;
			carry = temp / 10;
		}
		if(carry == 0) {
			return digits;
		}
		// carry == 1,说明数组长度需要+1
		int[] results = new int[digits.length + 1];
		results[0] = 1;
		for(int i = 0; i < digits.length; i++) {
			results[i+1] = digits[i];
		}
		return results;
	}

	public static void main(String[] args) {
		int[] digits = {9,9,9};
		int[] result = new PlusOne().plusOne(digits);
		Arrays.stream(result).forEach(System.out::println);
	}

}
