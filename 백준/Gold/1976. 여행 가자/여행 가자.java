import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
		
		int[] p = new int[m];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<m; i++)
			p[i] = Integer.parseInt(s[i])-1;
		
		int[] visited = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.add(p[0]);
		visited[p[0]] = 1;
		while(!stack.isEmpty()) {
			int k = stack.pop();
			for(int i=0; i<n; i++) {
				if(map[k][i] == 1 && visited[i] ==0) {
					stack.add(i);
					visited[i] = 1;
				}
			}
		}
		
		int flag = 0;
		for(int i: p) {
			if(visited[i] != 1) {
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}

}