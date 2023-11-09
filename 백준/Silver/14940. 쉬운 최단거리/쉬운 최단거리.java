
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] dist;

	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();

	static void bfs() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int[] dir : directions) {
				int nextX = x + dir[0];
				int nextY = y + dir[1];

				if (!(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m)) {
					continue;
				}
				if (visited[nextX][nextY])
					continue;
				if (arr[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				visited[nextX][nextY] = true;
				dist[nextX][nextY] = dist[x][y] + 1;

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && arr[i][j] != 0) {
					sb.append(-1).append(" ");
				} else {
					sb.append(dist[i][j]).append(" ");

				}

			}
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}
}