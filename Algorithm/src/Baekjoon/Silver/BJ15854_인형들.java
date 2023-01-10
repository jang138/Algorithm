package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15954
 * 실버1 인형들
 */

public class BJ15854_인형들 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
		}

		double result = Double.MAX_VALUE;

		for (int i = K; i <= N; i++) {
			for (int j = 0; j <= N - i; j++) {
				// 평균
				double mean = getMean(arr, j, i);
				// 표준편차
				double sd = getSD(arr, mean, j, i);

				result = Math.min(result, sd);
			}
		}

		System.out.println(result);

	}

	static double getMean(int[] arr, int index, int K) {
		double sum = 0.0;
		for (int i = 0; i < K; i++) {
			sum += arr[index + i];
		}
		return sum / K;
	}

	static double getSD(int[] arr, double mean, int index, int K) {
		double sum = 0.0;
		for (int i = 0; i < K; i++) {
			sum += (Math.pow(arr[index + i] - mean, 2));
		}
		return Math.sqrt(sum / K);
	}

}
