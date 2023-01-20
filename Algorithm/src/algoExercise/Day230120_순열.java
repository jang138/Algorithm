package algoExercise;

/*
 * 입력 
 * nPr, input 배열
3 2
1 2 3
 * 
 * 출력
[1, 2]
[1, 3]
[2, 1]
[2, 3]
[3, 1]
[3, 2]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day230120_순열 {
	static int N, R;
	static int[] input, numbers;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		numbers = new int[R]; // 순열 저장 배열
		selected = new boolean[N + 1]; // 해당 숫자가 선택되었는지 저장하는 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		permutation(0);
	}

	static void permutation(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 입력받은 모든 수를 현재 자리에 넣어본다
		for (int i = 1; i <= N; i++) {
			// 기존 자리와 중복 체크
			if (selected[i] == true)
				continue;

			numbers[cnt] = i;
			selected[i] = true;

			// 다음 자리 수 뽑기
			permutation(cnt + 1);

			// 한 순열을 number에 저장한 뒤 다시 false로 초기화
			selected[i] = false;
		}
	}

}
