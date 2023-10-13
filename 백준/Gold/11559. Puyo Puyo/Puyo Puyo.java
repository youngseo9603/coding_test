import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean isBomb;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		isBomb = true;
		answer = 0;

		while (isBomb) {
			map = down(map);
			map = bomb(map);
		}
		System.out.println(answer);
	}

	static char[][] down(char[][] map) {
		char[][] newMap = new char[12][6];
		for (int i = 0; i < 12; i++)
			for (int j = 0; j < 6; j++)
				newMap[i][j] = '.';

		for (int i = 0; i < 6; i++) {
			int cnt = 11;
			for (int j = 0; j < 12; j++) {
				if (map[11 - j][i] != '.') {
					newMap[cnt][i] = map[11 - j][i];
					cnt--;
				}
			}
		}

		return newMap;
	}

	static char[][] bomb(char[][] map) {
		boolean[][] visited = new boolean[12][6];
		Stack<int[]> stack;
		boolean next = false;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.' && !visited[i][j]) {
					char type = map[i][j];
					stack = new Stack<>();
					List<int[]> list = new LinkedList<>();
					stack.add(new int[] { i, j });
					int cnt = 1;
					visited[i][j] = true;
					list.add(new int[] { i, j });

					while (!stack.isEmpty()) {
						int[] temp = stack.pop();

						for (int d = 0; d < 4; d++) {
							int x = temp[0] + dx[d];
							int y = temp[1] + dy[d];

							if (x >= 0 && y >= 0 && x < 12 && y < 6 && !visited[x][y] && map[x][y] == type) {
								stack.add(new int[] { x, y });
								visited[x][y] = true;
								cnt++;
								list.add(new int[] { x, y });
							}
						}
					}

					if (cnt >= 4) {
						next = true;
						for (int[] t : list) {
							map[t[0]][t[1]] = '.';
						}
					}

				}
			}
		}

		if (next == false)
			isBomb = false;
		else
			answer++;
		return map;
	}
}