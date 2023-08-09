import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
		
		st = new StringTokenizer(bf.readLine());	
		int[][] nextArr;
		for(int t=0; t<r; t++) {
			nextArr = new int[n][m];
			int flag = 0;
			int temp;
			switch(Integer.parseInt(st.nextToken())) {
				case 1:
					for(int i=0; i<n; i++)
						for(int j=0; j<m; j++)
							nextArr[i][j] = arr[n-i-1][j];
					break;
				case 2:
					for(int i=0; i<n; i++)
						for(int j=0; j<m; j++)
							nextArr[i][j] = arr[i][m-j-1];
					break;
			case 3:
				nextArr = new int[m][n];
				flag = 1;
				for(int i=0; i<m; i++)
					for(int j=0; j<n; j++)
						nextArr[i][j] = arr[n-j-1][i];
				temp = n;
				n = m;
				m = temp;
				break;
			case 4:
				nextArr = new int[m][n];
				flag = 1;
				for(int i=0; i<m; i++)
					for(int j=0; j<n; j++)
						nextArr[i][j] = arr[j][m-i-1];
				temp = n;
				n = m;
				m = temp;
				break;
			case 5:
				// paint
				for(int i=0; i<n/2; i++)
					for(int j=0; j<m/2; j++)
						nextArr[i][j] = arr[i+n/2][j];
				for(int i=n/2; i<n; i++)
					for(int j=0; j<m/2; j++)
						nextArr[i][j] = arr[i][j+m/2];
				for(int i=n/2; i<n; i++)
					for(int j=m/2; j<m; j++)
						nextArr[i][j] = arr[i-n/2][j];
				for(int i=0; i<n/2; i++)
					for(int j=m/2; j<m; j++)
						nextArr[i][j] = arr[i][j-m/2];
				break;
			case 6:
				// paint
				for(int i=0; i<n/2; i++)
					for(int j=0; j<m/2; j++)
						nextArr[i][j] = arr[i][j+m/2];
				for(int i=n/2; i<n; i++)
					for(int j=0; j<m/2; j++)
						nextArr[i][j] = arr[i-n/2][j];
				for(int i=n/2; i<n; i++)
					for(int j=m/2; j<m; j++)
						nextArr[i][j] = arr[i][j-m/2];
				for(int i=0; i<n/2; i++)
					for(int j=m/2; j<m; j++)
						nextArr[i][j] = arr[i+n/2][j];
				break;	
			}
			
			arr = new int[n][m];
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					arr[i][j] = nextArr[i][j];
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

}