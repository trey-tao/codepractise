package com.trey.lintcode.easy;

/**
 * 101. 删除排序数组中的重复数字 II
 *
 * 给你一个排序数组，删除其中的重复元素，使得每个数字最多出现两次，返回新的数组的长度。
 * 如果一个数字出现超过2次，则这个数字最后保留两个。
 *
 * 样例
 * 样例 1:
 * 	输入: []
 * 	输出: 0
 *
 *
 * 样例 2:
 * 	输入:  [1,1,1,2,2,3]
 * 	输出: 5
 *
 * 	样例解释:
 * 	长度为 5，  数组为：[1,1,2,2,3]
 *
 * @FileName: RemoveDuplicates2.java
 * @Description: RemoveDuplicates2.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/4 19:01
 */
public class RemoveDuplicates2 {

	public int removeDuplicates(int[] nums) {
		// write your code here

		/**
		 * 思路：
		 * 1。 与上一题类似，需要注意的是没有出现两个以上的重复情况，目标数组的索引就需要跟着动
		 */
		if (nums.length == 0) return 0;
		if(nums.length == 1) return 1;
		if(nums.length == 2) return 2;
		int count = 2;

		for(int i = 2; i < nums.length; i++) {
			if(nums[i] != nums[count-1]
					|| nums[i] != nums[count-2]) {
				nums[count] = nums[i];
				count++;
			} else {
				nums[count] = nums[i];
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
