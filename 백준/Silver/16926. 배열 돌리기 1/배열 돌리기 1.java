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
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] answer = new int[n][m];
		
		int cnt = 0;
		while(n>1 && m>1) {
			int t = r % (2*m + 2*n - 4);
			
			while(t-- > 0) {
				int temp = arr[cnt][cnt];
				for(int i=0; i<m-1; i++) 
					arr[cnt][cnt + i] = arr[cnt][cnt+i+1];
				
				for(int i=0; i<n-1; i++)
					arr[cnt + i][cnt+m-1] = arr[cnt+i+1][cnt+m-1];
				
				for(int i=0; i<m-1; i++) 
					arr[cnt+n-1][cnt+m-1-i] = arr[cnt+n-1][cnt+m-2-i]; 
				
				for(int i=0; i<n-1; i++) 
					arr[cnt+n-1-i][cnt] = arr[cnt+n-2-i][cnt];
				
				arr[cnt+1][cnt] = temp;
			
				
			}
			
			n -= 2;
			m -= 2;
			cnt++;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) 
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}