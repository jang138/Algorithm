package Baekjoon.gold;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/15668
 * 골드4 방 번호
 */

/*
 * A와 B가 있을 때, A < B 인 경우
 * A는 최대 5자리, 그리고 87654가 제일 큰 수가 된다. (스티커는 0~9가 있으므로 5자리씩 나누고, 맨 앞자리가 9가 되면 B보다 커지므로)
 */

public class BJ15668_방번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int a = 1; a <= 87654 && a < N; a++) {
			int b = N - a;
			
			String strA = Integer.toString(a);
			String strB = Integer.toString(b);
			String newStr = strA + strB;
			String funcStr = refine(newStr);
			
			if(newStr.length() == funcStr.length()) {
				System.out.println(strA + " + " + strB);
				return;
			}
		}
		
		System.out.println(-1);

	}
	
	static String refine(String str) {
		String ans = "";
		
		char[] cArr = str.toCharArray();
		for (char c : cArr) {
			if(!ans.contains(String.valueOf(c))) {
				ans += c;
			}
		}
		
		return ans;
	}

}
