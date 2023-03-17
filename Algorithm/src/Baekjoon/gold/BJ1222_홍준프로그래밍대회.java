package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1222
 * 골드2 홍준 프로그래밍 대회
 */

/*
 * 팀원을 이루는 학생 수가 K인 경우 K의 배수에 해당되는 학교만 참가한다
 * 그 학교 수 * K 의 값이 제일 큰 수가 정답
 */

public class BJ1222_홍준프로그래밍대회 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 학생 수가 N인 학교의 수
		int[] student = new int[2000001];

		// 최대인 학생 수
		int max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			student[a]++;
		}

		long ans = 0;

		for (int i = 1; i <= max; i++) {
			// 팀원 수를 i로 했을 때 본선 진출 팀
			int cnt = 0;

			// i의 배수들 더하기
			for (int j = i; j <= max; j += i) {
				cnt += student[j];
			}

			if (cnt < 2) {
				continue; // 본선에 참가할 수 있는 팀이 2팀 이하인 경우
			}

			// 학생수 = 각 팀을 구성하는 학생 수 * 대회참여가 가능한 학교 수
			ans = Math.max(ans, (long) cnt * (long) i); 
		}

		System.out.println(ans);

	}

}
