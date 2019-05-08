package com.trey.lintcode.easy;

/**
 *
 * 60. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 *
 * 你可以假设在数组中无重复元素。
 *
 * 样例
 * [1,3,5,6]，5 → 2
 *
 * [1,3,5,6]，2 → 1
 *
 * [1,3,5,6]， 7 → 4
 *
 * [1,3,5,6]，0 → 0
 *
 * 挑战
 * 时间复杂度为O(log(n))
 *
 * @FileName: SearchInsert.java
 * @Description: SearchInsert.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/17 13:39
 */
public class SearchInsert {

	/**
	 * 思路：
	 * 1 题干为排序数组，所以用二分法实现
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] A, int target) {
		/**
		 * 1 默认begin=0，end=length-1，获取中间序号，与target比较
		 * 2 如果target大，则更新begin为中间序号，继续循环
		 * 3 如果target小，则更新end为中间序号，继续循环
		 */
		if(A.length == 0) {
			return 0;
		}
		int begin = 0;
		int end = A.length-1;
		if(target < A[0]) {
			return 0;
		}
		if(target > A[A.length-1]) {
			return end + 1;
		}
		if(end == 0) {
			return 0;
		}
		int index = 0;
		while(begin < end) {
			index = (end + begin) / 2;
			if(target == A[index]) {
				return index;
			}
			if(target > A[index]) {
				begin = index+1;
			}
			if(target < A[index]) {
				end = index;
			}
		}
		if(target == A[begin]) {
			return begin;
		}
		return begin;
	}

	public static void main(String[] args) {
		int[] A = {};
		int target = 0;
		System.out.println(new SearchInsert().searchInsert(A,target));
	}

}
