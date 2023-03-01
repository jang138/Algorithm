package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2513
 * 골드3 통학버스
 */

public class BJ2513_통학버스 {

	static class Node {
		int location;
		int student;

		public Node(int location, int student) {
			this.location = location;
			this.student = student;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 아파트 단지 수
		int K = Integer.parseInt(st.nextToken()); // 통학버스 정원
		int S = Integer.parseInt(st.nextToken()); // 학교의 위치

		PriorityQueue<Node> pqLeft = new PriorityQueue<>((o1, o2) -> {
			return o1.location - o2.location;
		});

		PriorityQueue<Node> pqRight = new PriorityQueue<>((o1, o2) -> {
			return o2.location - o1.location;
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // 아파트 위치
			int s = Integer.parseInt(st.nextToken()); // 학생 수
			if (l < S) {
				pqLeft.offer(new Node(l, s));
			} else {
				pqRight.offer(new Node(l, s));
			}
		}

		int ans = 0;

		while (!pqLeft.isEmpty()) {
			int cnt = 0; // 이동중인 버스에 태운 학생 수
			Node target = pqLeft.poll();

			if (target.student <= K - cnt) { // 버스에 학생을 모두 태울 수 있는 경우
				cnt += target.student; // 버스에 탑승
				// 남은 자리에 다른 아파트의 학생 태우기
				while (!pqLeft.isEmpty() && cnt < K) {
					Node next = pqLeft.poll();
					if (next.student <= K - cnt) {
						cnt += next.student;
					} else {
						pqLeft.offer(new Node(next.location, next.student - (K - cnt)));
						cnt = K;
					}
				}
			} else { // 태우고 남은 학생은 다시 pq에 넣어주기
				pqLeft.offer(new Node(target.location, target.student - (K - cnt)));
				cnt = K;
			}

			// 제일 먼 거리부터 이동
			ans += (S - target.location) * 2;
		}

		while (!pqRight.isEmpty()) {
			int cnt = 0; // 이동중인 버스에 태운 학생 수
			Node target = pqRight.poll();

			if (target.student <= K - cnt) { // 버스에 학생을 모두 태울 수 있는 경우
				cnt += target.student; // 버스에 탑승
				// 남은 자리에 다른 아파트의 학생 태우기
				while (!pqRight.isEmpty() && cnt < K) {
					Node next = pqRight.poll();
					if (next.student <= K - cnt) {
						cnt += next.student;
					} else {
						pqRight.offer(new Node(next.location, next.student - (K - cnt)));
						cnt = K;
					}
				}
			} else { // 태우고 남은 학생은 다시 pq에 넣어주기
				pqRight.offer(new Node(target.location, target.student - (K - cnt)));
				cnt = K;
			}

			// 제일 먼 거리부터 이동
			ans += (target.location - S) * 2;
		}

		System.out.println(ans);

	}

}
