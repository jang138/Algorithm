package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seq[] = new int[N];
		int leftDp[] = new int[N];
		int rightDp[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i]) {
					max = Math.max(max, leftDp[j]);
				}
			}

			leftDp[i] = max + 1;
		}

		for (int i = N - 1; i >= 0; i--) {
			int max = 0;

			for (int j = N - 1; j > i; j--) {
				if (seq[j] < seq[i]) {
					max = Math.max(max, rightDp[j]);
				}
			}

			rightDp[i] = max + 1;
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, leftDp[i] + rightDp[i] - 1);
		}

		System.out.println(Arrays.toString(leftDp));
		System.out.println(Arrays.toString(rightDp));
		System.out.println(ans);

	}

}
