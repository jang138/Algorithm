package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6219_소수의자격 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String D = st.nextToken();
		int ans = 0;

		boolean prime[] = new boolean[B + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		// 에라토스테네스의 체
		for (int i = 2; i <= B; i++) {
			if (!prime[i])
				continue;

			for (int j = 2 * i; j <= B; j += i)
				prime[j] = false;

		}

		
		// A와 B 사이 중 소수를 문자열로 변환 후 D가 포함되는지 확인
		for (int i = A; i <= B; i++) {
			if(!prime[i])
				continue;
			
			String str = Integer.toString(i);
			if(str.contains(D))
				ans++;
			
		}
		
		System.out.println(ans);
	}

}
