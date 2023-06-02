package Baekjoon.silver;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1748
 * 실버4 수 이어 쓰기 1
 */

public class BJ1748_수이어쓰기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0; // 합
		int plus = 1; // 더해야하는 자리 수
		int remain = 10; // 자리 수가 바뀌는 분기점

		for (int i = 1; i <= N; i++) {
			// i가 10, 100, 1000... 이 되는 경우 자리 수가 바뀐다
			if(i % remain == 0) {
				plus++; // 자리수 1 증가
				remain *= 10; // 다음에 자리수가 바뀌는 분기점
			}
			
			ans += plus;
		}

		System.out.println(ans);

	}

}
