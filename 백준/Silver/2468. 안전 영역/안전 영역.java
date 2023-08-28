import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] visited;
		int max_height = 0;
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				max_height = Math.max(max_height, map[i][j]);
			}
		}
		
		int answer = 0;
		for(int h=0; h<max_height; h++) {
			int cnt = 0;
			visited = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					Stack<int[]> stack = new Stack<>();
					if (map[i][j] > h && visited[i][j] == 0) {
						stack.add(new int[] {i,j});
						visited[i][j] = 1;
						while(!stack.isEmpty()) {
							int[] temp = stack.pop();
							for(int d=0; d<4; d++) {
								int x = dx[d] + temp[0];
								int y = dy[d] + temp[1];
								
								if(x>=0 && y>=0 && x<n && y<n && visited[x][y] == 0 && map[x][y]>h) {
									stack.add(new int[] {x,y});
									visited[x][y] = 1;
								}
								
							}
						}
						cnt++;
					}
				}
			}
			
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
		
		
	}

}