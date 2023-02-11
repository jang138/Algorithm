package algoExercise;

public class Day230210_PriorityQueueComparable {

	static class Student implements Comparable<Student> {
		int age;
		int number;

		public Student(int age, int number) {
			this.age = age;
			this.number = number;
		}

		@Override
		public int compareTo(Student o) {

			/*
			 * 만약 자신의 age가 o의 age보다 크다면 양수가 반환 될 것이고, 같다면 0을, 작다면 음수를 반환할 것이다.
			 */
			return this.age - o.age;
		}
	}

	public static void main(String[] args) {
		
		Student a = new Student(17, 2); // 17살 2반
		Student b = new Student(18, 1); // 18살 1반

		int isBig = a.compareTo(b); // a자기자신과 b객체를 비교한다.

		if (isBig > 0) {
			System.out.println("a객체가 b객체보다 큽니다.");
		} else if (isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		} else {
			System.out.println("a객체가 b객체보다 작습니다.");
		}

	}

}
