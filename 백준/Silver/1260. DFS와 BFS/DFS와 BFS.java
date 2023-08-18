import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[][] lines = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lines[s][e] = 1;
			lines[e][s] = 1;
		}
		
		int[] visited = new int[n+1];
		
		Stack<Integer> stack = new Stack<>();
		stack.add(v);
		visited[v] = 1;
		System.out.print(v + " ");
		while(!stack.empty()) {
			int t = stack.pop();
			
			if(visited[t] == 0) {
				visited[t] = 1;	
				System.out.print(t + " ");
			}
			
			for(int i=n; i>0; i--) {
				if(lines[t][i] == 1 && visited[i] == 0) {
					stack.add(i);
					//visited[i] = 1;
				}
			}
		}
		
		System.out.println();
		visited = new int[n+1];
		Deque<Integer> deque = new LinkedList<>();
		deque.add(v);
		visited[v] = 1;
		System.out.print(v + " ");
		while(!deque.isEmpty()) {
			int t = deque.poll();
			for(int i=0; i<n+1; i++) {
				if(lines[t][i] == 1 && visited[i] == 0) {
					deque.add(i);
					visited[i] = 1;
					System.out.print(i + " ");
				}
			}
		}
		
	}

}