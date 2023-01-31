package algoExercise;

import java.util.ArrayDeque;
import java.util.Queue;

public class Day230131_QueueAPI {

	public static void main(String[] args) {
		
		//Queue<String> queue = new LinkedList<String>();
		Queue<String> queue = new ArrayDeque<String>();

		
		System.out.println(queue.toString());
		queue.offer("김");
		queue.offer("이");
		queue.offer("박");
		
		System.out.println(queue.toString() + " // " + queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.toString() + " // " + queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.toString() + " // " + queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.toString() + " // " + queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.toString() + " // " + queue.isEmpty());
		System.out.println(queue.poll());
	}

}
