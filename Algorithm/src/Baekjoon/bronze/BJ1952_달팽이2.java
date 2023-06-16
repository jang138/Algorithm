package Baekjoon.bronze;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1952
 * 브론즈1 달팽이2
 */

public class BJ1952_달팽이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int cnt = 1;
		boolean flag = true;
		
		while(true) {
			if(M == 1 || N == 1) {
				break;
			}
			
			if(flag) {
				M -= 1;
			} else {
				N -= 1;
			}
			
			flag = !flag;
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
