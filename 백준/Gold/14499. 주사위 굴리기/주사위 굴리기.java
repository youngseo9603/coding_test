import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
	public static int m;
	
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	public static int[][] map;
	
	public static class Dice {
		
		int x;
		int y;
		int[] num;
		
		Dice(int x, int y){
			this.x = x;
			this.y = y;
			this.num = new int[6]; //윗면, 북, 동, 서, 남, 밑면 
		}
		
		public boolean move(int d) {
			this.x += dx[d-1];
			this.y += dy[d-1];
			
			if(x<0 || x>n-1 || y<0 || y>m-1) {
				this.x -= dx[d-1];
				this.y -= dy[d-1];
				return false;
			}
			
			
			if(d == 1) {//동
				int[] res = {num[3], num[1], num[0], num[5], num[4], num[2]};
				this.num = res;
			}
			else if (d == 2) {// 서
				int[] res = {num[2], num[1], num[5], num[0], num[4], num[3]};
				this.num = res;
			}
			else if (d == 3) {// 북
				int[] res = {num[4], num[0], num[2], num[3], num[5], num[1]};
				this.num = res;
			}
			else if (d == 4) {// 남
				int[] res = {num[1], num[5], num[2], num[3], num[0], num[4]};
				this.num = res;
			}
			
			if(map[x][y] == 0) { // 바닥의 수가 map에 복사
				map[x][y] = num[5];
			}
			else {
				this.num[5] = map[x][y];
				map[x][y] = 0;
			}
			
			
			return true;
		}
		
		
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Dice dice = new Dice(x,y);
		
		int[] d = new int[k];
		st = new StringTokenizer(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			
			if(dice.move(d[i])) {
				sb.append(dice.num[0]).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}