package algoExercise;

import java.util.Comparator;

public class Day230211_PriorityQueueComparatorAnonymous {

	public static void main(String[] args) {

		Student a = new Student(17, 2); // 17살 2반
		Student b = new Student(18, 1); // 18살 1반
		Student c = new Student(15, 3); // 15살 3반

		// comp 익명객체를 통해 b와 c객체를 비교한다.
		int isBig = comp.compare(b, c);

		if (isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		} else if (isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		} else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

	}

	public static Comparator<Student> comp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.classNumber - o2.classNumber;
		}
	};
}

class Student {

	int age; // 나이
	int classNumber; // 학급

	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

}
