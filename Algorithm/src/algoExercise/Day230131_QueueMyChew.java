package algoExercise;

import java.util.LinkedList;
import java.util.Queue;

public class Day230131_QueueMyChew {

	public static void main(String[] args) {

		int N = 20; // 마이쮸 개수
		int person = 1; // 대기열에 새롭게 등장하는 사람의 번호

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { person, 1 });

		while (N > 0) {
			int[] p = queue.poll();

			// 마지막 가져가는 사람이 남은 마이쮸보다 많은 수를 요구하는 경우
			int availableCount = (N >= p[1]) ? p[1] : N;
			N -= availableCount;
			
			if(N==0) {
				System.out.println("마지막으로 마이쮸를 가져간 사람: " + p[0] + 
						", 가져간 마이쮸의 개수: " + availableCount);
			} else {
				System.out.println("마이쮸를 가져간 사람: " + p[0] + 
						", 가져간 마이쮸의 개수: " + availableCount);
				// 받은 사람 넣기
				p[1]++;
				queue.offer(p);
				// 새로운 사람 넣기
				queue.offer(new int[] {++person, 1});
			}
		}
	}

}
