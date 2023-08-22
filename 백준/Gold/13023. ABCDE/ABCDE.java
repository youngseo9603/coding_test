import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for (int i = 0; i < n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new int[n];
		
		for(int i=0; i<n; i++) {
			if(flag == 0)
				dfs(i, 0);
		}
		
		if (flag ==0)
			System.out.println(0);
		else
			System.out.println(1);
	}
	
	static int flag = 0;
	static void dfs(int node, int depth) {
		
		
		if(depth == 4) {
			flag = 1;
			return;
		}
		visited[node] = 1;
		for(int d=0; d<list[node].size(); d++) {
			if(visited[list[node].get(d)] == 0) {
				dfs(list[node].get(d), depth+1);
			}
		}
		
		visited[node] = 0;
		
	}
	

}


/*
 * 0,0
 * 1,1  3,1
 * 2,2  
 * 
 * 
 */