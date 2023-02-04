package algoExercise;

/*
 * 입력 
 * nCr, input 배열
3 2
1 2 3
 * 
 * 출력
[1, 2]
[1, 3]
[2, 3]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1); // 현재 뽑은 i의 다음 숫자부터 시작하도록 전달
		}
	}

}
