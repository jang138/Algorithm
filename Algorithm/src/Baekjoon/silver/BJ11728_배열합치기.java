package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int A[] = new int[N];
		int B[] = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int indexA = 0;
		int indexB = 0;
		boolean flag;

		while (true) {
			if (indexA >= N) {
				flag = false;
				break;
			}

			if (indexB >= M) {
				flag = true;
				break;
			}

			if (A[indexA] <= B[indexB]) {
				sb.append(A[indexA]).append(" ");
				indexA++;
			} else {
				sb.append(B[indexB]).append(" ");
				indexB++;
			}
		}

		if (flag) {
			for (int i = indexA; i < N; i++) {
				sb.append(A[i]).append(" ");
			}
		} else {
			for (int i = indexB; i < M; i++) {
				sb.append(B[i]).append(" ");
			}
		}

		System.out.println(sb);
	}

}
