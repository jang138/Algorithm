package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1920
 * 실버4 수 찾기
 */

public class BJ1920_수찾기 {

	static int N;
	static int A[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());

			if (binarySearch(target))
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");

		}

		System.out.println(sb);
	}

	private static boolean binarySearch(int target) {
		int start = 0;
		int end = N - 1;

		while (start <= end) {
			int midIndex = (start + end) / 2;

			if (A[midIndex] > target) {
				end = midIndex - 1;
			} else if (A[midIndex] < target) {
				start = midIndex + 1;
			} else {
				return true;
			}
		}

		return false;
	}

}
