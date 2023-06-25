package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1120_문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		int cnt = 0;

		if (A.length() == B.length()) {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == B.charAt(i)) {
					cnt++;
				}
			}

			System.out.println(cnt);
			
		} else {
			for (int i = 0; i < A.length(); i++) {
				for (int j = i; j < A.length(); j++) {
					String str = A.substring(i, j);
					
					if(str.contains(B)) {
						
					}
				}
			}
		}
	}

}
