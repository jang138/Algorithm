package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1924
 * 브론즈1 2007년
 */

public class BJ1924_2007년 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int daySum = 0;
		int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String dayOfWeek[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		for (int i = 0; i < x; i++) {
			daySum += month[i];
		}

		daySum += y;

		System.out.println(dayOfWeek[daySum % 7]);
	}

}
