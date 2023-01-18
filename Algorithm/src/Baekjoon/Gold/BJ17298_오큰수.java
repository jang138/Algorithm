package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/17298
 * 골드4 오큰수
 */

public class BJ17298_오큰수 {
	static int N;
	static int[] A, res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		res = new int[N];
		A = new int[N];

		for (int i = 0; i < N; i++)
			res[i] = -1;

		String[] sarr = br.readLine().split(" ");
		Stack<Integer> stack = new Stack<>();

		A[0] = Integer.parseInt(sarr[0]);
		stack.push(0);

		for (int i = 1; i < N; i++) {
			int n = Integer.parseInt(sarr[i]);
			A[i] = n;

			while (!stack.isEmpty() && A[stack.peek()] < n) {
				res[stack.pop()] = n;
			}

			stack.push(i);
		}

		for (int i = 0; i < N; i++)
			bw.write(res[i] + " ");
		bw.flush();

	}
}