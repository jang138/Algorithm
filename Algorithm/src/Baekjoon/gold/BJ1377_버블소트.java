package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/1377
 * 골드2 버블 소트
 */

public class BJ1377_버블소트 {

	public static class Element {
		int value;
		int index;

		public Element(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		public String toString() {
			return value + " " + index;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Element> arrayList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arrayList.add(new Element(Integer.parseInt(br.readLine()), i));
		}

		Collections.sort(arrayList, (Element o1, Element o2) -> {
			return o1.value - o2.value;
		});
		
//		System.out.println(arrayList);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arrayList.size(); i++) {
			Element e = arrayList.get(i);
			max = Math.max(max, e.index - i);
		}
		
		System.out.println(max + 1);
		

	}
}