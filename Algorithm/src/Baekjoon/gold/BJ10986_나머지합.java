package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10986
 * 골드3 나머지 합
 */

public class BJ10986_나머지합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long S[] = new long[N];
		long C[] = new long[M];
		long ans = 0;

		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			S[i] = a + S[i - 1];
		}

		/*
		 * ( S[i] - S[j] ) % M = 0 
		 * ( S[i] % M ) - ( S[j] % M ) = 0 
		 * ( S[i] % M ) = ( S[j] % M )
		 * 누적합의 값이 같다면 나머지가 0이 되는 경우다.
		 */

		for (int i = 0; i < N; i++) {
			int remain = (int) (S[i] % M);
			System.out.println(remain);
			if (remain == 0) {
				ans++;
			}

			C[remain]++;
		}

		// 조합 nC2 = n * n-1 / 2
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				ans += (C[i] * (C[i] - 1) / 2);
			}
		}

		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(C));
		System.out.println(ans);
	}

}
