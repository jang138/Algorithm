package Softeer.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://softeer.ai/practice/info.do?idx=1&eid=362
 * A+B
 */

/*
5
1 1
2 3
3 4
9 8
5 2
*/

public class A더하기B {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int answer = A + B;
			System.out.println("Case #" + t + ": " + answer);

		}
	}
}