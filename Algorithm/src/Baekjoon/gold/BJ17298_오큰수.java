package Baekjoon.gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17298
 * 골드4 오큰수
 */

public class BJ17298_오큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<>();
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() <= a[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = s.peek();
			}
			s.push(a[i]);
		}
		for (int k : ans) {
			sb.append(k + " ");
		}
		
		System.out.print(sb.toString());
	}
}
