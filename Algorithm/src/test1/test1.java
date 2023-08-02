package test1;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < 2 * N - 1; i++) {
			System.out.println(i);
		}
	}

}