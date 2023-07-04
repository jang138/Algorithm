package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4948_베르트랑공준 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean prime[] = new boolean[246913];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i < 246913; i++) {
			if (!prime[i])
				continue;

			for (int j = 2 * i; j < 246913; j += i)
				prime[j] = false;
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			int ans = 0;

			for (int i = n + 1; i <= 2 * n; i++) {
				if (prime[i])
					ans++;
			}

			System.out.println(ans);
		}

	}

}
