package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/1918
 * 골드2 후위 표현식
 */

public class BJ1918_후위표현식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {

			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
				break;

			case '(':
				stack.push('(');
				break;

			case ')':
				while (!stack.isEmpty()) {
					char pop = stack.pop();
					if (pop == '(') {
						break;
					}
					sb.append(pop);
				}
				break;

			default:
				sb.append(c);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}

	private static int priority(char op) {
		if (op == '(' || op == ')') {
			return 0;
		} else if (op == '+' || op == '-') {
			return 1;
		} else if (op == '*' || op == '/') {
			return 2;
		}

		return -1;
	}

}
