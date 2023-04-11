package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/25367
 * 골드3 너무 시시했다
 */

/*
 *  XOR: a^b = (a+b) - 2*(a&b)
 */

public class BJ25367_너무시시했다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long Q = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (Q != 0) {
			Q--;
			st = new StringTokenizer(br.readLine(), " ");
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			int cnt = 0;

			if (x - y % 2 == 1) {
				System.out.println(cnt);
				continue;
			}

			for (int a = 1; a < x; a++) {
				long b = x - a;

				long and = a & b;

				if (2 * and == x - y) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		/*
		 * for (int i = 0; i < Q; i++) { st = new StringTokenizer(br.readLine(), " ");
		 * long x = Integer.parseInt(st.nextToken()); long y =
		 * Integer.parseInt(st.nextToken()); int cnt = 0;
		 * 
		 * if(x-y % 2 == 1) { System.out.println(cnt); continue; }
		 * 
		 * for (int a = 1; a < x; a++) { long b = x - a;
		 * 
		 * long and = a & b;
		 * 
		 * if (2 * and == x - y) { cnt++; } }
		 * 
		 * sb.append(cnt).append("\n");
		 * 
		 * }
		 */

		System.out.println(sb.toString());
	}

}
