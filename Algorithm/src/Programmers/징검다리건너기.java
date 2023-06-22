package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
 * 징검다리 건너기
 * 
 * input
 * 10 3
 * [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
 * output
 * 3
 */

public class 징검다리건너기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int stones[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(stones, K);
		
		System.out.println(answer);
	}

	private static int solution(int[] stones, int k) {

		
		
		return 0;
	}
}
