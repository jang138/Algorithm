package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1669
 */

public class BJ1669 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int diff = y - x;
		
		if (diff == 0) {
		    System.out.println(0);
		    return;
		}
		
		double diff_root = Math.sqrt(diff);
		long round = Math.round(diff_root);

		
		if( diff_root <= (double) round ) {
			System.out.println(round*2 - 1);
		} else {
			System.out.println(round*2);
		}
		
	}

}
