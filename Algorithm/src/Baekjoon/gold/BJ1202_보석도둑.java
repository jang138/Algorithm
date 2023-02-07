package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1202_보석도둑 {
	
	static int N, K;
	static int[][] jewel;
	static int[] bag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewel = new int[N][2];
		bag = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				jewel[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		
	}

}
