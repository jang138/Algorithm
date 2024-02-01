package Programmers.LV1;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * LV1 K번째 수
 */

public class K번째수 {

	public static void main(String[] args) {
		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		
		int answer[] = solution(array, commands);
		
		System.out.println(Arrays.toString(answer));

	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int n = 0; n < commands.length; n++) {
			int i = commands[n][0];
			int j = commands[n][1];
			int k = commands[n][2];

			int length = j - i + 1;
			// int[] subArray = new int[length];
			int[] copyArray = Arrays.copyOfRange(array, i - 1, j);
			// for(int a = 0; a < length; a++){
			// subArray[a] = array[a + i - 1];
			// }

			// Arrays.sort(subArray);
			Arrays.sort(copyArray);

			answer[n] = copyArray[k - 1];
		}
		return answer;
	}

}
