import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String[][] map;
	static int r;
	static int c;
	public static int[] cur;
	public static int[] next;
	public static int[][] visited;
	public static String topOpen = "|+23MZ";
	public static String bottomOpen = "|+14MZ";
	public static String rightOpen = "-+12MZ";
	public static String leftOpen = "-+34MZ";

	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = bf.readLine().split(" ");
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		map = new String[r][c];
		visited = new int[r][c];
		int one = 0;

		for (int i = 0; i < r; i++) {
			temp = bf.readLine().split("");
			for (int j = 0; j < c; j++) 
				map[i][j] = temp[j];
		}
		
		int nx;
		int ny;
		
		// 문제가 있는 부분 검출 후 visited를 1로 변경
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				if (map[i][j].equals("|") && !linked_or(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("-") && !linked_minus(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("+") && !linked_plus(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("1") && !linked_1(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("2") && !linked_2(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("3") && !linked_3(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				} else if (map[i][j].equals("4") && !linked_4(new int[] { i, j })) {
					visited[i][j] = 1;
					one++;
				}
				else if	(map[i][j].equals("M") || map[i][j].equals("Z")) {
					for(int d=0; d<4; d++) {
						nx = i + dx[d];
						ny = j + dy[d];
						if (nx >= 0 && nx < r && ny >= 0 && ny < c && !map[nx][ny].equals(".")) {
							if(nx==i && (ny==j+1 || ny==j-1))	map[i][j] = "-";
							if((nx==i-1 || nx==i+1) && ny==j)	map[i][j] = "|";
						}
						
					}
				}
		}
		
//		for(int i=0; i<r; i++) {
//			for(int j=0; j<c; j++)
//				System.out.print(visited[i][j] + " ");
//			System.out.println();
//		}
		
		int a = 0;
		int b = 0;
		String fix = "";

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int cnt = 0;
				if (map[i][j].equals(".")) {
					for (int d = 0; d < 4; d++) {
						nx = i + dx[d];
						ny = j + dy[d];

						if (nx >= 0 && nx < r && ny >= 0 && ny < c && visited[nx][ny] == 1)
							cnt++;
					}
				}
				if (cnt == one) {
					map[i][j] = "-";
					if (linked_minus(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "-";
					}
					map[i][j] = "|";
					if (linked_or(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "|";
					}
					map[i][j] = "1";
					if (linked_1(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "1";
					}
					map[i][j] = "2";
					if (linked_2(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "2";
					}
					map[i][j] = "3";
					if (linked_3(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "3";
					}
					map[i][j] = "4";
					if (linked_4(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "4";
					}
					map[i][j] = "+";
					if (linked_plus(new int[] { i, j })) {
						a = i;
						b = j;
						fix = "+";
					}
					map[i][j] = ".";
				}
			}
		}

		System.out.println((a + 1) + " " + (b + 1) + " " + fix);

	}

	// | 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_or(int[] position) {
		if (position[0] + 1 >= r || position[0] - 1 < 0)
			return false;
		if (topOpen.contains(map[position[0] + 1][position[1]])
				&& bottomOpen.contains(map[position[0] - 1][position[1]]))
			return true;
		return false;
	}

	// - 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_minus(int[] position) {
		if (position[1] - 1 < 0 || position[1] + 1 >= c)
			return false;
		if (rightOpen.contains(map[position[0]][position[1] - 1])
				&& leftOpen.contains(map[position[0]][position[1] + 1]))
			return true;
		return false;
	}

	// + 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_plus(int[] position) {
		if (position[0] + 1 >= r || position[0] - 1 < 0 || position[1] + 1 >= c || position[1] - 1 < 0)
			return false;
		StringBuilder sb = new StringBuilder();
		sb.append(map[position[0] - 1][position[1]]).append(map[position[0] + 1][position[1]])
			.append(map[position[0]][position[1] - 1]).append(map[position[0]][position[1] + 1]);
		String temp = sb.toString();
		if(temp.contains("M") && temp.contains("Z")) 
			return false;
		if (bottomOpen.contains(map[position[0] - 1][position[1]])
				&& topOpen.contains(map[position[0] + 1][position[1]])
				&& rightOpen.contains(map[position[0]][position[1] - 1])
				&& leftOpen.contains(map[position[0]][position[1] + 1]))
			return true;
		return false;
	}

	// 1 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_1(int[] position) {
		if (position[0] + 1 >= r || position[1] + 1 >= c)
			return false;
		if (topOpen.contains(map[position[0] + 1][position[1]]) && leftOpen.contains(map[position[0]][position[1] + 1]))
			return true;
		return false;
	}

	// 2 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_2(int[] position) {
		if (position[0] - 1 < 0 || position[1] + 1 >= c)
			return false;
		if (bottomOpen.contains(map[position[0] - 1][position[1]])
				&& leftOpen.contains(map[position[0]][position[1] + 1]))
			return true;
		return false;
	}

	// 3 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_3(int[] position) {
		if (position[0] - 1 < 0 || position[1] - 1 < 0)
			return false;
		if (rightOpen.contains(map[position[0]][position[1] - 1])
				&& bottomOpen.contains(map[position[0] - 1][position[1]]))
			return true;
		return false;
	}

	// 4 타입을 만났을 때 이어져있는지 확인
	public static boolean linked_4(int[] position) {
		if (position[0] + 1 >= r || position[1] - 1 < 0)
			return false;
		if (rightOpen.contains(map[position[0]][position[1] - 1])
				&& topOpen.contains(map[position[0] + 1][position[1]]))
			return true;
		return false;
	}

}