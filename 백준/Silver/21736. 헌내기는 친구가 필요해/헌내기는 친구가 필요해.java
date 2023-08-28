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
		
		String[][] map = new String[n][m];
		int[][] visited = new int[n][m];
		Stack<int[]> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = s[j];
				if(map[i][j].equals("I")) {
					stack.add(new int[] {i,j});
					visited[i][j] = 1;
				}
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int answer = 0;
		
		while(!stack.isEmpty()) {
			int[] temp = stack.pop();
			
			for(int i=0; i<4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if(x>=0 && y>=0 && x<n && y<m && !map[x][y].equals("X") && visited[x][y] == 0) {
					stack.add(new int[] {x,y});
					visited[x][y] = 1;
					if(map[x][y].equals("P"))
						answer++;
				}
			}
		}
		
		if(answer == 0)
			System.out.println("TT");
		else System.out.println(answer);
		
	}
}