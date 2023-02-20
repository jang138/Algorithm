package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * https://www.acmicpc.net/problem/2151
 * 골드3 거울 설치
 */

/*
5
***#*
*.!.*
*!.!*
*.!.*
*#***

2
!#
!#

*/

public class BJ2151_거울설치 {

	// 빛의 진행
	static class Node {
		int x, y, mirror, dir;

		public Node(int x, int y, int mirror, int dir) {
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean visit[][][] = new boolean[4][N][N]; // 방문할 때 빛이 들어오는 방향까지 3차원 배열
		Node door = null;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				// 시작하는 지점인 문(#) 체크
				if (map[i][j] == '#') {
					door = new Node(i, j, 0, 0);
				}
			}
		}

		// 거울의 수 오름차순
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> {
			return o1.mirror - o2.mirror;
		});

		visit = new boolean[4][N][N];
		for (int i = 0; i < 4; i++) {
			// 사방 모두 넣어준다.
			pq.offer(new Node(door.x, door.y, 0, i));
			visit[i][door.x][door.y] = true;
		}

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[] dir3 = { -1, 1, 0 }; // 좌회전 -1, 우회전 1, 직진 0

		// 빛이 문에서 다른 문으로 진행하면서 만난 거울(!)의 수가 최소가 되는 것을 출력한다.
		while (!pq.isEmpty()) {
			Node current = pq.poll();

			for (int i : dir3) {
				// 거울을 놓을수 있는 자리가 아니면 직진 밖에 하지 않는다
				if (map[current.x][current.y] != '!' && i != 0)
					continue;

				int dir = (current.dir + i + 4) % 4;
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				// i==0 직진해서 거울이 필요 없는경우, i!=0 빛이 꺾이면서 거울이 필요한 경우
				int mirror = (i == 0 ? current.mirror : current.mirror + 1);

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '*')
					continue;

				if (visit[dir][nx][ny])
					continue;

				// 반대편 문에 도달, while 종료
				if (map[nx][ny] == '#') {
					System.out.println(mirror);
					return;
				}

				// 새로운 빛의 진행 추가
				visit[dir][nx][ny] = true;
				pq.offer(new Node(nx, ny, mirror, dir));

			}
		}
	}

}
