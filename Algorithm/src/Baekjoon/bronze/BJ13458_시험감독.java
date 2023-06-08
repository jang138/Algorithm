package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13458
 * 브론즈2 시험 감독
 */

public class BJ13458_시험감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		long answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			answer += 1;

			if (array[i] <= first) {
				continue;
			}

			int mod = array[i] - first;

			if (mod % second == 0) {
				answer += (mod / second);
			} else {
				answer += ((mod / second) + 1);
			}
		}

		System.out.println(answer);
	}

}
