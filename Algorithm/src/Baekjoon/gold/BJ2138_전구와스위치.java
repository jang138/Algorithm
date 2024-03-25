package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2138_전구와스위치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input1 = br.readLine();
		String input2 = br.readLine();

		int A[] = new int[N];
		int target[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = input1.charAt(i) - '0';
			target[i] = input2.charAt(i) - '0';
		}

	}

}
