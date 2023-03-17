package Softeer;

import java.util.Scanner;

public class test {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		char ch = sc.nextLine().charAt(0);

		System.out.println( ch == 'N' || ch == 'n' ? "Naver D2" : "Naver Whale" );
		
	}
}