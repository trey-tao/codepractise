package com.trey.lintcode.easy;

/**
 * 100. 删除排序数组中的重复数字
 *
 * 描述、
 * 给定一个排序数组，在原数组中“删除”重复出现的数字，使得每个元素只出现一次，并且返回“新”的数组的长度。
 *
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 *
 * 样例
 * 样例 1:
 * 	输入:  []
 * 	输出: 0
 *
 *
 * 样例 2:
 * 	输入:  [1,1,2]
 * 	输出: 2
 *
 * 	解释:
 * 	数字只出现一次的数组为: [1,2]
 *
 * @FileName: RemoveDuplicates.java
 * @Description: RemoveDuplicates.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/1 17:06
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		// write your code here
		if (nums.length == 0) return 0;
		if(nums.length == 1) return 1;
		int count = 1;

		/**
		 * 思路：
		 * 1 需要记录两个索引位置，当前数组的索引位置index（1开始），生成数组的索引位置count-1（0）开始
		 * 2 遍历数组，从1开始，判断是否与count-1相同，相同则跳过，不同则替换。
		 * 3 方法基于排序数组才能这么完
		 */
		for(int i = 1; i< nums.length; i++) {
			if(nums[i] != nums[count-1]) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3,4,4};
		System.out.println(new RemoveDuplicates().removeDuplicates(nums));
		for(int i=0; i< nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
