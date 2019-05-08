package com.trey.lintcode.easy;

/**
 * 114. 不同的路径
 * 有一个机器人的位于一个 m × n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 问有多少条不同的路径？
 *
 * 样例
 * Example 1:
 * 	Input: n = 1, m = 3
 * 	Output: 1
 *
 * 	Explanation:
 * 	Only one path to target position.
 *
 * Example 2:
 * 	Input:  n = 3, m = 3
 * 	Output: 6
 *
 * 	Explanation:
 * 	D : Down
 * 	R : Right
 * 	1) DDRR
 * 	2) DRDR
 * 	3) DRRD
 * 	4) RRDD
 * 	5) RDRD
 * 	6) RDDR
 * 注意事项
 * n和m均不超过100
 *
 * @FileName: UniquePaths.java
 * @Description: UniquePaths.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/18 19:43
 */
public class UniquePaths {
	/**
	 * 思路：
	 *  枚举找规律：
	 *      m = 1， n = 1 ---> 1
	 *      m = 2， n = 1 ---> 1
	 *      m = 1， n = 2 ---> 1
	 *      m = 2， n = 2 ---> 2
	 *      m = 3， n = 1 ---> 1
	 *      m = 1， n = 3 ---> 1
	 *      m = 3， n = 2 ---> (2*2)+(2*1) = 2+1 = 3
	 *      m = 2， n = 3 ---> (1*2)+(2*2) = 2+1 = 3
	 *      m = 3， n = 3 ---> （2*3）+（3*2）= 3+3 = 6
	 *      m = 4, n = 2 ---->  (3*2) + (4*1) = 3 + 1 = 4
	 *      m = 4, n = 3 ----> (3*3) + (4*2) = 6+4 = 10
	 *      m   ，   n   ----->  (m-1)*n+(n-1)*m
	 *
	 *      利用空间换时间，一个数组，遍历所有可能都存下来
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		// write your code here
		if(m == 1 || n == 1) {
			return 1;
		}
		int[][] tmp = new int[m+1][n+1];
		for( int  i = 1; i <= m; i++) {
			for( int j = 1; j <= n; j++) {
				if(i == 1 || j == 1) {
					tmp[i][j] = 1;
					continue;
				}
				tmp[i][j] = tmp[i-1][j] + tmp[i][j-1];
			}
		}
		return tmp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(3,3));
	}

}
