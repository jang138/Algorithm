package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long numbers[] = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(numbers);

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			long target = numbers[i];
			int start = 0;
			int end = N - 1;
			long sum = 0;

			while (start < end) {
				sum = numbers[start] + numbers[end];

				if (sum < target) {
					start++;
				} else if (sum > target) {
					end--;
				} else {
					if (start != i && end != i) {
						cnt++;
						break;
					} else if (start == i) {
						start++;
					} else if (end == i) {
						end--;
					}
				}
			}
		}

		System.out.println(cnt);

	}

}
