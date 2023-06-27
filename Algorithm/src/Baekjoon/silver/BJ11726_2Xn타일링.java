package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/11726
 * 실버3 2xn 타일링
 */

public class BJ11726_2Xn타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N + 1];
		dp[0] = 1; // 아무것도 없는 것도 경우의 수 하나로 친다
		dp[1] = 1;

		/*
		 * i번째 타일 경우의 수 = (i-1)번째 타일에서 l 타일 하나씩 추가 + (i-2)번째 타일에서 二 타일 하나씩 추가
		 */

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
