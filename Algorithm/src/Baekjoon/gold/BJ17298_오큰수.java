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
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] NGE = new int[N];
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			/*
			 * 스택이 비어있지 않고, 현재 원소가 스택 맨 위의 원소보다 큰 경우 오큰수의 조건을 만족하므로 가능한 한 계속 pop하면서 stack에
			 * 저장된 인덱스에 해당하는 원소를 현재 원소(오큰수)로 바꾸어 준다.
			 */
			while (!stack.isEmpty() && A[stack.peek()] < A[i])
				NGE[stack.pop()] = A[i];

			stack.push(i);
		}

		while (!stack.isEmpty())
			NGE[stack.pop()] = -1;

		for (int n : NGE) {
			sb.append(n).append(" ");
		}

		System.out.println(sb.toString());

	}
}
