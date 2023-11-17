package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());

		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> column = new ArrayList<>();

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			if (type == 0) {
				row.add(a);
			} else if (type == 1) {
				column.add(a);
			}
		}

		row.add(0);
		row.add(M);
		column.add(0);
		column.add(N);

		Collections.sort(row);
		Collections.sort(column);

		int maxRow = 0;
		for (int i = 1; i < row.size(); i++) {
			maxRow = Math.max(maxRow, row.get(i) - row.get(i - 1));
		}

		int maxColumn = 0;
		for (int i = 1; i < column.size(); i++) {
			maxColumn = Math.max(maxColumn, column.get(i) - column.get(i - 1));
		}

		System.out.println(maxRow * maxColumn);

	}

}
