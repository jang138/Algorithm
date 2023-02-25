package Baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/16400
 * 골드5 소수 화폐
 */

public class BJ16400_소수화폐 {

	static boolean prime[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		prime = new boolean[N + 1];

		Arrays.fill(prime, true);
		// 소수는 true 아니면 false
		prime[0] = prime[1] = false;

		// 에라토스테네스의 채
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				prime[j] = false;
			}
		}
		
		for (int i = 0; i <= N; i++) {
			if(prime[i])
				System.out.println(i);
		}
		
		

	}

}
