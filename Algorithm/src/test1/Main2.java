package test1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main2 {
	static class Person {
		int age;
		int weight;
		int height;

		public Person(int age, int weight, int height) {
			this.age = age;
			this.weight = weight;
			this.height = height;
		}
		
//		@Override // implements Comparable<Person>
//		public int compareTo(Person o) {
//			if (this.age == o.age) {
//				if (this.weight == o.weight) {
//					return o.height - this.height;
//				}
//
//				return this.weight - o.weight;
//			}
//			return this.age - o.age;
//		}

		public String toString() {
			return age + " " + weight + " " + height;
		}
	}

	public static void main(String[] args) {

		Random random = new Random();
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age) {
					if (o1.weight == o2.weight) {
						return o2.height - o1.height;
					}

					return o1.weight - o2.weight;
				}
				return o1.age - o2.age;
			}

		};
		
		Comparator<Integer> comparator1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
			
		};

		Comparator<Person> ramdaComparator = (Person o1, Person o2) -> {
			if (o1.age == o2.age) {
				if (o1.weight == o2.weight)
					return o2.height - o1.height;

				return o1.weight - o2.weight;
			}

			return o1.age - o2.age;
		};

		PriorityQueue<Person> pq = new PriorityQueue<>((Person o1, Person o2) -> {
			if (o1.age == o2.age) {
				if (o1.weight == o2.weight)
					return o2.height - o1.height;

				return o1.weight - o2.weight;
			}

			return o1.age - o2.age;
		});

		for (int i = 0; i < 20; i++) {
			int age = random.nextInt(10) + 20;
			int weight = random.nextInt(10) + 40;
			int height = random.nextInt(20) + 155;
			
			pq.add(new Person(age, weight, height));
		}
		int preAge = 0;

		while (!pq.isEmpty()) {
			Person p = pq.poll();

			if (preAge != p.age) {
				if (preAge != 0)
					System.out.println("----------------------------");

				preAge = p.age;
			}
			System.out.println(String.format("나이: %d / 몸무게: %d / 키: %d", p.age, p.weight, p.height));
		}
	}
}
