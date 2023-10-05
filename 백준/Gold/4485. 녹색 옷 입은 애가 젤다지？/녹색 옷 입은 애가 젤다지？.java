import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int[][] dist;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0)	break;
			map = new int[n][n];
			visited = new boolean[n];
			dist = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String[] temp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			
			cnt++;
			sb.append("Problem ").append(cnt).append(": ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static class Node{
		private int x;
		private int y;
		private int weight;
		private Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.weight = w;
		}
		
	}
	
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.weight-o2.weight);

		dist[0][0] = map[0][0];
		pq.add(new Node(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int d=0; d<4; d++) {
				int x = node.x + dx[d];
				int y = node.y + dy[d];
				
				if(x>=0 && y>=0 && x<n && y<n && (dist[x][y] > dist[node.x][node.y] + map[x][y])) {
					dist[x][y] = dist[node.x][node.y] + map[x][y];
					pq.offer(new Node(x,y,dist[x][y]));
				}
			}
		}
		
		return dist[n-1][n-1];
	}

}