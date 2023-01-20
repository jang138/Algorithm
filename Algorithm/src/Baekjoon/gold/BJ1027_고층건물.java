package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1027_고층건물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N];
		int ans = 0;
		boolean[][] check = new boolean[N][N];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		for (int i = 0; i < N; i++) {
			long tx = 1;
			long ty = -1000000001;
			int cnt = 0;

			for (int j = i + 1; j < N; j++) {
				long dx = j - i;
				long dy = arr[j] - arr[i];

				if (ty * dx < dy * tx) {
					tx = dx;
					ty = dy;
					check[i][j] = true;
					cnt++;
				}
			}

			for (int j = 0; j < i; j++) {
				if (check[j][i])
					cnt++;
			}

			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}
}
