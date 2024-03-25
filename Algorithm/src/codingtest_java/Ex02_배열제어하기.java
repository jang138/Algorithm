package codingtest_java;

import java.util.Arrays;
import java.util.TreeSet;

// Original

public class Ex02_배열제어하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 4, 2, 2, 1, 1, 3 })));
		System.out.println(Arrays.toString(solution(new int[] { 2, 2, 3, 3, 4, 4, 5, -1, -1 })));
	}

	private static int[] solution(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));
		for (int i : arr) {
			set.add(i);
		}

		int[] result = new int[set.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = set.pollFirst();
		}
		
		return result;
	}

}
