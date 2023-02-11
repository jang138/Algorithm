package algoExercise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class pqtest {

	public static void main(String[] args) {
		PriorityQueue<Student> pq1 = new PriorityQueue<>();
		PriorityQueue<Student> pq2 = new PriorityQueue<>();

		Random rnd = new Random();

		char name = 'A';
		for (int i = 0; i < 10; i++) {
			int age = rnd.nextInt(10) + 10;
			int month = rnd.nextInt(12) + 1;

			pq1.offer(new Student(name, age, month));
			pq2.offer(new Student(name, age, month));

			name++;
		}

		System.out.println("[pq1]");
		for (Object val : pq1.toArray()) {
			System.out.print(val);
		}
		System.out.println();

		System.out.println("name\tage\tmonth");
		while (!pq1.isEmpty()) {
			System.out.print(pq1.poll());
		}
		System.out.println();
		
		System.out.println("[pq2]");
		for (Object val : pq2.toArray()) {
			System.out.print(val);
		}
		System.out.println();

		System.out.println("name\tage\tmonth");
		while (!pq2.isEmpty()) {
			System.out.print(pq2.poll());
		}
		System.out.println();

	}

	private static Comparator<Student> comp = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.age == o2.age) {
				if (o1.month == o2.month) {
					return o1.name - o2.name;
				}
				return o2.month - o1.month;
			}
			return o2.age - o1.age;
		}

	};

	static class Student implements Comparable<Student> {
		char name;
		int age;
		int month;

		public Student(char name, int age, int month) {
			this.name = name;
			this.age = age;
			this.month = month;
		}

		@Override
		public int compareTo(Student o) {
			if (this.age == o.age) {
				if (this.month == o.month) {
					return this.name - o.name;
				}
				return o.month - this.month;
			}
			return o.age - this.age;
		}

		@Override
		public String toString() {
			return name + "\t" + age + "\t" + month + "\n";
		}
	}

}
