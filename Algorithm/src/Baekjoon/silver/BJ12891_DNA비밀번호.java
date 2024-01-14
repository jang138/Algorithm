package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12891
 * 실버2 DNA 비밀번호
 */

public class BJ12891_DNA비밀번호 {

	static int checkArr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String inputStr = br.readLine();

		checkArr = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int subArr[] = new int[4];

		String firstStr = inputStr.substring(0, P);
		for (int k = 0; k < P; k++) {
			char c = firstStr.charAt(k);
			subArr[findIndex(c)]++;
		}

		if (checkDNA(subArr)) {
			cnt++;
		}

		for (int i = 1; i <= S - P; i++) {
			char outChar = inputStr.charAt(i - 1);
			char inChar = inputStr.charAt(i + P - 1);

			subArr[findIndex(outChar)]--;
			subArr[findIndex(inChar)]++;

			if (checkDNA(subArr)) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static int findIndex(char c) {
		int ans = 0;
		switch (c) {
		case 'A':
			ans = 0;
			break;
		case 'C':
			ans = 1;
			break;
		case 'G':
			ans = 2;
			break;
		case 'T':
			ans = 3;
			break;
		}

		return ans;
	}

	private static boolean checkDNA(int[] arr) {
		if (arr[0] < checkArr[0] || arr[1] < checkArr[1] || arr[2] < checkArr[2] || arr[3] < checkArr[3]) {
			return false;
		}

		return true;
	}
}
