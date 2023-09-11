import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] food = new int[n][m];
		
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			food[r-1][c-1] = 1;
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int answer = 0;
		
		int[][] visited = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j] == 0 && food[i][j] == 1) {
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] {i,j});
					int cnt = 1;
					visited[i][j] = 1;
					while(!stack.isEmpty()) {
						int temp[] = stack.pop();
						for(int d=0; d<4; d++) {
							int x = dx[d] + temp[0];
							int y = dy[d] + temp[1];
							
							if(x>=0 && x<n && y>=0 && y<m && visited[x][y] == 0 && food[x][y] == 1) {
								stack.add(new int[] {x,y});
								visited[x][y] = 1;
								cnt++;
							}
						}
					}
					
					answer = Math.max(answer, cnt);
					
				}
			}
		}
		
		System.out.println(answer);
	}
}