package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2841
 * 실버1 외계인의 기타 연주
 */

public class BJ2841_외계인의기타연주 {
	
	static int N, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 음
		P = Integer.parseInt(st.nextToken()); // 프렛

		Stack<Integer>[] line = new Stack[7];
		
		for (int i = 1; i <= 6; i++) {
			line[i] = new Stack<Integer>();
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken()); // 줄
			int f = Integer.parseInt(st.nextToken()); // 프렛
			
			// 프렛을 누를 때 : 비어있거나 더 작은 프렛을 누르고 있는지 확인
			if(line[l].isEmpty() || line[l].peek() < f ) {
				// 이미 해당 음을 누르고 있는 경우
				if(!line[l].isEmpty() && line[l].peek() == f) {
					continue;
				}
				line[l].push(f);
				count++;
				
				continue;
			}
			
			// 프렛을 뗄 때 : (누르고 있는 상태니까 계속 체크)
			while(!line[l].isEmpty() && line[l].peek() > f ) {
				line[l].pop();
				count++;
			}
			
			// 이미 해당 음을 누르고 있는 경우
			if(!line[l].isEmpty() && line[l].peek() == f) {
				continue;
			}
			
			line[l].push(f);
			count++;
			
		}
		
		System.out.println(count);
		
	}

}
