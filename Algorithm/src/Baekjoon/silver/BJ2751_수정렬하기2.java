package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/2751
 * 실버5 수 정렬하기 2
 */

public class BJ2751_수정렬하기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arrayList.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(arrayList);

		for (int i : arrayList) {
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
