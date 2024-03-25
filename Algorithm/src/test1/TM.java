package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<String> roomNames = new ArrayList<>();
		boolean[][] roomTimes = new boolean[N][18];

		for (int i = 0; i < N; i++) {
			roomNames.add(br.readLine());
			Arrays.fill(roomTimes[i], true);
		}

		Collections.sort(roomNames);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int index = roomNames.indexOf(name);

			for (int j = start; j < end; j++) {
				roomTimes[index][j] = false;
			}
		}

		System.out.println(roomNames);
		System.out.println(Arrays.deepToString(roomTimes));

		for (int i = 0; i < N; i++) {
			String name = roomNames.get(i);
			int index = roomNames.indexOf(name);
			ArrayList<String> timeList = new ArrayList<>();
			StringBuilder sb = new StringBuilder();

			System.out.println(String.format("Room %s:", name));

			

			if (timeList.size() == 0) {
				System.out.println("Not available");
			} else {
				
			}

			if (i < N - 1)
				System.out.println("-----");
		}
	}

}

//3 7
//grandeur
//avante
//sonata
//sonata 14 16
//grandeur 11 12
//avante 15 18
//sonata 10 11
//avante 9 12
//grandeur 16 18
//avante 12 15

//3 2
//santafe
//aerocity
//porter
//santafe 9 12
//porter 9 18
