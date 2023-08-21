import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if(w == 0 && h == 0) {
				break;
			}
			
			int[][] graph = new int[h][w];
			int[][] visited = new int[h][w];
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			int[] dx = {0,0,-1,1,1,1,-1,-1};
			int[] dy = {1,-1,0,0,1,-1,1,-1};
			
			int answer = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if (graph[i][j] == 1 && visited[i][j] == 0){
						Stack<int[]> stack = new Stack<>();
						stack.push(new int[] {i,j});
						visited[i][j] = 1;
						while(!stack.empty()) {
							int arr[] = stack.pop();
							for(int k=0; k<8; k++) {
								int d_x = dx[k] + arr[0];
								int d_y = dy[k] + arr[1];
								
								if(d_x >= 0 && d_y >= 0 && d_x <h && d_y < w && graph[d_x][d_y] == 1 && visited[d_x][d_y] == 0) {
									stack.push(new int[] {d_x, d_y});
									visited[d_x][d_y] = 1;
								}
							}
						}
						answer++;
					}
				}
			}
			
			System.out.println(answer);
			
			
		}

	}

}