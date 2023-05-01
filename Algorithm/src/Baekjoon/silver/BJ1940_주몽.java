package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1940
 * 실버4 주몽
 */

public class BJ1940_주몽 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int input[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		int cnt = 0;
		int left = 0;
		int right = N - 1;

		while (left < right) {
			int sum = input[left] + input[right];

			if (sum < M) {
				left++;
			} else if (sum > M) {
				right--;
			} else {
				cnt++;
				left++;
				right--;
			}
		}

		 System.out.println(cnt);
	}

}
