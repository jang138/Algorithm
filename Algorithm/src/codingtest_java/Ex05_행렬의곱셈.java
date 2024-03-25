package codingtest_java;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12949

public class Ex05_행렬의곱셈 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(
				solution(new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 3, 3 }, { 3, 3 } })));
		System.out.println(Arrays.deepToString(solution(new int[][] { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } },
				new int[][] { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } })));
	}

	private static int[][] solution(int[][] arr1, int[][] arr2) {
		int row1 = arr1.length;
		int row2 = arr2.length;
		int column1 = arr1[0].length;
		int column2 = arr2[0].length;

		int[][] answer = new int[row1][column2];

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < column2; j++) {
				for (int k = 0; k < row2; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}

}
