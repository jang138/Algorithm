package test1;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++) {
				sb.append(" ");
			}

			for (int j = 1; j <= i; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
