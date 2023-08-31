import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
		visited = new boolean[n][m];
		answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, 0); // 이어진 4개
				visited[i][j] = false;
				check4(i, j); // ㅗ ㅏ ㅜ ㅓ
			}
		}

		System.out.println(answer);

	}

	// 자기 자신과 상하좌우 중 세개 선택
	static void check4(int x, int y) {

		for (int a = 0; a < 4; a++) {
			for (int b = a + 1; b < 4; b++) {
				for (int c = b + 1; c < 4; c++) {
					int dax = x + dx[a];
					int day = y + dy[a];

					int dbx = x + dx[b];
					int dby = y + dy[b];

					int dcx = x + dx[c];
					;
					int dcy = y + dy[c];

					if (dax >= 0 && dbx >= 0 && dcx >= 0 && dax < n && dbx < n && dcx < n && day >= 0 && dby >= 0
							&& dcy >= 0 && day < m && dby < m && dcy < m) {
						int count = map[x][y] + map[dax][day] + map[dbx][dby] + map[dcx][dcy];
						answer = Math.max(count, answer);
					}
				}
			}
		}

	}

	static void dfs(int x, int y, int depth, int count) {
		// System.out.println(x + " " + y + " " + depth);

		if (depth == 4) {
			if (answer < count)
				answer = count;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == false))
				continue;

			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1, count + map[nx][ny]);
			visited[nx][ny] = false;

		}
	}

}