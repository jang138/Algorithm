package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1253
 * 골드4 좋다
 */

public class BJ1253_좋다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			int target = arr[i];

			while (true) {
				// 현재 숫자와 같으면 안되니까 바로 통과
				if (left == i)
					left++;
				else if (right == i)
					right--;

				if (left >= right) // 탐색 실패
					break;

				int sum = arr[left] + arr[right];

				if (sum > target)
					right--;
				else if (sum < target)
					left++;
				else {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
