package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2018
 * 실버5 수들의 합5
 */

public class BJ2018_수들의합5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 1;
		int left = 1;
		int right = 1;
		int sum = 1;

		while (right != N) {
			if (sum == N) {
				cnt++;
				right++;
				sum += right;
			} else if (sum > N) {
				sum -= left;
				left++;
			} else {
				right++;
				sum += right;
			}
		}
		
		System.out.println(cnt);
	}

}
