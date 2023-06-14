package Baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/12852
 * 실버1 1로 만들기2
 */

public class BJ12852_1로만들기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int memoi[] = new int[N + 1];
		int before[] = new int[N + 1];
		
		/*
		 * memoi[i] : i가 1로 만들어지는 연산 횟수
		 * before[i] : i가 어떤 숫자를 거쳐왔는지 (i 이전의 수)
		 */

		memoi[1] = 0;
		before[1] = -1;

		for (int i = 2; i <= N; i++) {

			memoi[i] = memoi[i - 1] + 1;
			before[i] = i - 1;

			if (i % 2 == 0 && memoi[i / 2] + 1 < memoi[i]) {
				memoi[i] = memoi[i / 2] + 1;
				before[i] = i / 2;
			}

			if (i % 3 == 0 && memoi[i / 3] + 1 < memoi[i]) {
				memoi[i] = memoi[i / 3] + 1;
				before[i] = i / 3;
			}

		}
		
//		System.out.println(Arrays.toString(memoi));
//		System.out.println(Arrays.toString(before));
		
		System.out.println(memoi[N]);
		
		int now = N;
		
		while(now > 0) {
			System.out.print(now + " ");
			now = before[now];
		}

	}

}
