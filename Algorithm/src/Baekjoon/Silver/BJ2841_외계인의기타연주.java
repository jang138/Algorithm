package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2841_외계인의기타연주 {
	
	static int N, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 음
		P = Integer.parseInt(st.nextToken()); // 프렛

		Stack<Integer>[] line = new Stack[7];
		
		for (int i = 1; i <= 6; i++) {
			line[i] = new Stack<Integer>();
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
		}
		

	}

}
