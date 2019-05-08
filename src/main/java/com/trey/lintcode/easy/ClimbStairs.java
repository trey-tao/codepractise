package com.trey.lintcode.easy;

/**
 * 111. 爬楼梯
 *
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 *
 * 样例
 * 样例 1:
 * 	输入:  n= 3
 * 	输出: 3
 *
 * 	样例解释：
 * 	1) 1, 1, 1
 * 	2) 1, 2
 * 	3) 2, 1
 * 	共3种
 *
 *
 * 样例 2:
 * 	输入:  n = 1
 * 	输出: 1
 *
 * 	解释:
 * 	只有一种方案
 *
 * @FileName: ClimbStairs.java
 * @Description: ClimbStairs.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/18 19:00
 */
public class ClimbStairs {

	public int solution(int n) {
		// 递归思路，时间复杂度较高
		if (n < 3) return n;
		return solution(n-1) + solution(n-2);
	}

	public int solution2(int n) {
		/**
		 * 思路：
		 * 登上第1级：1种
		 * 登上第2级：2种
		 * 登上第3级：1+2=3种（前一步要么从第1级迈上来,要么从第2级迈上来）
		 * 登上第4级：2+3=5种（前一步要么从第2级迈上来,要么从第3级迈上来）
		 * 登上第5级：3+5=8种
		 * 登上第6级：5+8=13种
		 * 登上第7级：8+13=21种
		 * 登上第8级：13+21=34种
		 * 登上第9级：21+34=55种
		 * 登上第10级：34+55=89种
		 * 通过以上枚举，可以发现规律，利用一个有三个元素的数组，来进行循环赋值即可
		 */
		if(n < 3) return n;
		int[] tmp = new int[3];
		tmp[0] = 2;
		tmp[1] = 3;
		tmp[2] = 3;
		for(int i = 3;i < n; i++ ) {
			tmp[2] = tmp[0] + tmp[1];
			tmp[0] = tmp[1];
			tmp[1] = tmp[2];
		}
		return tmp[2];
	}

	public static void main(String[] args) {
		int  n = new ClimbStairs().solution2(7);
		System.out.println(n);
	}

}
