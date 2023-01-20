package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1027_고층건물 {

	static int N;
	static int[] Building;
	static int Answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Building = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			Building[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int count = 0;
			double prev = 0L;

			// 빌딩 왼쪽
			for (int j = i - 1; j >= 0; j--) {
				double tmp = (double) (Building[j] - Building[i]) / (double) (j - i);

				// 기울기가 작아서 보이거나 or 바로 옆 빌딩이라 보이거나
				if (prev > tmp || j == i - 1) {
					count++;
					prev = tmp;
				}
			}

			prev = 0;

			// 빌딩 오른쪽
			for (int j = i + 1; j < N; j++) {
				double tmp = (double) (Building[j] - Building[i]) / (double) (j - i);

				// 기울기가 커서 보이거나 or 바로 옆 빌딩이라 보이거나
				if (prev < tmp || j == i + 1) {
					count++;
					prev = tmp;
				}
			}
			
			Answer = Math.max(count, Answer);
		}

		System.out.println(Answer);
	}
}