package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/5430
 * 골드5 AC
 */

public class BJ5430_AC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				System.out.println(Integer.parseInt(st.nextToken()));
			}
		}
		
	}
	

}
