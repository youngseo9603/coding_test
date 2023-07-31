import java.util.Scanner;

//public class BaekJoon2156 {
//	
//	static boolean[] visited;
//	static int n;
//	static int[] wine;
//	static int max = Integer.MIN_VALUE;
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		n = Integer.parseInt(br.readLine());
//		wine = new int [n+2];
//		
//		for(int i=0; i<n; i++) 
//			wine[i+2] = Integer.parseInt(br.readLine());
//		
//		visited = new boolean[n+2];
//		
//		iter(2);
//		System.out.println(max);
//		
//	}
//	
//	static void iter(int index) {
//		
//		if (index >= n+2) {
//			calc();
//			return;
//		}
//		
//		for(int i=index; i<n+2; i++) {
//			if(visited[i-1] == false | visited[i-2] == false ) 
//				visited[i] = true;
//			
//			iter(i+1);
//			visited[i] = false;
//		}
//		
//	}
//	
//	static void calc() {
//		int sum = 0;
//		for(int i=0; i<n+2; i++) {
//			if (visited[i] == true)
//				sum += wine[i];
//		}
//		max = max<sum? sum: max;
//	}
//
//}

/*
 6  10  13  9  8  1
           17  9  1 
   
i-1을 마셨을 경우     
dp[i] = dp[i-3] + arr[i-1] + arr[i]
 
i-1을 마시지 않았을때
dp[i] = dp[i-2] + arr[i]
  


 */

public class Main{
	static public void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			wine[i] = sc.nextInt();
		}
		dp[0] = wine[0];
		
		for(int i=1; i<n; i++) {
			if(i == 1) {
				dp[1] = wine[0] + wine[1];
				continue;
			}
			if(i == 2) {
				dp[2] = Math.max(dp[1], Math.max(wine[0]+wine[2], wine[1]+wine[2]));
				continue;
			}
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1]+wine[i], dp[i-2]+wine[i]));
		}
		System.out.println(dp[n-1]);
		
	}
}
	
	


