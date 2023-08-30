import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
		
		
		long [][][] dp = new long[n+1][n+1][3]; //가로0, 세로1, 대각2
		dp[0][0][0] = 1; 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 && j==0)
					continue;
				if(map[i][j] == 1)
					continue;
				
				if(i-1>=0 && j-1>=0) {
					dp[i][j][0] = dp[i-1][j-1][2] + dp[i][j-1][0];
					dp[i][j][1] = dp[i-1][j-1][2] + dp[i-1][j][1];
					dp[i][j][2] = dp[i-1][j-1][2] + dp[i-1][j][1] + dp[i][j-1][0];
				}
				else if (j-1>=0 && i-1<0) {
					dp[i][j][0] = dp[i][j-1][0];
					dp[i][j][2] = dp[i][j-1][0];
				}
				else {
					dp[i][j][1] = dp[i-1][j][1];
					dp[i][j][2] = dp[i-1][j][1];
				}
				
				if(i+1 < n && map[i+1][j] == 1) {
					dp[i][j][1] = 0;
					dp[i][j][2] = 0;
				}
				if(j+1 < n && map[i][j+1] == 1) {
					dp[i][j][0] = 0;
					dp[i][j][2] = 0;
				}
				if(i+1 < n && j+1 < n && map[i+1][j+1] == 1)
					dp[i][j][2] = 0;
				
			}
		}
		long answer = dp[n-2][n-2][2]+dp[n-1][n-2][0]+dp[n-2][n-1][1];
		System.out.println(answer);
		
	}

}