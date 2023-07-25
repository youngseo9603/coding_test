import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] consult = new int[n][2];
		for(int i=0; i<n ; i++) {
			consult[i][0] = sc.nextInt();
			consult[i][1] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		for(int i=n-1; i>=0; i--) {
			if( i + consult[i][0] > n) {
				dp[i] = dp[i+1];
			}
			else {
				dp[i] = Math.max(dp[i+1], dp[i + consult[i][0]] + consult[i][1]);
			}
		}
		
		System.out.println(dp[0]);
	}
}
