package Softeer.hsat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HSAT7_자동차테스트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		ArrayList<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(al);

		flag1: for (int q = 0; q < Q; q++) {
			int target = Integer.parseInt(br.readLine());
			if (target == al.get(0) || target == al.get(al.size() - 1)) {
				sb.append(0).append("\n");
				continue;
			}

			int leftCnt = 0;
			int rightCnt = 0;

			flag2: for (int i = 1; i < al.size() - 1; i++) {
				if (target == al.get(i)) {
					leftCnt = i;
					rightCnt = al.size() - i - 1;
					break flag2;
				}

				if (i == al.size() - 2) {
					sb.append(0).append("\n");
					continue flag1;
				}
			}

			sb.append(leftCnt * rightCnt).append("\n");

		}
		
		System.out.println(sb);
	}

}
