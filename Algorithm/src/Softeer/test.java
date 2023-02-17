package Softeer;

import java.util.PriorityQueue;
import java.util.Scanner;

public class test {

	static class Node {
		int num, a, b, c;

		public Node(int num, int a, int b, int c) {
			this.num = num;
			this.a = a;
			this.b = b;
			this.c = c;
		}

		// abc 출력
		public String toString() {
			return a + "" + b + "" + c;
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int num = (int) (3 * Math.cbrt(n)) + 1;

		// 오름차순
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.num - o2.num;
		});

		for (int i = 1; i <= num - 2; i++) {
			if (i > 50)
				continue;
			for (int j = 1; j <= num - 1 - i; j++) {
				if (j > 50)
					continue;
				int k = num - i - j;
				if (k > 50)
					continue;

				if (n <= i * j * k) {
					pq.offer(new Node(i * j * k, i, j, k));
				}

			}
		}

		System.out.println(pq.poll());

	}

}
