package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2644
 * 실버2 촌수계산
 */

public class BJ2644_촌수계산_dfs {

	static int N, A, B, M;
	static int family[][];
	static int chon[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		family = new int[N + 1][N + 1];
		chon = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = family[y][x] = 1;
		}

		dfs(A);

		System.out.println(chon[B] == 0 ? -1 : chon[B]);

	}

	private static void dfs(int num) {
		if (num == B) {
			return;	
		}

		for (int i = 1; i <= N; i++) {
			if (family[num][i] == 1 && chon[i] == 0) {
				chon[i] = chon[num] + 1;
				dfs(i);
			}

		}

	}

}

/*
 * dfs의 매개변수를 num과 cnt를 정의하고 재귀할때마다 dfs(i, cnt+1)로 한다
 * 그리고 조건에 걸리면 chon = cnt로 카운트를 넘겨줘서 풀어도 될듯
 */
