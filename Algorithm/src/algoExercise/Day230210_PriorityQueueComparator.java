package algoExercise;

import java.util.Comparator;

public class Day230210_PriorityQueueComparator {

	static class Student implements Comparator<Student> {

		int age; // 나이
		int classNumber; // 학급

		Student(int age, int classNumber) {
			this.age = age;
			this.classNumber = classNumber;
		}

		@Override
		public int compare(Student o1, Student o2) {
			/*
			 * 만약 o1의 classNumber가 o2의 classNumber보다 크다면 양수가 반환 될 것이고, 같다면 0을, 작다면 음수를 반환할
			 * 것이다.
			 */
			return o1.classNumber - o2.classNumber;
		}
	}

	public static void main(String[] args) {
		Student a = new Student(17, 2); // 17살 2반
		Student b = new Student(18, 1); // 18살 1반
		Student c = new Student(15, 3); // 15살 3반

		// a객체와는 상관 없이 b와 c객체를 비교한다.
		int isBig = a.compare(b, c);

		if (isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		} else if (isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		} else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

	}

}
