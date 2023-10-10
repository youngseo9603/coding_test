import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] wind1 = { -1, -1 };
	static int[] wind2 = { -1, -1 };
	static int cnt1; // c-wind[1], wind1[0], c, wind1[0], wind[1]
	static int cnt2; //
	static int[] start1 = { -1, -1 };
	static int[] start2 = { -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == -1) {
					if (start1[0] == -1) {
						start1[0] = i;
						start1[1] = j;
					} else {
						start2[0] = i;
						start2[1] = j;
					}
					map[i][j] = 0;
				}
			}
		}

		while (t-- > 0) {
			spread();
			push1();
			push2();
		}
		
		int answer = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer);

	}

	public static void spread() {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 0)
					list.add(new int[] { i, j, map[i][j] });
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int x = list.get(i)[0] + dx[d];
				int y = list.get(i)[1] + dy[d];

				if (x >= 0 && y >= 0 && x < r && y < c && !(x == start1[0] && y == start1[1])
						&& !(x == start2[0] && y == start2[1])) {
					map[x][y] += list.get(i)[2] / 5;
					cnt += list.get(i)[2] / 5;
				}
			}
			map[list.get(i)[0]][list.get(i)[1]] -= cnt;
		}
	}

	public static void push1() {
		
		wind1[0] = start1[0];
		wind1[1] = start1[1];
		int dust = 0;
		
		for(int cnt=0; cnt<2*c+2*start1[0]-2; cnt++) {
			if(cnt < c-start1[1]-1) {
				int temp = dust;
				dust = map[wind1[0]][wind1[1]];
				map[wind1[0]][wind1[1]] = temp;
				wind1[1] = wind1[1]+1;
			}
			else if(cnt < c-start1[1]+start1[0]-1) {
				int temp = dust;
				dust = map[wind1[0]][wind1[1]];
				map[wind1[0]][wind1[1]] = temp;
				wind1[0] = wind1[0]-1;
			}
			else if(cnt < c-start1[1]+start1[0]+c-2) {
				int temp = dust;
				dust = map[wind1[0]][wind1[1]];
				map[wind1[0]][wind1[1]] = temp;
				wind1[1] = wind1[1]-1;
			}
			else if(cnt < c-start1[1]+2*start1[0]+c-2){
				int temp = dust;
				dust = map[wind1[0]][wind1[1]];
				map[wind1[0]][wind1[1]] = temp;
				wind1[0] = wind1[0]+1;
			}
			else {
				int temp = dust;
				dust = map[wind1[0]][wind1[1]];
				map[wind1[0]][wind1[1]] = temp;
				wind1[1] = wind1[1]+1;
			}
		}
		map[start1[0]][start1[1]] = 0;

	}

	public static void push2() {
		wind2[0] = start2[0];
		wind2[1] = start2[1];
		int dust = 0;
		
		for(int cnt=0; cnt<2*c+2*(r-start2[0])-2; cnt++) {
			
			if(cnt < c-start2[1]-1) {
				int temp = dust;
				dust = map[wind2[0]][wind2[1]];
				map[wind2[0]][wind2[1]] = temp;
				wind2[1] = wind2[1]+1;
			}
			else if(cnt < c-start2[1]+r-start2[0]-2) {
				int temp = dust;
				dust = map[wind2[0]][wind2[1]];
				map[wind2[0]][wind2[1]] = temp;
				wind2[0] = wind2[0]+1;
			}
			else if(cnt < 2*c-start2[1]+r-start2[0]-3) {
				int temp = dust;
				dust = map[wind2[0]][wind2[1]];
				map[wind2[0]][wind2[1]] = temp;
				wind2[1] = wind2[1]-1;
			}
			else if(cnt < 2*c-start2[1]+2*(r-start2[0])-4){
				int temp = dust;
				dust = map[wind2[0]][wind2[1]];
				map[wind2[0]][wind2[1]] = temp;
				wind2[0] = wind2[0]-1;
			}
			else {
				int temp = dust;
				dust = map[wind2[0]][wind2[1]];
				map[wind2[0]][wind2[1]] = temp;
				wind2[1] = wind2[1]+1;
			}
//			
//			for(int i=0; i<r; i++) {
//				for(int j=0; j<c; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
		}
		map[start2[0]][start2[1]] = 0;

	}
	
	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}