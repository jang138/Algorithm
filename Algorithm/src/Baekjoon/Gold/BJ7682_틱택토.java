package Baekjoon.Gold;

/*
 * https://www.acmicpc.net/problem/7682
 * 골드5 틱택토
 */

/*
 * 1. O가 X보다 많이 둔 경우
 * 2. 말을 다 둔 경우
 * 3. 말을 덜 둔 경우
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ7682_틱택토 {

	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			if (str.equals("end")) {
				break;
			}

			arr = new char[3][3];

			for (int i = 0; i < 9; i++) {
				arr[i / 3][i % 3] = str.charAt(i);
			}

			System.out.println(tictactoc() ? "valid" : "invalid");
		}

	}

	static boolean tictactoc() {
		int xCnt = 0;
		int oCnt = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == 'X') {
					xCnt++;
				} else if (arr[i][j] == 'O') {
					oCnt++;
				}
			}
		}

		// 후공이 더 많이 둔 경우
		if (xCnt < oCnt) {
			return false;
		}

		// 빈칸 없
		// 경기결과 X가 이기거나 무승부 => O가 이기거나 둘다 빙고가 나오면 false
		if (xCnt + oCnt == 9 && xCnt == oCnt + 1) {
			if (Bingo('O') && !Bingo('X')) {
				return false;
			} else if (Bingo('O') && Bingo('X')) {
				return false;
			}
			return true;
		}

		else {
			if (xCnt == oCnt + 1) {
				if (Bingo('X') && !Bingo('O')) {
					return true;
				} else {
					return false;
				}
			} else if (xCnt == oCnt) {
				if (Bingo('O') && !Bingo('X')) {
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}

	static boolean Bingo(char c) {
		for (int i = 0; i < 3; i++) {
			if (arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) {
				return true; // 가로
			} else if (arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) {
				return true; // 세로
			}
		}

		// 대각선
		if (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) {
			return true;
		} else if (arr[2][0] == c && arr[1][1] == c && arr[0][2] == c) {
			return true;
		}

		return false;
	}

}