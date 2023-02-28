package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/25635
 * 골드4 자유 이용권
 */

public class BJ25635_자유이용권 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		long sum = 0;
		long largest = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			sum += a;
			largest = Math.max(largest, a);
		}

		long maxVal = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;

		if (maxVal < largest) {
			System.out.println((sum - largest) * 2 + 1);
			return;
		}

		System.out.println(sum);
	}

}
