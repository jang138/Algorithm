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
			int target = arr[i];
			int left = 0;
			int right = N - 1;

			while (left < right) {
				// target은 서로 다른 두 수의 합이어야 한다
				if (arr[left] + arr[right] == target) {
					if (left != i && right != i) {
						ans++;
						break;
					} else if (left == i) {
						left++;
//						System.out.println(left);
//						System.out.println("left 증가");
					} else {
						right--;
//						System.out.println(right);
//						System.out.println("right 감소");
					}
				} else if (arr[left] + arr[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(ans);
	}

}
