package Baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2309
 * 브론즈1 일곱 난쟁이
 */

public class BJ2309_일곱난쟁이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dwarf[] = new int[9];
		int total = 0;
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			total += dwarf[i];
		}

		int target = total - 100;

		Arrays.sort(dwarf);

		int left = 0;
		int right = 8;

		while (true) {
			if (dwarf[left] + dwarf[right] < target) {
				left++;
				continue;
			}
			if (dwarf[left] + dwarf[right] > target) {
				right--;
				continue;
			}

			if (dwarf[left] + dwarf[right] == target) {
				break;
			}

		}

		for (int i = 0; i < 9; i++) {
			if (i == left || i == right) {
				continue;
			}

			System.out.println(dwarf[i]);
		}

	}

}
