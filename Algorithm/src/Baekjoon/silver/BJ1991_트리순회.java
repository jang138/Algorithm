package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1991
 * 실버1 트리 순회
 */

public class BJ1991_트리순회 {

	static int N;
	static Node head = new Node('A', null, null);

	static class Node {
		char n;
		Node left;
		Node right;

		public Node(char n, Node left, Node right) {
			this.n = n;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return "Node [n=" + n + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char n = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);

			makeTree(head, n, l, r, 1);
		}

		preOrder(head);
		System.out.println();

		inOrder(head);
		System.out.println();

		postOrder(head);
		System.out.println();

	}

	private static void makeTree(Node temp, char root, char left, char right, int depth) {

		if (temp.n == root) {
			temp.left = left == '.' ? null : new Node(left, null, null);
			temp.right = right == '.' ? null : new Node(right, null, null);
		} else {
			if (temp.left != null) {
				makeTree(temp.left, root, left, right, depth + 1);

			}
			if (temp.right != null) {
				makeTree(temp.right, root, left, right, depth + 1);

			}
		}

	}

	private static void preOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.n);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.n);
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.n);
	}
}
