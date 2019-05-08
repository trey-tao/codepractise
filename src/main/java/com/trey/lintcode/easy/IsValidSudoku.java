package com.trey.lintcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 389. 判断数独是否合法
 * 请判定一个数独是否有效。
 *
 * 该数独可能只填充了部分数字，其中缺少的数字用 . 表示。
 *
 * 样例
 * 样例1:
 *
 * 输入:
 * ["53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 * 输出: true
 * 样例说明:
 * 这个数独如下图所示，他是合法的。
 * Valid Sudoku
 *
 * Example 2:
 *
 * 输入:
 * ["53..7j...","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 * 输出: false
 *
 * 说明
 * What is Sudoku?
 *
 * http://sudoku.com.au/TheRules.aspx
 * https://zh.wikipedia.org/wiki/數獨
 * https://en.wikipedia.org/wiki/Sudoku
 * http://baike.baidu.com/subview/961/10842669.htm
 * 注意事项
 * 一个合法的数独（仅部分填充）并不一定是可解的。我们仅需使填充的空格有效即可。
 *
 * @FileName: IsValidSudoku.java
 * @Description: IsValidSudoku.java类说明
 * @Author: tao.shi
 * @Date: 2019/3/26 20:54
 */
public class IsValidSudoku {

	/**
	 * 思路：
	 *      仅需要判断填充数字合法即可
	 *      判断每行每列数字都不重复即可
	 *      利用三个Set，分别判断行、列、宫是否满足
	 *      关键在于同一次遍历，如果控制好行、列索引值
	 *
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		// write your code here
		Set<Character> setLine = new HashSet<>();
		Set<Character> setRow = new HashSet<>();
		Set<Character> setGong = new HashSet<>();
		for(int i = 0; i < board.length; i++) {
			setLine.clear();
			setRow.clear();
			for(int j = 0; j < board[i].length; j++) {
				char c = board[i][j];
				if(setLine.contains(c) && c != '.') {
					return false;
				}
				setLine.add(c);

				char r = board[j][i];
				if(setRow.contains(r) && r != '.') {
					return false;
				}
				setRow.add(r);
			}
		}

		for(int i = 0; i < board.length; i = 3 + i) {
			for(int j = 0; j < board[i].length; j = j + 3) {
				setGong.clear();
				for(int x = i; x < i + 3;x++) {
					for(int y = j; y < j + 3; y++) {
						char g = board[x][y];
						if(setGong.contains(g) && g != '.') {
							return false;
						}
						setGong.add(g);
					}
				}

			}
		}

		return true;
	}

	public static void main(String[] args) {
		int i = 1;
		int j = 3;
		System.out.println(j/3 + i);
		System.out.println(j % 3);
	}

}
