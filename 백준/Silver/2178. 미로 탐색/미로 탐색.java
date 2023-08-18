import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int n;
	static int m;
	static int[][] visited;
	static int[][] answer;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new int[n][m];
		answer = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = bf.readLine();
			for(int j=0; j<m; j++)
				arr[i][j] = s.charAt(j) - 48;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,1});
		visited[0][0] = 1;
		int answer = 0;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			if(x==n-1 && y==m-1)
				answer = temp[2];
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==0 && arr[nx][ny]==1) {
					queue.add(new int[] {nx, ny, temp[2]+1});
					visited[nx][ny] = 1;
				}
				
			}
		}
		
		System.out.println(answer);
	}

}