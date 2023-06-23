package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1541
 * 실버2 잃어버린 괄호
 */

public class BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		// 음수를 기준으로 문자열을 나눠준 다음, 나눈 문자열을 각각 연산한 다음 전체에서 뺴준다 (단, 나눈 문자열 중 맨 처음은 양수이다)
		int sum = 0;
		int cnt = 0; // 첫번째 연산인지 판별용 (cnt가 0이면 첫번째)
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer plus = new StringTokenizer(st.nextToken(), "+");
			
			while(plus.hasMoreTokens()) {
				temp += Integer.parseInt(plus.nextToken());
			}
			
			if(cnt == 0) {
				sum += temp;
			} else {
				sum -= temp;
			}
			
			cnt++;
		}
		
		System.out.println(sum);

	}

}
