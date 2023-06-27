package test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test1 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(1, 1);
		queue.add(node);

		node = new Node(2, 2);
		queue.add(node);

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			System.out.println(now.x + " " + now.y);

		}
		
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
	}
}
