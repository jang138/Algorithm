package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ20311_화학실험 {

	static class Node implements Comparable<Node> {
		int number;
		int count;

		public Node(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.count, this.count);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			int count = Integer.parseInt(st.nextToken());
			pq.add(new Node(i, count));
		}

		Stack<Integer> stack = new Stack<>();

		Node n = pq.poll();
		stack.add(n.number);

		if (n.count > 1) {
			pq.add(new Node(n.number, n.count - 1));
		}

		boolean flag = true;

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (stack.peek() == node.number) {
				if (pq.isEmpty()) {
					flag = false;
					break;
				}
				Node next = pq.poll();
				stack.add(next.number);

				if (next.count > 1) {
					pq.add(new Node(next.number, next.count - 1));
				}

				pq.add(node);
			}

			else {
				stack.add(node.number);
				if (node.count > 1) {
					pq.add(new Node(node.number, node.count - 1));
				}
			}
		}

		if (flag) {
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

}
