import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
			if(max<dp[i])	max = dp[i];
		System.out.println(max);
	}

}