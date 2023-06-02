package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1476
 * 실버5 날짜 계산
 */

public class BJ1476_날짜계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int year = 0, e = 0, s = 0, m = 0;

		while (true) {
			year++;
			e++;
			s++;
			m++;

			if (e > 15)
				e = 1;
			if (s > 28)
				s = 1;
			if (m > 19)
				m = 1;

			if (e == E && s == S && m == M)
				break;
		}
		
		System.out.println(year);
	}

}
