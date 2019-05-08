package com.trey.lintcode.easy;

/**
 * 141. x的平方根
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 *
 * 样例
 * 样例 1:
 * 	输入:  0
 * 	输出: 0
 *
 *
 * 样例 2:
 * 	输入: 3
 * 	输出: 1
 *
 * 	样例解释：
 * 	返回对x开根号后向下取整的结果。
 *
 * 样例 3:
 * 	输入: 4
 * 	输出: 2
 *
 *
 * 挑战
 * O(log(x))
 *
 * @FileName: Sqrt.java
 * @Description: Sqrt.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/20 20:26
 */
public class Sqrt {

	public int sqrt(int x) {
		/**
		 * 思路：
		 * 二分法，每次乘以2，
		 *      如果判断平方大于目标值，则选取上一个值和当前值的中值继续
		 *      如果当前值*当前值 = 目标值
		 *      如果上一个值与当前值相差1，则取上一个值
		 */
		if(x == 0) return 0;

		int low = 1;
		int high = x;

		for (int i = low; i < x; i = i * 2) {
			int temp = i * i;
			if(temp == x) {
				return i;
			}
			if( temp <= 0 || temp > x) {
				low = i / 2;
				high = i;
				break;
			}
		}

		while(low < high) {
			if(low + 1 == high) {
				return low;
			}
			int temp = low + (high - low) / 2 ;

			int sqrtTmp = temp * temp;

			if(sqrtTmp == x) {
				return temp;
			}
			if(sqrtTmp > 0 && sqrtTmp < x) {
				low = temp;
			}
			if( sqrtTmp <= 0 || sqrtTmp > x) {
				high = temp;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		System.out.println(new Sqrt().sqrt(2147483647));
		long end = System.currentTimeMillis();
		System.out.println("time :" + (end - begin));
	}
}
