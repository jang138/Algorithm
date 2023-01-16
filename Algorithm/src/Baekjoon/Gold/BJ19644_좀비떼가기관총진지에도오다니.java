package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19644
 * 골드4 좀비 떼가 기관총 진지에도 오다니
 */

public class BJ19644_좀비떼가기관총진지에도오다니 {
	
	static int L, ML, MK, C;
	static int[] zombie;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		L = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ML = Integer.parseInt(st.nextToken());
		MK = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		
		zombie = new int[L];
		for (int i = 0; i < L; i++) {
			zombie[i] = Integer.parseInt(br.readLine());
			System.out.println(zombie[i]);
		}
		
		boolean ans = true;
		
		
		
	}

}
