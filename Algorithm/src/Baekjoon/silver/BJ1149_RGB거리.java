package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N + 1][3];

		// 점화식: dp[i][j] ( i는 n번째 집, j는 R G B 색상 중 하나(0 1 2) )
		// j 0 을 선택한 경우 1과 2 중 작은 값을 더함
		// dp[i][R] = 현재 i의 값을 Red로 칠하기로 결정한 경우 => i-1의 G와 B 중 최소값과 더한다
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N][i]);
		}
		
//		System.out.println(Arrays.deepToString(dp));
		System.out.println(min);
	}

}
