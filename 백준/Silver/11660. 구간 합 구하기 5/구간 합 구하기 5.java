import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] sumGraph = new int[n][n];
		int[][] col = new int[n+1][n+1];
		int sum = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken()); 
				sum += temp;
				sumGraph[i][j] = sum;
				
				col[i+1][j+1] = col[i][j+1] + temp;
			}
		}
		
	
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int colSum = 0;
			
			for(int c=y1; c<=y2; c++) {
				colSum += col[x2][c] - col[x1-1][c];
			}
			
			System.out.println(colSum);
		
		}
		

	}

}