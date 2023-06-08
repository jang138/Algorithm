package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2644
 * 실버2 촌수계산
 */

public class BJ2644_촌수계산_bfs {

	static int N, A, B, M;
	static int family[][];
	static int chon[];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		family = new int[N + 1][N + 1];
		chon = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = family[y][x] = 1;
		}
		
		bfs(A);
				
		System.out.println(chon[B] == 0 ? -1 : chon[B]);
	}
	
	private static void bfs(int num) {
		queue.add(num);
		
		while(!queue.isEmpty()) {
			int target = queue.poll();
			
			if(target == B) {
				break;
			}
			
			for (int i = 1; i <= N; i++) {
				if(family[target][i] == 1 && chon[i] == 0) {
					queue.add(i);
					chon[i] = chon[target] + 1;
				}
				
			}
			
		}
		
	}

}

/*
 * 토마토 문제처럼 방문 확인용 boolean배열과 정수형배열 타입의 큐를 정의하고 0번 인덱스에 숫자를, 1번 인덱스에 촌수를 저장하고
 * 촌수를 하나씩 늘리는 방법을 사용해도 됐을듯
 */
