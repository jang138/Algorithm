package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long S[] = new long[N + 1];
		long remainArray[] = new long[M];
		long cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(S));

		/*
		 * S[i] % M 과 S[j] % M 의 값이 같다면 (S[i] - S[j]) % M = 0이다. S[i] % M 으로 배열을 바꾸어준다.
		 * 이때 0이 되는 것은 처음부터 i번째 배열까지 합이 0이라는 의미이다.
		 */

		for (int i = 1; i <= N; i++) {
			int remain = (int) (S[i] % M);
			remainArray[remain]++;

			if (remain == 0)
				cnt++;
		}

		/*
		 * 각 나머지에 해당하는 개수를 remainArray 배열에 저장한다. 이때, 개수가 2 이상이라면 전체 개수에서 2개를 뽑는 것은 누적합
		 * 배열에서 i와 j를 선택해 차이를 구하는 것과 같다. nC2 = n * (n-1) / 2
		 */

		for (int remain = 0; remain < M; remain++) {
			if (remainArray[remain] > 1) {
				cnt += (remainArray[remain] * (remainArray[remain] - 1) / 2);
			}
		}

//		System.out.println(Arrays.toString(remainArray));
		System.out.println(cnt);

	}

}
