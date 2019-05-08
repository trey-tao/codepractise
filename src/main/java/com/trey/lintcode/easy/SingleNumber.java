package com.trey.lintcode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 82。 落单的数
 *
 * 描述
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 *
 * 样例
 * 给出 [1,2,2,1,3,4,3]，返回 4
 *
 * 挑战
 * 一次遍历，常数级的额外空间复杂度
 *
 * @FileName: SingleNumber.java
 * @Description: SingleNumber.java类说明
 * @Author: tao.shi
 * @Date: 2019/2/18 19:01
 */
public class SingleNumber {

	/**
	 * 思路：
	 *      n大小的Set作为临时存储，利用两两消除法，最终只会生效一个元素
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		// write your code here
		if(A.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>((A.length-1)/2);
		for(int i = 0 ; i<A.length;i++) {
			if(set.contains(A[i])) {
				set.remove(A[i]);
			} else {
				set.add(A[i]);
			}
		}
		Iterator<Integer> i = set.iterator();
		if(i.hasNext()) {
			return i.next();
		}
		return 0;
	}

}
