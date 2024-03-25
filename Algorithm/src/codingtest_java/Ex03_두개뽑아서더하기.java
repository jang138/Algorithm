package codingtest_java;

import java.util.Arrays;
import java.util.TreeSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644

public class Ex03_두개뽑아서더하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 2, 1, 3, 4, 1 })));
		System.out.println(Arrays.toString(solution(new int[] { 5, 0, 2, 7 })));
	}

	private static Integer[] solution(int[] numbers) {
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		Integer[] answer = set.toArray(new Integer[0]);
		return answer;
	}

}
