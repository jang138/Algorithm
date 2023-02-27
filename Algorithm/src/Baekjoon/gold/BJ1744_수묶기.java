package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * https://www.acmicpc.net/problem/1744
 * 골드4 수 묶기
 */

public class BJ1744_수묶기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 수열을 양수, 음수, 1로 나눈다 ==> 양수X양수, 음수X음수로 최대값을 만들기 위함, 1은 더하는게 이득
		ArrayList<Long> posNum = new ArrayList<Long>();
		ArrayList<Long> negNum = new ArrayList<Long>();
		ArrayList<Long> one = new ArrayList<Long>();

		for (int i = 0; i < n; i++) {
			long num = Integer.parseInt(br.readLine());
			if (num > 1)
				posNum.add(num);
			else if (num <= 0)
				negNum.add(num);
			else if (num == 1)
				one.add(num);
		}

		// 절대값이 큰 순서로 정렬 (양수는 내림차순, 음수는 오름차순)
		posNum.sort(Comparator.reverseOrder());
		negNum.sort(Comparator.naturalOrder());

		// 양수계산
		long posNumSum = 0;

		// 짝수인 경수
		if (posNum.size() % 2 == 0) {
			for (int i = 0; i < posNum.size(); i += 2) {
				posNumSum = posNumSum + (posNum.get(i) * posNum.get(i + 1));
			}
		}

		// 음수인 경우
		else if (posNum.size() % 2 != 0) {
			for (int i = 0; i < posNum.size() - 1; i += 2) {
				posNumSum = posNumSum + (posNum.get(i) * posNum.get(i + 1));
			}
			// 마지막 남는 것 계산
			posNumSum = posNumSum + posNum.get(posNum.size() - 1);
		}

		// 음수계산
		long negNumSum = 0;

		// 짝수인 경우
		if (negNum.size() % 2 == 0)
			for (int i = 0; i < negNum.size(); i += 2) {
				negNumSum = negNumSum + (negNum.get(i) * negNum.get(i + 1));
			}

		// 음수인 경우
		else if (negNum.size() % 2 != 0) {
			for (int i = 0; i < negNum.size() - 1; i += 2) {
				negNumSum = negNumSum + (negNum.get(i) * negNum.get(i + 1));
			}
			// 마지막 남는 것 계산
			negNumSum = negNumSum + negNum.get(negNum.size() - 1);
		}

		// 남은 1들을 더해준다
		long ans = posNumSum + negNumSum + one.size();
		System.out.println(ans);
	}
}
