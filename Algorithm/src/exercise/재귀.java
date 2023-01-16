package exercise;

import java.util.Scanner;

public class 재귀 {
	static int K = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		recursion(N);

	}
	static void recursion(int n) {
		int k = K;
		
		if(n==0) {
			System.out.println(n + " finish " + k);
			return;
		}
		
		System.out.println(n + " previous count " + k);
		
		K += 1;
		
		recursion(n-1);
		
		System.out.println(n + " next count " + k);
	}

}
