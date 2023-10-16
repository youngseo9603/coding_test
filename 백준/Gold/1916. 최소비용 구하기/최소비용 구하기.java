import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int INF = Integer.MAX_VALUE;
	static int n;
	static int m;
	static ArrayList<ArrayList<Node>> a;
	static int[] dist;
	static boolean[] visited;
	
	public static class Node implements Comparable<Node> {
		int start;
		int end;
		int d;
		
		Node(int start, int end, int d){
			this.start = start;
			this.end = end;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return d - o.d;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dist = new int[n+1];
		visited = new boolean[n+1];
		a = new ArrayList<>();
		
		Arrays.fill(dist, INF);
		
		int start;
		int end;
		int d;
		
		for(int i=0; i<n+1; i++)
			a.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			a.get(start).add(new Node(start, end, d));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken()); 
		
		System.out.println(dijkstra(start,end));
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue();
		visited = new boolean[n+1];
		pq.add(new Node(start,start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int c = cur.end;
			
			if(!visited[c]) {
				visited[c] = true;
				
				for(Node n : a.get(c)) {
					if(!visited[n.end] && dist[n.end] > dist[c] + n.d) {
						dist[n.end] = dist[c] + n.d;
						pq.add(new Node(n.start, n.end, dist[n.end]));
					}
				}
			}
		}
		
		return dist[end];
	}
}