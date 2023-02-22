package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16432
 * 골드4 떡장수와 호랑이
 */

public class BJ16432_떡장수와호랑이 {

	static int N;
	static int[] result;
	static boolean find;
	static boolean[][] graph;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		result = new int[N];
		graph = new boolean[N][10];
		visit = new boolean[N][10]; // n번째 날에 i번의 떡을 가지고 있는 경우를 체크

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int n = 0; n < num; n++) {
				graph[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

		find = false;
		dfs(0, -1);

		StringBuilder sb = new StringBuilder();

		if (find) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i] + " ");
			}
			System.out.println(sb.toString());
		} else {
			System.out.println(-1);
		}

	}

	static void dfs(int depth, int previousNum) {
		if (find == true) {
			return;
		}

		if (depth == N) {
			find = true;
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (graph[depth][i] == true && i != previousNum && visit[depth][i] == false && find == false) {
				result[depth] = i;
				visit[depth][i] = true;
				dfs(depth + 1, i);
			}
		}
	}
}
