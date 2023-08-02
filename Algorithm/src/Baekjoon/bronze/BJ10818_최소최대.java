package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10818
 * 브론즈3 최소, 최대
 */

public class BJ10818_최소최대 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N  = Integer.parseInt(st.nextToken());
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			minVal = Math.min(minVal, a);
			maxVal = Math.max(maxVal, a);
		}
		
		System.out.println(minVal + " " + maxVal);
	}

}
