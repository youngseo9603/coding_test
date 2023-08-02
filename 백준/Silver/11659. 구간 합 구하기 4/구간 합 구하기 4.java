import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException  {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int arrSum = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arrSum += Integer.parseInt(st.nextToken());
			arr[i+1] = arrSum;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(arr[e]-arr[s-1]);
		}

	}

}