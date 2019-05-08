package com.trey.lintcode.easy;

/**
 * 408. 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 * a = "0", b = "0"
 * 输出：
 * "0"
 * 样例 2：
 *
 * 输入：
 * a = "11", b = "1"
 * 输出：
 * "100"
 *
 * @FileName: AddBinary.java
 * @Description: AddBinary.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/28 20:38
 */
public class AddBinary {

	/**
	 * 思路：
	 *      1 先转成整数，相加再转回去（可能存在越界情况）
	 *      2 转成Integer数组，末位开始挨个相加，遇二进1
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		// write your code here
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		int aLen = as.length;
		int bLen = bs.length;
		// 进位标示
		int carry = 0;
		StringBuilder str = new StringBuilder();
		while (aLen > 0 || bLen > 0) {
			int temp;
			if(aLen == 0 && bLen > 0) {
				temp = bs[bLen-1] - '0' + carry;
				bLen--;
			} else
			if(aLen > 0 && bLen == 0) {
				temp = as[aLen-1] - '0' + carry;
				aLen--;
			} else {
				temp = as[aLen-1] - '0' + bs[bLen-1] - '0' + carry;
				aLen--;
				bLen--;
			}
			str.append(temp % 2);
			carry = temp / 2;
		}

		if(carry == 1) {
			str.append(1);
		}
		return str.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11","11"));
	}

}
