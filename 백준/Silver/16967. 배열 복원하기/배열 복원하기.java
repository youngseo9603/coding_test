
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[h+x][w+y];
		int[][] a = new int[h][w];
		
		for(int i=0; i<h+x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w+y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i<h && j<w) {
					a[i][j] += map[i][j];
					if(i+2*x<h+x && j+2*y<w+y) {
						a[i+x][j+y] -= a[i][j];
					}
				}
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) 
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
		
		
		
		
		
	}
}