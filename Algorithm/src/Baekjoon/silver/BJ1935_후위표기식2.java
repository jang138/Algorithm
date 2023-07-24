package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] array = new int[N + 1];

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> stack = new Stack<>();
		stack.add((double) (str.charAt(0) - 65));
		
		while(!stack.isEmpty()) {
			
		}
		

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			double toInt = str.charAt(i) - 65;
			double A, B;

			if (c == '*') {
				B = stack.pop();
				A = stack.pop();
				stack.add(A * B);
			} else if (c == '/') {
				B = stack.pop();
				A = stack.pop();
				stack.add(A * B);
			} else if (c == '+') {
				B = stack.pop();
				A = stack.pop();
				stack.add(A + B);
			} else if (c == '-') {
				B = stack.pop();
				A = stack.pop();
				stack.add(A - B);
			} else {
				stack.add(toInt);
			}
		}

		double answer = stack.pop();
		System.out.println(String.format("%.2f", answer));
	}

}
