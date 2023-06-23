package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12919
 * 골드5 A와 B 2
 */

public class BJ12919_A와B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		StringBuilder S = new StringBuilder();
		StringBuilder T = new StringBuilder();
		S.append(s);
		T.append(t);


		System.out.println(S.toString().equals(T.toString()) ? 1 : 0);
	}

	
}
