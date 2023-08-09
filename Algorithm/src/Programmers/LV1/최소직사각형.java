package Programmers.LV1;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * LV1 최소직사각형
 * { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } }
 * { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } }
 */

public class 최소직사각형 {

	public static void main(String[] args) {
		int[][] input = { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } };
		int answer = solution(input);

		System.out.println(answer);

	}

	private static int solution(int[][] sizes) {
		int answer = 0;
		int w = 0;
		int h = 0;

		for (int i = 0; i < sizes.length; i++) {
			w = Math.max(w, Math.max(sizes[i][0], sizes[i][1]));
			h = Math.max(h, Math.min(sizes[i][0], sizes[i][1]));
		}

		answer = w * h;

		return answer;
	}

}
