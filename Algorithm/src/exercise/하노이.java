package exercise;

public class 하노이 {
	
	static int N = 0;

	public static void main(String[] args) {
		hanoi(3, 1, 2, 3);
		System.out.println(N);
	}

	public static void hanoi(int n, int from, int temp, int to) {
		
		if( n == 0 ) {
			return;
		}
		
		// n-1 원판 (맨 아래 제외 나머지) from => temp
		hanoi(n - 1, from, to, temp);

		// n 원판 (맨 아래)
		System.out.println(n + " : " + from + " => " + to);
		N += 1;

		// n-1 원판 (맨 아래 제외 나머지) temp => to
		hanoi(n - 1, temp, from, to);
	}

}
