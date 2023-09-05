import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int[][] map;
	static int n; 
	static int[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++) 
				map[i][j] = Integer.parseInt(s[j]);
		}
		
		int answer[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			visited = new int[n];
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && visited[j] == 0) {
					visited[j] = 1;
					dfs(j);
				}
			}
			
			for(int j=0; j<n; j++)
				answer[i][j] = visited[j];
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int x) {
		
		for(int i=0; i<n; i++) {
			if(map[x][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}

}