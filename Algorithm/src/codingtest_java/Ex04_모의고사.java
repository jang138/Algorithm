package codingtest_java;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840

public class Ex04_모의고사 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2 })));
	}

	private static int[] solution(int[] answers) {
		int pattern[][] = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		int[] count = new int[3];

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (answers[i] == pattern[j][i % pattern[j].length])
					count[j]++;
			}
		}

		int maxScore = 0;
		for (int i = 0; i < count.length; i++) {
			maxScore = Math.max(maxScore, count[i]);
		}

		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < count.length; i++) {
			if (maxScore == count[i])
				arrayList.add(i + 1);
		}

		return arrayList.stream().mapToInt(Integer::intValue).toArray();
	}
}
