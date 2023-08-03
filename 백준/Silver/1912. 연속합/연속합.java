import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] num = new int[n];
		
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n];
		dp[0] = num[0];
		
		int max = num[0];
		for(int i=1; i<n; i++) {
			dp[i] = dp[i-1] + num[i];
			if(dp[i] < 0) 
				dp[i] = 0;
			if(max < num[i])
				max = num[i];
		}
		
		int answer = 0;
		for(int i=0; i<n; i++)
			if(dp[i] > answer)
				answer = dp[i];
		
		if(answer == 0)  System.out.println(max);
		else	System.out.println(answer);

	}

}