package Baekjoon.gold;

import java.util.Scanner;

public class BJ1038_교환 {

	static int N, K, length;
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		length = (int) (Math.log10(N) + 1);

		visit = new boolean[1000000][K + 1];
	}

}
