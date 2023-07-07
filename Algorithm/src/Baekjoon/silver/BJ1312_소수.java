package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1312_소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int result = A % B;

		// 나누기 할때 소수점 자리 계산시 방법과 같다
		for (int i = 0; i < N - 1; i++) {
			result *= 10;
			result %= B;
		}

		result *= 10;
		result /= B;
		System.out.println(result);
	}

}
