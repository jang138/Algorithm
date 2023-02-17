package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1727
 * 골드2 커플 만들기
 */

public class BJ1727_커플만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] male = new int[N + 1];
		int[] female = new int[M + 1];
		int[][] dp = new int[N + 1][M + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			male[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(male);

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			female[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(female);

		// 1. 남녀 수가 같은 경우 어떤 경우로 짝지어도 성격차의 합은 같다 => dp[i][j] = dp[i-1][j-1] + i남과 j녀의 차이
		// 2. 남녀 수가 다르다면?? 남은 마지막 사람이 커플이 된 경우 or 안된 경우 => 이 둘중에 최소값 비교
		// 3. 남은 사람이 커플이 된 경우 => 1과 같다
		// 4. 남은 사람이 커플이 안된 경우 => dp[i][j] = dp[i-1][j] 

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i == j)
					dp[i][j] = dp[i - 1][j - 1] + Math.abs(male[i] - female[j]);
				else if (i > j)
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + Math.abs(male[i] - female[j]));
				else if (i < j)
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(male[i] - female[j]));
			}
		}

//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N][M]);
	}

}
