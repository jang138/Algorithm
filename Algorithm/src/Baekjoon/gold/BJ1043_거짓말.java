package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1043
 * 골드4 거짓말
 */

public class BJ1043_거짓말 {

	static int[] partyPeople;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] truthPeople = new boolean[N + 1];
		partyPeople = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			partyPeople[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int truthCnt = Integer.parseInt(st.nextToken());

		// 진실을 아는 사람이 0일 경우 => 모든 파티에서 마음껏 거짓말 가능
		if (truthCnt == 0) {
			System.out.println(M);
			return;
		}

		for (int i = 0; i < truthCnt; i++) {
			truthPeople[Integer.parseInt(st.nextToken())] = true;
		}

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < partyCnt; j++) {
				arr.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < M; i++) {
			System.out.println(arr.get(i));

			if (arr.get(i).size() == 0)
				continue;

			int A = arr.get(i).get(0);
			for (int j = 1; j < arr.get(i).size(); j++) {
				int B = arr.get(i).get(j);
				if (find(A) != find(B)) {
					union(A, B);
				}
			}

		}

		System.out.println(Arrays.toString(truthPeople));
		System.out.println(Arrays.toString(partyPeople));

		boolean visit[] = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (truthPeople[i] && !visit[i]) {
				int root = find(i);
				for (int j = 1; j <= N; j++) {
					if (find(j) == root) {
						truthPeople[j] = true;
						visit[j] = true;
					}

				}
			}
		}

		System.out.println(Arrays.toString(truthPeople));
		int ans = M;
		for (int i = 0; i < M; i++) {
			for (int a : arr.get(i)) {
				if (truthPeople[a]) {
					ans--;
					break;
				}
			}
		}

		System.out.println(ans);

	}

	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);

		if (A != B) {
			if (A > B)
				partyPeople[A] = B;
			else
				partyPeople[B] = A;
		}
	}

	public static int find(int a) {
		if (partyPeople[a] == a)
			return a;

		return partyPeople[a] = find(partyPeople[a]);
	}

}
