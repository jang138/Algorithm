package Baekjoon.gold;

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

		L = Integer.parseInt(br.readLine()); // 거리 길이
		st = new StringTokenizer(br.readLine());
		ML = Integer.parseInt(st.nextToken()); // 기관총 유효 사거리
		MK = Integer.parseInt(st.nextToken()); // 기관총 피해량
		C = Integer.parseInt(br.readLine()); // 지뢰 개수

		Zombie = new int[L];
		for (int i = 0; i < L; i++) {
			Zombie[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> dq = new LinkedList<>();
		// 큐 안에 살아있는 좀비 카운트
		int count = 0;
		boolean answer = true;


		// 기관총 범위 큐 채움
		for (int i = 0; i < Math.min(L, ML); i++) {
			if (dq.size() == 0) {
				// 좀비 처치
				if (Zombie[0] <= MK) {
					dq.offer(0);
				} else {
					dq.offer(Zombie[0]);
					// 큐에 살아있는 좀비가 저장된 경우 카운트
					count += 1;
				}
			} else {
				// 살아있는 좀비가 없는 경우
				if (count == 0) {
					if (Zombie[i] <= MK * (i + 1)) {
						dq.offer(0);
					} else {
						dq.offer(Zombie[i] - MK * (i + 1));
						count += 1;
					}
				}
				// 살아있는 좀비가 있는 경우 : 지뢰를 사용한만큼 기관총 사용 횟수가 줄어든다
				else {
					if (Zombie[i] <= MK * (i + 1 - count)) {
						dq.offer(0);
					} else {
						dq.offer(Zombie[i] - MK * (i + 1 - count));
						count += 1;
					}
				}
			}

		}
		
		System.out.println(dq);

		// 범위 밖 나머지 좀비
		for (int i = ML; i < L; i++) {
			if (dq.peek() == 0) {
				dq.poll();

				if (Zombie[i] <= MK * (ML - count)) {
					dq.offer(0);
				} else {
					dq.offer(Zombie[i] - MK * (ML - count));
					count += 1;
				}
			} else {
				dq.poll();

				if (C > 0) {
					C -= 1;
				} else {
					answer = false;
					break;
				}

				if (Zombie[i] <= MK * (ML - count)) {
					dq.offer(0);
					count -= 1;
				} else {
					dq.offer(Zombie[i] - MK * (ML - count));
				}
			}
		}

		// answer가 아직 true인 경우 큐 비우면서 확인
		if (answer) {
			while (!dq.isEmpty()) {
				if (dq.peek() == 0) {
					dq.poll();
				} else {
					dq.poll();
					count -= 1;

					if (C > 0) {
						C -= 1;
					} else {
						answer = false;
						break;
					}
				}
			}
		}

		System.out.println(answer ? "YES" : "NO");
	}

}
