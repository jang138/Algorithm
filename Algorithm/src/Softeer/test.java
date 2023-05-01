package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		for(int i = 0; i < N; i++) {
			System.out.println(input[i]);
		}
	}
}