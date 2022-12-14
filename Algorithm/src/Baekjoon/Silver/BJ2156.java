package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2156
 * 실버1 포도주 시식
 */

public class BJ2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

        int[] dp = new int[n];
        dp[0] = input[0];
        

    	for (int i = 1; i < n; i++) {
    		if( i == 1) {
    	        dp[1] = input[0] + input[1];
    	        continue;
    		}
    		
    		if( i == 2 ) {
    	        dp[2] = Math.max(dp[1], Math.max(input[0]+input[2], input[1]+input[2]));
    	        continue;
    		}
    		
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + input[i], dp[i - 3] + input[i-1] + input[i]));
		}

        
        System.out.println(dp[n-1]);

	}

}
