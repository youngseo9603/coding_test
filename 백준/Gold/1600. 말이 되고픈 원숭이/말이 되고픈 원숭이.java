import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,0,1,-1,2,2,1,1,-2,-2,-1,-1};
	static int[] dy = {1,-1,0,0,1,-1,2,-2,1,-1,2,-2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int map[][] = new int[h][w];
		boolean visited[][][] = new boolean[h][w][k+1];
		
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,k,0});
		visited[0][0][0] = true;
		boolean flag = false;
		int cnt = 0;
		
		int[] temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			
			if(temp[0] == h-1 && temp[1] == w-1) {
				cnt = temp[3];
				flag = true;
				break;
			}
			
			for(int d=0; d<12; d++) {
				int x = temp[0] + dx[d];
				int y = temp[1] + dy[d];
				
				if(d < 4 && x>=0 && y>=0 && x<h && y<w && map[x][y]==0 && !visited[x][y][temp[2]]) {
					queue.add(new int[] {x,y,temp[2],temp[3]+1});
					visited[x][y][temp[2]] = true;
				}
				else if(temp[2] > 0 && x>=0 && y>=0 && x<h && y<w && map[x][y]==0 && !visited[x][y][temp[2]-1]){
					queue.add(new int[] {x,y,temp[2]-1,temp[3]+1});
					visited[x][y][temp[2]-1] = true;
				}
				
			}
		}
		
		if(flag)
			System.out.println(cnt);
		else
			System.out.println(-1);
		
		
	}

}