package algoExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day230120_조합 {
	static int N, R;
	static int[] input, numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		numbers = new int[R]; // 순열 저장 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0); 
	}
	
	static void combination(int cnt, int start) {
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
		}
	}

}
