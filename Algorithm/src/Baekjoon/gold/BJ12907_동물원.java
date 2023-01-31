package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12907
 * 골드5 동물원
 */

public class BJ12907_동물원 {

	static int N, a, check[];
	static int max;
	static int twoCnt = 0;
	static int twice = 1;
	static boolean flag = true;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new int[41];
		max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a = Integer.parseInt(st.nextToken());
			max = Math.max(a, max);
			check[a]++;
		}

		for (int i = 0; i < 40; i++) {
			if (check[i] >= 3 || check[i] < check[i + 1]) {
				flag = false;
				break;
			}

			if (check[i] == 2) {
				twoCnt++;
			}

			if (check[max] == 1) {
				twice = 2;
			}
		}

		double ans = Math.pow(2, twoCnt) * twice;

		if (flag) {
			System.out.println((int)ans);
		} else {
			System.out.println(0);
		}
	}

}
