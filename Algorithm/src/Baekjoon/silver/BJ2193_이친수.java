package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2193
 * 실버3 이친수
 */

public class BJ2193_이친수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long bin[] = new long[91];
		bin[0] = 0;
		bin[1] = 1;
		bin[2] = 1;

		for (int i = 3; i < 91; i++) {
			bin[i] = bin[i - 1] + bin[i - 2];
		}
		
		System.out.println(bin[N]);

	}

}
