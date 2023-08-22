import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[m][2];
		List<Integer>[] list = new ArrayList[n+1];
		int[] node = new int[n+1];
		
		for(int i=1; i<n+1; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			node[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<n+1; i++) 
			if(node[i] == 0)	q.add(i);
		
		while(!q.isEmpty()) {
			int k = q.poll();
			System.out.print(k + " ");
			for(int i=0; i<list[k].size(); i++) {
				if(--node[list[k].get(i)] == 0)
					q.add(list[k].get(i));
				
			}
		}		
	}
	

}