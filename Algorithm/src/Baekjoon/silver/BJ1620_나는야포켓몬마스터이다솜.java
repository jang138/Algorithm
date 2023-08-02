package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1620
 * 실버4 나는야 포켓몬 마스터 이다솜
 */

public class BJ1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 문자열 검색용 hashmap과 정수 검색용 string array를 만든다
		HashMap<String, Integer> hashMap = new HashMap<>();
		String array[] = new String[N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			hashMap.put(name, i);
			array[i] = name;
		}

		for (int i = 0; i < M; i++) {
			String answer = br.readLine();

			if (isNumber(answer)) {
				int index = Integer.parseInt(answer);
				sb.append(array[index]).append("\n");
			} else {
				sb.append(hashMap.get(answer)).append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

}
