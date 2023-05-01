package Baekjoon.gold;

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
		
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[n];
		
		for (int i = 0; i < n; i++) {
			// 스택이 비어있지 않고, 스택의 top의 값이 현재 값보다 작은 경우 => 오큰수!
			while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
				ans[stack.pop()] = a[i];
			}
			
			stack.push(i);
		}
		
		// 반복문 후에도 스택에 값이 남아있음 => 오큰수가 없다 -1 출력
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}

