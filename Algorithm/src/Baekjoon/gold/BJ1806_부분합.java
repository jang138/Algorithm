package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1806
 * 골드4 부분합
 */

public class BJ1806_부분합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int array[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int length = Integer.MAX_VALUE;

		while (true) {
			if (sum >= S) {
				sum -= array[start];
				length = Math.min(end - start, length);
				start++;
			} else if (end == N) {
				break;
			} else {
				sum += array[end++];
			}

			System.out.println(start + " " + end + " " + sum + " " + length);

		}

		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}

}
