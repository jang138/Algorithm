package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/2036
 * 골드4 수열의 점수
 */

public class BJ2036_수열의점수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long ans = 0;

		// 수열을 양수, 음수, 1로 나눈다 ==> 양수X양수, 음수X음수로 최대값을 만들기 위함, 1은 더하는게 이득
		ArrayList<Long> plus = new ArrayList<Long>();
		ArrayList<Long> minus = new ArrayList<Long>();
		ArrayList<Long> one = new ArrayList<Long>();

		for (int i = 0; i < n; i++) {
			long num = Integer.parseInt(br.readLine());
			if (num > 1)
				plus.add(num);
			else if (num <= 0)
				minus.add(num);
			else if (num == 1)
				one.add(num);
		}

		// 절대값이 큰 순서로 정렬 (양수는 내림차순, 음수는 오름차순)
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);

		// 짝수인 경수
		if (plus.size() % 2 == 0) {
			for (int i = 0; i < plus.size(); i += 2) {
				ans = ans + (plus.get(i) * plus.get(i + 1));
			}
		}

		// 음수인 경우
		else if (plus.size() % 2 != 0) {
			for (int i = 0; i < plus.size() - 1; i += 2) {
				ans = ans + (plus.get(i) * plus.get(i + 1));
			}
			// 마지막 남는 것 계산
			ans = ans + plus.get(plus.size() - 1);
		}

		// 짝수인 경우
		if (minus.size() % 2 == 0)
			for (int i = 0; i < minus.size(); i += 2) {
				ans = ans + (minus.get(i) * minus.get(i + 1));
			}

		// 음수인 경우
		else if (minus.size() % 2 != 0) {
			for (int i = 0; i < minus.size() - 1; i += 2) {
				ans = ans + (minus.get(i) * minus.get(i + 1));
			}
			// 마지막 남는 것 계산
			ans = ans + minus.get(minus.size() - 1);
		}

		// 남은 1들을 더해준다
		ans = ans + one.size();
		System.out.println(ans);
	}
}
