import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int answer;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<m; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
		answer = Integer.MIN_VALUE;
		
		dfs(0);
		System.out.println(answer);
	}
	
	public static void dfs(int depth) {
		if(depth == 3) {
			int[][] virusMap = spread();
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
					if(virusMap[i][j] == 0)
						cnt++;
			}
			answer = Math.max(cnt, answer);
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static int[][] spread() {
		int[][] r = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				r[i][j] = map[i][j];
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(r[i][j] == 2 && !visited[i][j]) {
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] {i,j});
					while(!stack.isEmpty()) {
						int[] temp = stack.pop();
						
						for(int d=0; d<4; d++) {
							int x = temp[0] + dx[d];
							int y = temp[1] + dy[d];
							
							if(x>=0 && y>=0 && x<n && y<m && map[x][y] != 1 && !visited[x][y]) {
								stack.add(new int[] {x,y});
								r[x][y] = 2;
								visited[x][y] = true;
							}
						}
					}
				}
			}
		}
		
		return r;
	}
}