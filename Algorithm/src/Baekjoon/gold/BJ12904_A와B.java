package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12904
 * 골드5 A와 B
 */

public class BJ12904_A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		StringBuilder S = new StringBuilder();
		StringBuilder T = new StringBuilder();
		S.append(s);
		T.append(t);

		while (S.length() < T.length()) {
			if (T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			} else if (T.charAt(T.length() - 1) == 'B') {
				T.deleteCharAt(T.length() - 1);
				T.reverse();
			}			
		}

		System.out.println(S.toString().equals(T.toString()) ? 1 : 0);

	}

}
