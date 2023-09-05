import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+2][2];
		dp[1][0] = 1;
		
		for(int i=2; i<=n+1; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1])%10007;
			dp[i][1] = (dp[i-1][0] * 2)%10007;
		}
		
		int answer = (dp[n][0]+dp[n][1])%10007;
		
		System.out.println(answer);
	}

}