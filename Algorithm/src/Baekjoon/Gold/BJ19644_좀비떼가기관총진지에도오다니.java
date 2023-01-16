package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19644
 * 골드4 좀비 떼가 기관총 진지에도 오다니
 */

public class BJ19644_좀비떼가기관총진지에도오다니 {

	static int L, ML, MK, C;
	static int[] Zombie;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		L = Integer.parseInt(br.readLine()); // 크기
		st = new StringTokenizer(br.readLine());
		ML = Integer.parseInt(st.nextToken()); // 기관총 유효 사거리
		MK = Integer.parseInt(st.nextToken()); // 기관총 피해량
		C = Integer.parseInt(br.readLine()); // 지뢰 개수

		Zombie = new int[L];
		for (int i = 0; i < L; i++) {
			Zombie[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> q = new LinkedList<>();
		int count = 0;
		boolean ans = true;

		for (int i = 0; i < Math.min(L, ML); i++) {
			if (q.size() == 0) {
				if (Zombie[0] - MK <= 0) {
					q.offer(0);
				} else {
					q.offer(Zombie[0]);
					count += 1;
				}
			} else {
				if (count == 0) {
					if (Zombie[i] - MK * (i + 1) <= 0) {
						q.offer(0);
					} else {
						q.offer(Zombie[i] - MK * (i + 1));
						count += 1;
					}
				} else {
					if (Zombie[i] - MK * (i + 1 - count) <= 0) {
						q.offer(0);
					} else {
						q.offer(Zombie[i] - MK * (i + 1 - count));
						count += 1;
					}
				}
			}
		}

		for (int i = ML; i < L; i++) {
			if (q.peek() == 0) {
				q.poll();

				if (Zombie[i] - MK * (ML - count) <= 0) {
					q.offer(0);
				} else {
					q.offer(Zombie[i] - MK * (ML - count));
					count += 1;
				}
			} else {
				q.poll();

				if (C > 0) {
					C -= 1;
				} else {
					ans = false;
					break;
				}

				if (Zombie[i] - MK * (ML - count) <= 0) {
					q.offer(0);
					count -= 1;
				} else {
					q.offer(Zombie[i] - MK * (ML - count));
				}
			}
		}

		if (ans) {
			while (!q.isEmpty()) {
				if (q.peek() == 0) {
					q.poll();
				} else {
					q.poll();
					count -= 1;

					if (C > 0) {
						C -= 1;
					} else {
						ans = false;
						break;
					}
				}
			}
		}

		System.out.println(ans ? "YES" : "NO");
	}

}
