package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19539
 * 골드5 사과나무
 */

public class BJ19539_사과나무 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0; // 전체 합
		int cnt = 0; // 2를 사용할 수 있는 횟수 합

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			int atwo = a / 2;
			sum += a;
			cnt += atwo;
		}

		if (sum % 3 == 0 && cnt >= sum / 3) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
