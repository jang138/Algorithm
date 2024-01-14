package Baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11003
 * 플레티넘5 최솟값 찾기
 */

public class BJ11003_최솟값찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		Deque<Node> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());

			// deque을 이용한 정렬, 새로운 값이 덱의 마지막 값보다 작다면 마지막 값을 삭제하고 새 값을 추가한다.
			while (!deque.isEmpty() && deque.getLast().value > target) {
				deque.removeLast();
			}
			deque.addLast(new Node(i, target));
			
			// 범위 L을 벗어나면 제일 앞의 값을 제거
			if(deque.getFirst().index <= i - L) {
				deque.removeFirst();
			}
			
//			System.out.println(deque);

			// 최종적으로 덱은 계속 오름차순 정렬된 상태이므로 맨 앞의 값이 최소값이 된다.
			sb.append(deque.getFirst().value).append(" ");
		}
		
		System.out.println(sb);
	}

	static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		public String toString() {
			return index + " " + value;
		}
	}

}
