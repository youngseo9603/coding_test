import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2024_1_2_1 {

	static int R;
	static int C;
	static int K;
	static int[][] map;
	static int[][] index;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[R + 3][C];
		index = new int[R+3][C];
		int answer = 0;
		int cnt = 1;

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			Golem golem = new Golem(c,d);
			
//			System.out.println(golem.r + " " + golem.c);
			
			go(golem);
			
			
			
			for(int i=0; i<R+3; i++) {
				for(int j=0; j<C; j++)
					if(map[i][j] != 0 && index[i][j] == 0)
						index[i][j] = cnt;
			}
			cnt++;
			
			boolean over = false;
			for(int i=0; i<3; i++)
				for(int j=0; j<C; j++)
					if(map[i][j] != 0) {
						over = true;
						break;
					}
			
//			for(int i=0; i<R+3; i++) {
//				for(int j=0; j<C; j++)
//					System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
			
			if(over) {
				map = new int[R + 3][C];
				index = new int[R+3][C];
				cnt = 1;
			}
			else {
				int a = addAnswer(golem);
				answer += a;
//				System.out.println(a);
			}
			
		}
		
		System.out.println(answer);
	}
	
	public static void go(Golem golem) {
		golem = goDown(golem);
		if(golem.move)	go(golem);
		golem = goLeft(golem);
		if(golem.move)	go(golem);
		golem = goRight(golem);
		if(golem.move)	go(golem);
		
	}

	public static class Golem {
		int r;
		int c;
		int d;
		boolean move;

		Golem(int c, int d) {
			this.r = 1;
			this.c = c;
			this.d = d;
			this.move = true;
		}

	}
	
	public static int addAnswer(Golem golem) {
		int res = golem.r;
		Stack<int[]> stack = new Stack<>();
		boolean[][] visited = new boolean[R+3][C];
		
		stack.add(new int[] {golem.r, golem.c});
		visited[golem.r][golem.c] = true; 
		
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			res = Math.max(res, cur[0]);
			
			for(int d=0; d<4; d++) {
				int x = cur[0] + dx[d];
				int y = cur[1] + dy[d];
				
				if(x>=0 && x<R+3 && y>=0 && y<C && !visited[x][y] && map[x][y] != 0) {
					
					if(index[cur[0]][cur[1]] == index[x][y]) { // 같은 칸 이동
						stack.add(new int[] {x,y});
						visited[x][y] = true;
					}
					
					else { // 다른 칸 이동
						if (map[cur[0]][cur[1]] == 2 && map[x][y] != 0) {
							stack.add(new int[] {x,y});
							visited[x][y] = true;
						}
					}
				}
			}
			
		}
		
		
		
		return res - 2;
	}

	public static Golem goDown(Golem golem) {
		if (golem.r > 0 && golem.c < C-1 && golem.r < R+1 && golem.c > 0 && map[golem.r + 2][golem.c] == 0 && map[golem.r + 1][golem.c + 1] == 0
				&& map[golem.r + 1][golem.c - 1] == 0) {
			golem.r++;
			map[golem.r - 2][golem.c] = 0;
			map[golem.r - 1][golem.c - 1] = 0;
			map[golem.r - 1][golem.c + 1] = 0;

			map[golem.r][golem.c] = 1;
			for (int d = 0; d < 4; d++) {
				map[golem.r + dx[d]][golem.c + dy[d]] = 1;
				if (d == golem.d)
					map[golem.r + dx[d]][golem.c + dy[d]] = 2;
			}

			golem.move = true;
		}

		else {
			golem.move = false;
		}

		return golem;
	}

	public static Golem goLeft(Golem golem) {

		if (golem.r > 0 && golem.c < C-1 && golem.r < R+1 && golem.c > 1 && map[golem.r - 1][golem.c - 1] == 0 && map[golem.r][golem.c - 2] == 0 && map[golem.r + 1][golem.c - 2] == 0
				&& map[golem.r + 1][golem.c - 1] == 0 && map[golem.r + 2][golem.c - 1] == 0) {

			golem.d -= 1;
			if (golem.d == -1)
				golem.d += 4;

			map[golem.r][golem.c] = 0;
			for (int d = 0; d < 4; d++)
				map[golem.r + dx[d]][golem.c + dy[d]] = 0;
			golem.r++;
			golem.c--;

			map[golem.r][golem.c] = 1;
			for (int d = 0; d < 4; d++) {
				map[golem.r + dx[d]][golem.c + dy[d]] = 1;
				if (d == golem.d)
					map[golem.r + dx[d]][golem.c + dy[d]] = 2;
			}
			golem.move = true;
		} 
		else
			golem.move = false;

		return golem;
	}

	public static Golem goRight(Golem golem) {
		
		if (golem.r > 0 && golem.c < C-2 && golem.r < R+1 && golem.c >= 1 && map[golem.r - 1][golem.c + 1] == 0 && map[golem.r][golem.c + 2] == 0 && map[golem.r + 1][golem.c + 2] == 0
				&& map[golem.r + 1][golem.c + 1] == 0 && map[golem.r + 2][golem.c + 1] == 0) {

			golem.d += 1;
			if (golem.d == 4)
				golem.d -= 4;

			map[golem.r][golem.c] = 0;
			for (int d = 0; d < 4; d++)
				map[golem.r + dx[d]][golem.c + dy[d]] = 0;
			golem.r++;
			golem.c++;

			map[golem.r][golem.c] = 1;
			for (int d = 0; d < 4; d++) {
				map[golem.r + dx[d]][golem.c + dy[d]] = 1;
				if (d == golem.d)
					map[golem.r + dx[d]][golem.c + dy[d]] = 2;
			}
			golem.move = true;
		} 
		else {
			golem.move = false;
		}

		return golem;
	}

}
