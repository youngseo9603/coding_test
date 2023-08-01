import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = bf.readLine();
		StringTokenizer st = new StringTokenizer(temp);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n];
		
		dfs(n,m,0);
	}
	
	public static void dfs(int n, int m, int cnt) {
		if(cnt == m) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i=0; i<n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arr[cnt] = i+1;
				dfs(n, m, cnt+1);
				visited[i] = false;
			}
		}
	}
	
}
