package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17352
 * 골드5 여러분의 다리가 되어 드리겠습니다!
 */

public class BJ17352_여러분의다리가되어드리겠습니다 {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		System.out.println(Arrays.toString(parent));


		for (int i = 2; i <= N; i++) {
			if (!isSameParent(1, i)) {
				System.out.print(1 + " " + i);
				return;
			}
		}

	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static boolean isSameParent(int a, int b) {
		return find(a) == find(b);
	}

}
