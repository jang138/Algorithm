package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9466
 * 골드3 텀 프로젝트
 */

public class BJ9466_텀프로젝트 {

	static int N, cnt;
	static int[] input;
	static boolean[] visit, done;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			input = new int[N + 1];
			visit = new boolean[N + 1];
			done = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				input[i] = Integer.parseInt(st.nextToken());

				if (input[i] == i) {
					done[i] = true;
					cnt++;
				}
			}

			for (int i = 1; i <= N; i++) {
				if (!done[i]) {
					dfs(i);
				}
			}

			System.out.println(N - cnt);
		}

	}

	private static void dfs(int num) {
		// 이미 방문한 경우 => 사이클!
		if (visit[num]) {
			done[num] = true; // 팀 편성 완료
			cnt++; // 팀 편성이 완료된 사람 수 증가
		} else {
			visit[num] = true; // 아직 방문하지 않은 경우 방문 처리
		}

		int next = input[num];

		if (!done[next]) {
			dfs(next);
		}

		done[num] = true; // 팀은 만들지 못한채로 편성 완료
		visit[num] = false; // 다음 탐색때 필요할 수 있으므로 방문 해제

	}
}
