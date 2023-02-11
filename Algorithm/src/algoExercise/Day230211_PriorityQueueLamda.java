package algoExercise;

import java.util.PriorityQueue;
import java.util.Random;

public class Day230211_PriorityQueueLamda {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.science == o2.science) {
				if (o1.math == o2.math) {
					return o1.name - o2.name;
				}
				return o2.math - o1.math;
			}
			return o2.science - o1.science;
		});

		Random rnd = new Random();

		char name = 'A';
		for (int i = 0; i < 10; i++) {
			int math = rnd.nextInt(10);
			int science = rnd.nextInt(10);

			pq.offer(new Student(name, math, science));
			name++;
		}

		// 힙 내부 배열의 요소 상태
		System.out.println("[pq2 내부 배열 상태]");
		for (Object val : pq.toArray()) {
			System.out.print(val);
		}
		System.out.println();
		System.out.println();

		System.out.println("[과학-수학-이름순 뽑기]");
		System.out.println("name\tmath\tscience");
		while (!pq.isEmpty()) {
			System.out.print(pq.poll());
		}
	}

	static class Student {

		char name;
		int math;
		int science;

		public Student(char name, int math, int science) {
			this.name = name;
			this.math = math;
			this.science = science;
		}

		public String toString() {
			return name + "\t" + math + "\t" + science + "\n";
		}
	}
}