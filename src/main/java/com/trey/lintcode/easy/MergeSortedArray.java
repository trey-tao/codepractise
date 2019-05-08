package com.trey.lintcode.easy;

/**
 * 64 合并排序数组
 *
 * 描述
 * 合并两个排序的整数数组A和B变成一个新的数组。
 *
 *  你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 *
 * 样例
 * 给出 A = [1, 2, 3, empty, empty], B = [4, 5]
 *
 * 合并之后 A 将变成 [1,2,3,4,5]
 *
 * @FileName: MergeSortedArray.java
 * @Description: MergeSortedArray.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/17 14:33
 */
public class MergeSortedArray {

	/**
	 * 思路：
	 *  1 因为A和B都是排序好的
	 *  2 构建目标数组，挨个比较A和B的入口值，进行插入
	 *  3 需要考虑的细节是数组长度不等情况下，需要处理尾部数据
	 *
	 *  其他思路：
	 *      1、 利用队列的特性，遍历是，两个队列 推数据并比较
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		// write your code here
		int[] R = new int[m+n];

		int a = 0, b = 0;

		for(int i = 0; i < R.length; i++ ) {
			if(a < m  && b < n) {
				if(A[a] > B[b]) {
					R[i] = B[b];
					b++;
				} else {
					R[i] = A[a];
					a++;
				}
				continue;
			}
			if(a == m && b < n) {
				R[i] = B[b];
				b++;
			}
			if(b == n && a < m) {
				R[i] = A[a];
				a++;
			}
		}

		for( int i = 0; i < R.length; i++) {
			A[i] = R[i];
		}
	}

	public static void main(String[] args) {
		int[] A = {1,2,3,6,0,0};
		int[] B = {4,5};
		int m = 4;
		int n = 2;
		new MergeSortedArray().mergeSortedArray(A,m,B,n);
	}

}
