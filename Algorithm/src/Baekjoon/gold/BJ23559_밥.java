package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/23559
 * 골드5 밥
 */

public class BJ23559_밥 {

	static class Menu {
		int day;
		int A;
		int B;
		int val;

		public Menu(int day, int a, int b) {
			this.day = day;
			A = a;
			B = b;
			val = a - b;
		}

		@Override
		public String toString() {
			return "Menu [day=" + day + ", A=" + A + ", B=" + B + ", val=" + val + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int sum = 1000 * N;
		int ans = 0;

		// 5000원 메뉴 만족도와 1000원 메뉴 만족도가 큰 순으로 정렬한다.
		PriorityQueue<Menu> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.val - o1.val;
		});

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				
			// 먼저 1000원 메뉴를 선택한 경우로 초기화한다.
			ans += b;
			Menu menu = new Menu(i, a, b);
			pq.offer(menu);
		}

		while (!pq.isEmpty()) {
			Menu m = pq.poll();
			
			// 1000원짜리 식사가 만족도가 더 높은 경우
			if( m.val <= 0 ) {
				continue;
			}

			sum += 4000;
			ans += m.val;
			
			// 예산을 초과한 경우
			if( sum > X ) {
				sum -= 4000;
				ans -= m.val;
				break;
			}
		}

		System.out.println(ans);

	}

}
