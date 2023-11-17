package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Priority {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		minHeap.add(1);
		maxHeap.add(1);
		minHeap.add(2);
		maxHeap.add(2);
		minHeap.add(3);
		maxHeap.add(3);
		minHeap.add(4);
		maxHeap.add(4);
		
		System.out.println(minHeap + " " + maxHeap);

//		for (int i = 0; i < n; i++) {
//			int num = Integer.parseInt(br.readLine());
//
//			if (minHeap.size() == maxHeap.size())
//				maxHeap.offer(num);
//			else
//				minHeap.offer(num);
//
//			if (!minHeap.isEmpty() && !maxHeap.isEmpty())
//				if (minHeap.peek() < maxHeap.peek()) {
//					int tmp = minHeap.poll();
//					minHeap.offer(maxHeap.poll());
//					maxHeap.offer(tmp);
//				}
//
//			sb.append(maxHeap.peek() + "\n");
//			
//			System.out.println(minHeap + " " + maxHeap);
//		}
		System.out.println(sb);

	}

}
