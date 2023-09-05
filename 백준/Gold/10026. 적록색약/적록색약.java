import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		char[][] rg_map = new char[n][n];
		boolean[][] visited = new boolean[n][n];
		boolean[][] rg_visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				rg_map[i][j] = s.charAt(j);
				if(s.charAt(j) == 'G')
					rg_map[i][j] = 'R';
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		int cnt = 0;
		int rgcnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (!visited[i][j]) {
					cnt++;
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] { i, j });
					visited[i][j] = true;
					while(!stack.isEmpty()) {
						int[] temp = stack.pop();
						
						for(int d=0; d<4; d++) {
							int x = dx[d] + temp[0];
							int y = dy[d] + temp[1];
							
							if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && map[x][y] == map[i][j]) {
								visited[x][y] = true;
								stack.add(new int[] {x,y});
							}
						}
					}
				}
				
				if(!rg_visited[i][j]) {
					rgcnt++;
					Stack<int[]> rgstack = new Stack<>();
					rgstack.add(new int[] {i,j});
					rg_visited[i][j] = true;
					while(!rgstack.isEmpty()) {
						int[] temp = rgstack.pop();
						
						for(int d=0; d<4; d++) {
							int x = dx[d] + temp[0];
							int y = dy[d] + temp[1];
							
							if(x>=0 && y>=0 && x<n && y<n && !rg_visited[x][y] && rg_map[x][y] == rg_map[i][j]) {
								rg_visited[x][y] = true;
								rgstack.add(new int[] {x,y});
							}
						}
					}
				}
				
			}
		}
		
		System.out.println(cnt + " " + rgcnt);

	}

}