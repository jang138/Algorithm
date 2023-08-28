package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2580
 * 골드4 스도쿠
 */

public class BJ2580_스도쿠 {

	static int[][] table;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		table = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		sudoku(0, 0);

	}

	private static void sudoku(int x, int y) {

		
	}

}
