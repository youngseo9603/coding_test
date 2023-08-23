import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static LinkedList<cctv> c;
	static int[][] map;
	static int n;
	static int m;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		c = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					c.add(new cctv(i,j,map[i][j]));
				}
			}
		}
		
		cnt = Integer.MAX_VALUE;
		dfs(0);
		
		System.out.println(cnt);
	}
	
	static class cctv {
		int type;
		int x;
		int y;
		
		cctv(int x, int y, int type){
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static void dfs(int depth){
		
		if(depth == c.size()) {
			cnt = Math.min(count(), cnt);
			return;
		}
		
		if (c.get(depth).type == 1) {
			
			paint_right(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			
			paint_left(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_left(c.get(depth).x, c.get(depth).y);
			
			paint_up(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_up(c.get(depth).x, c.get(depth).y);
			
			paint_down(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_down(c.get(depth).x, c.get(depth).y);
		}
		else if (c.get(depth).type == 2) {
			
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_left(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_left(c.get(depth).x, c.get(depth).y);
			
			paint_up(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_up(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);
		}
		else if (c.get(depth).type == 3) {
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);

			paint_down(c.get(depth).x, c.get(depth).y);
			paint_left(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_down(c.get(depth).x, c.get(depth).y);
			repaint_left(c.get(depth).x, c.get(depth).y);
			
			paint_left(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_left(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			
		} 
		else if (c.get(depth).type == 4) {
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			paint_left(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			repaint_left(c.get(depth).x, c.get(depth).y);
			
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);
			
			paint_right(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			paint_left(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_right(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);
			repaint_left(c.get(depth).x, c.get(depth).y);
			
			paint_left(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_left(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);
		} 
		else if (c.get(depth).type == 5) {
			
			paint_left(c.get(depth).x, c.get(depth).y);
			paint_up(c.get(depth).x, c.get(depth).y);
			paint_down(c.get(depth).x, c.get(depth).y);
			paint_right(c.get(depth).x, c.get(depth).y);
			dfs(depth+1);
			repaint_left(c.get(depth).x, c.get(depth).y);
			repaint_up(c.get(depth).x, c.get(depth).y);
			repaint_down(c.get(depth).x, c.get(depth).y);
			repaint_right(c.get(depth).x, c.get(depth).y);
		}
		
	}
	
	static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (map[i][j] == 0)
					cnt++;
		return cnt;
	}
	
	static void paint_right(int x, int y) {
		while(++y<m && map[x][y] != 6) 
			if(map[x][y] <= 0)	map[x][y]--;
	}
	
	static void paint_left(int x, int y) {
		while(--y>=0 && map[x][y] != 6) 
			if(map[x][y] <= 0)	map[x][y]--;
	}
	
	static void paint_up(int x, int y) {
		while(--x>=0 && map[x][y] != 6) 
			if(map[x][y] <= 0)	map[x][y]--;
	}
	
	static void paint_down(int x, int y) {
		while(++x<n && map[x][y] != 6) 
			if(map[x][y] <= 0)	map[x][y]--;
	}
	
	
	static void repaint_right(int x, int y) {
		while(++y<m && map[x][y] != 6) 
			if(map[x][y] < 0)	map[x][y]++;
	}
	
	static void repaint_left(int x, int y) {
		while(--y>=0 && map[x][y] != 6) 
			if(map[x][y] < 0)	map[x][y]++;
	}
	
	static void repaint_up(int x, int y) {
		while(--x>=0 && map[x][y] != 6) 
			if(map[x][y] < 0)	map[x][y]++;
	}
	
	static void repaint_down(int x, int y) {
		while(++x<n && map[x][y] != 6) 
			if(map[x][y] < 0)	map[x][y]++;
	}

}