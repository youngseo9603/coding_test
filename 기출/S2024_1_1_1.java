import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2024_1_1_1 {
	
	public static int k;
	public static int m;
	public static int[] f;
	public static int index;
	public static int[][] map;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	
	public static class MapAndT {
		
		int[][] m;
		int t;
		
		MapAndT(int[][] m, int t){
			this.m = m;
			this.t = t;
		}
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[5][5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		f = new int[m];
		for(int i=0; i<m; i++)
			f[i] = Integer.parseInt(st.nextToken());
		
		index = 0;
		
		
		for(int i=0; i<k; i++) {
			int answer = 0;
			
			MapAndT mnt = find();
			if(mnt.t == 0) {
				break;
			}
			answer += mnt.t;
			map = fill(mnt.m);
			mnt = gain(map);
			map = fill(mnt.m);
			while(mnt.t != 0) {
				answer += mnt.t;
				mnt = gain(map);
				map = fill(mnt.m);
			}
			
			System.out.print(answer + " ");
		}
		
		

	}
	
	public static int[][] fill(int[][] map){
		
		for(int i=0; i<5; i++) {
			for(int j=4; j>=0; j--) {
				if(map[j][i] == 0) {
					map[j][i] = f[index];
					index++;
				}
			}
		}
		
		return map;
	}
	
	public static MapAndT find() {
		
		int[][] cur = new int[5][5];
		int[][] next = new int[5][5];
		
		int treasure = -1;
		
		for(int d = 1; d < 4; d++) { // 90 180 270도
			
			for(int j=1; j<4; j++) {
				for(int i=1; i<4; i++) {
					cur = rotate(d, i, j);
					MapAndT mt = gain(cur);  
					if(mt.t > treasure) {
						for(int a=0; a<5; a++)
							for(int b=0; b<5; b++)
								next[a][b] = mt.m[a][b];
						treasure = mt.t;
					}
				}
			}
			
		}
		
		MapAndT mnt = new MapAndT(next, treasure);
		return mnt;
	}
	
	public static int[][] rotate(int d, int i, int j){
		int[][] next = new int[5][5];
		int[][] cur = new int[5][5];
		
		for(int a=0; a<5; a++)
			for(int b=0; b<5; b++) {
				next[a][b] = map[a][b];
				cur[a][b] = map[a][b];
			}
		
		
		for(int k=0; k<d; k++) {
			next[i-1][j-1] = cur[i+1][j-1];
			next[i-1][j] = cur[i][j-1];
			next[i-1][j+1] = cur[i-1][j-1];
			next[i][j+1] = cur[i-1][j];
			next[i+1][j+1] = cur[i-1][j+1];
			next[i+1][j] = cur[i][j+1];
			next[i+1][j-1] = cur[i+1][j+1];
			next[i][j-1] = cur[i+1][j];
			
			for(int a=0; a<5; a++)
				for(int b=0; b<5; b++)
					cur[a][b] = next[a][b];
			
		}
		
		
		return next;
	}
	
	static void print(int[][] m) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static MapAndT gain(int[][] m) {
		int t = 0;
		
		Stack<int[]> stack = new Stack();
		boolean[][] visited = new boolean[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(!visited[i][j] && m[i][j] != 0) {
					
					stack = new Stack<>();
					ArrayList<int[]> list = new ArrayList<>();
					stack.add(new int[] {i,j});
					list.add(new int[] {i,j});
					visited[i][j] = true;
					int cnt = 1;
					while(!stack.isEmpty()) {
						int[] cur = stack.pop();
						
						for(int d=0; d<4; d++) {
							int x = cur[0] + dx[d];
							int y = cur[1] + dy[d];
							
							if(x>=0 && y>=0 && x<5 && y<5 && !visited[x][y] && m[i][j] != 0 && m[i][j] == m[x][y]) {
								stack.add(new int[] {x,y});
								cnt++;
								list.add(new int[] {x,y});
								visited[x][y] = true;
							}
						}
					}
					
					if(cnt >= 3) {
						t += cnt;
						for(int[] l : list) {
							m[l[0]][l[1]] = 0;
						}
						
					}
					
				}
			}
		}
		
		MapAndT res = new MapAndT(m,t);
		
		return res;
	}

}

/*
 * 	
 * 
 */
