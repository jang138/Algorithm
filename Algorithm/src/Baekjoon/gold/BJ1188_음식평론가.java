package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1188
 * 골드4 음식 평론가
 */

public class BJ1188_음식평론가 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;

		// N과 M의 최대공약수
		int gcd = GCD(N, M);
		N = N / gcd;
		M = M / gcd;

		// 소시지를 자를 필요 없는 경우
		if (N >= M && N % M == 0) {
			System.out.println(0);
		} else {
			ans = M - 1;
			ans = ans * gcd;
			System.out.println(ans);
		}

	}

	// 유클리드 호제법
	static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return GCD(b, a % b);
		}
	}
}
