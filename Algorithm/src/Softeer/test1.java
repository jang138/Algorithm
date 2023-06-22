package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플레이리스트 셔플
 * 첫째줄 노래수 n과 노래 배열 m개
 * (n은 2이상 m은 n이상 시간초과 날 정도로 입력)
 * 
 * 4 7
 * 1 2 3 4 1 2 3
 * 4
 * 
 * 4 9
 * 1 4 1 4 2 3 2 3 4
 * 1
 * 
 * 4 11
 * 1 2 3 4 1 2 2 1 3 4 2
 * 1
 * 
 */

public class test1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a[] = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
	}
}