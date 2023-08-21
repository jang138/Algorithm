package Programmers.LV2;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * LV2 소수 찾기
 */

public class 소수찾기 {

	public static void main(String[] args) {
		String numbers1 = "17";
		String numbers2 = "011";
		String numbers3 = "9";
		int ans = solution(numbers3);

		System.out.println(ans);
	}

	private static int solution(String numbers) {
		int answer = 0;
		
		int leng = numbers.length();
		boolean prime[] = new boolean[(int) Math.pow(10, leng)];
		primeCheck(prime);
		System.out.println(Arrays.toString(prime));
		
		char arr[] = numbers.toCharArray();
		System.out.println(Arrays.toString(arr));

		return answer;
	}

	private static void primeCheck(boolean[] prime) {
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if (!prime[i]) {
				for (int j = 2 * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
	}

}
