package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/1874
 * 실버2 스택 수열
 */

public class BJ1874_스택수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int number = 1;
		boolean flag = true;
		for (int target : array) {
			if (target >= number) {
				while (target >= number) {
					stack.push(number);
					number++;
					sb.append("+\n");
				}

				stack.pop();
				sb.append("-\n");
			} else {
				int n = stack.pop();

				if (target < n) {
					System.out.println("NO");
					flag = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}

		if (flag)
			System.out.println(sb);

	}

}
