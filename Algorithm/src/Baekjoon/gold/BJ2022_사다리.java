package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2022
 * 골드5 사다리
 */

public class BJ2022_사다리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());

		double left = 0;
		double right = Math.min(x, y);

		// width 기준 탐색
		while (right - left >= 0.001) {
			double width = (left + right) / 2;
			double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
			double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
			double res = (h1 * h2) / (h1 + h2);

			if (res >= c)
				left = width;
			else
				right = width;
		}
		
		System.out.println(String.format("%.3f", right));
	}
}
