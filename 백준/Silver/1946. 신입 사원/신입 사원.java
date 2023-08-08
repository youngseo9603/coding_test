import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int t=0; t<testCase; t++) {
			int n = Integer.parseInt(bf.readLine());
			
			int[] arr = new int[n];
			int[] answer = new int[n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a-1] = b;
			}
			
			int k = 1;			
			int min = arr[0];
			for(int i=1; i<n; i++) {
				if (min > arr[i]) {
					min = arr[i];
					k++;
				}
			}

			System.out.println(k);
		}
	}

}



/*
 * 1 2 3 4 5 6 7
 * 4 5 6 2 7 1 3
 * 
 * 6 4 7 1 2 3 5
 * 1 2 3 4 5 6 7
 */