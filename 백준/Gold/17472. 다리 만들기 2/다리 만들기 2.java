import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int land_num;
	static int[] visit;
	static ArrayList<bridge> bridges;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		String[] t;
		for (int i = 0; i < n; i++) {
			t = bf.readLine().split(" ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(t[j]);
		}

		land_num = 1;
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && visited[i][j] == 0) {
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] { i, j });
					map[i][j] = land_num;
					visited[i][j] = 1;
					while (!stack.isEmpty()) {
						int[] xy = stack.pop();
						for (int d = 0; d < 4; d++) {
							int x = dx[d] + xy[0];
							int y = dy[d] + xy[1];

							if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] != 0 && visited[x][y] == 0) {
								map[x][y] = land_num;
								stack.add(new int[] { x, y });
								visited[x][y] = 1;
							}
						}
					}
					land_num++;
				}
			}
		}
		land_num--;
		bridges = new ArrayList<>();

		int cnt;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					int temp_i = i;
					int temp_j = j;
					int land = map[i][j];
					//상 
					cnt = 0;
					while(--i>=0) {
						if(map[i][j]==0) {
							cnt++;
							continue;
						}
						else if(map[i][j]!=0) {
							if(cnt>=2 && land != map[i][j]) {
								bridges.add(new bridge(land, map[i][j], cnt));
								break;
							}
							else break;
						}
					}
					//하
					cnt = 0;
					i = temp_i;
					j = temp_j;
					while(++i<n) {
						if(map[i][j] == 0) {
							cnt++;
							continue;
						}
						else if(map[i][j]!=0) {
							if(cnt>=2 && land != map[i][j]) {
								bridges.add(new bridge(land, map[i][j], cnt));
								break;
							}
							else break;
						}
					}
					//좌
					cnt = 0;
					i = temp_i;
					j = temp_j;
					while(--j>=0) {
						if(map[i][j] == 0) {
							cnt++;
							continue;
						}
						else if(map[i][j]!=0) {
							if(cnt>=2 && land != map[i][j]) {
								bridges.add(new bridge(land, map[i][j], cnt));
								break;
							}
							else break;
						}
					}
					//우
					cnt = 0;
					i = temp_i;
					j = temp_j;
					while(++j<m) {
						if(map[i][j] == 0) {
							cnt++;
							continue;
						}
						else if(map[i][j]!=0) {
							if(cnt>=2 && land != map[i][j]) {
								bridges.add(new bridge(land, map[i][j], cnt));
								break;
							}
							else break;
						}
					}
					i = temp_i;
					j = temp_j;
				}
			}
		}
		
		
		Collections.sort(bridges);
		
//		for(int i=0; i<bridges.size(); i++) {
//			for(int j=i+1; j<bridges.size(); j++) {
//				
//				if( (bridges.get(i).start == bridges.get(j).start && bridges.get(i).end == bridges.get(j).end) || (bridges.get(i).start == bridges.get(j).end && bridges.get(i).end == bridges.get(j).start) || (bridges.get(i).end == bridges.get(j).start && bridges.get(i).start == bridges.get(j).end)) {
//					if(bridges.get(i).length < bridges.get(j).length) {
//						bridges.remove(j);
//						j--;
//					}
//					
//				}
//			}
//		}
		
		parent = new int[land_num+1];
		int total = 0;
		for(int i=1; i<parent.length; i++)
			parent[i] = i;
		

		int flag = 0;
		
		for(int i=0; i<bridges.size(); i++) {
			if(find(bridges.get(i).start) != find(bridges.get(i).end)) {
				if(union(bridges.get(i))) {
					total += bridges.get(i).length;
					flag ++;
				}
			}
		}
		
		if(flag <= land_num-2) {
			System.out.println(-1);
		}
		else
			System.out.println(total);
		
	}
	
	static class bridge implements Comparable<bridge> {
		int start;
		int end;
		int length;

		bridge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(bridge o) {
			if(this.length > o.length)
				return 1;
			else if(this.length < o.length)
				return -1;
			return 0;
		}
	}
	
	
	static int find(int i) {
		if(parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}
	
	static boolean union(bridge b1) {
		
		int s = find(b1.start);
		int e = find(b1.end);
		
		if (s == e)
			return false;
		
		if(s < e)
			parent[s] = e;
		else 
			parent[e] = s;
		return true;
	}
	
}




/*
 * 1	2 3
 * 		2 4
 * 		3 4
 * 
 * 
 */