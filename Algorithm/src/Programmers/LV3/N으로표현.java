package Programmers.LV3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * LV3 N으로 표현
 */

/*
 * 5 12
 * 2 11
 */

public class N으로표현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int number = sc.nextInt();

		int answer = solution(N, number);
		System.out.println(answer);

	}

	private static int solution(int N, int number) {

		ArrayList<HashSet<Integer>> arrayList = new ArrayList<>();

		for (int i = 0; i <= 8; i++) {
			arrayList.add(new HashSet<>());
		}

		arrayList.get(1).add(N);

		for (int i = 2; i <= 8; i++) {
			for (int j = 1; j < i; j++) {
				HashSet<Integer> preSet = arrayList.get(j);
				HashSet<Integer> postSet = arrayList.get(i - j);

				for (int preN : preSet) {
					for (int postN : postSet) {
						arrayList.get(i).add(preN + postN);
						arrayList.get(i).add(preN - postN);
						arrayList.get(i).add(preN * postN);

						if (postN != 0)
							arrayList.get(i).add(preN / postN);

					}
				}
			}

			String st = "";
			for (int k = 0; k < i; k++) {
				st += Integer.toString(N);
			}
			arrayList.get(i).add(Integer.parseInt(st));
		}

		for (int i = 1; i <= 8; i++) {
			for (int target : arrayList.get(i)) {
				if (target == number) {
					return i;
				}
			}

		}

		return -1;
	}

}
