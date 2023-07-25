import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for (int t=0; t<testcase; t++ ) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] graph = new int [n][m];
			int[][] visited = new int [n][m];
			for(int i=0; i<k ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[y][x] = 1;
			}
			
			int dx[] = {0,0,1,-1};
			int dy[] = {1,-1,0,0};
			int answer = 0;
			
			for(int i=0; i<n ; i++) {
				for(int j=0; j<m ; j++) {
					Stack<int[]> stack = new Stack<>();
					if(graph[i][j] == 1 && visited[i][j] == 0) {
						visited[i][j] = 1;
						stack.push(new int[] {i,j});
						while(!stack.isEmpty()) {
						
							int[] arr = stack.pop();
							for(int z=0 ; z<4 ; z++) {
								int d_x = arr[0] + dx[z];
								int d_y = arr[1] + dy[z];
								if(d_x >= 0 && d_y >= 0 && d_x < n && d_y < m && graph[d_x][d_y] == 1 && visited[d_x][d_y] == 0) {
									visited[d_x][d_y] = 1;
									stack.push(new int[] {d_x, d_y});
								}		
							}
						}
						answer++;
					}
				}
			}
			
			System.out.println(answer);
			
		}
		
	}
}
