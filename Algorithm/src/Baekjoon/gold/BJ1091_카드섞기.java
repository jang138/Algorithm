package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1091
 * 골드4 카드 섞기
 */

public class BJ1091_카드섞기 {

	/*
	 * 1. 0 1 2 0 1 2 ... 형태를 만들어야 한다. 2. 초기값 수열 P를 S의 순서대로 섞는다.
	 */
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i % 3;
		}
		int[] P = new int[N];
		int[] S = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		while (true) {
			// 같은 배열이라면 탈출
			if (isSameArr(arr, P))
				break;

			// 카드 섞기
			int[] temp = new int[N];
			for (int i = 0; i < N; i++) {
				temp[i] = arr[S[i]];
			}
			arr = temp;
			cnt++;

			if (isSameStart(arr)) {
				cnt = -1;
				break;
			}
		}

		System.out.println(cnt);
	}

	// 같은 배열인지 확인
	static boolean isSameArr(int[] A, int[] B) {
		for (int i = 0; i < N; i++) {
			if (A[i] == B[i])
				continue;
			return false;
		}
		return true;
	}

	// 시작 배열인지 확인
	static boolean isSameStart(int[] A) {
		for (int i = 0; i < N; i++) {
			if (A[i] == i % 3)
				continue;
			return false;
		}
		return true;
	}
}