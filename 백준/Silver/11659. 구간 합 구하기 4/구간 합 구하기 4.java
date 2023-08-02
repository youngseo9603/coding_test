import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n+1];
		int arrSum = 0;
		for(int i=0; i<n; i++) {
			arrSum += sc.nextInt();
			arr[i+1] = arrSum;
		}
		
		for(int i=0; i<m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(arr[e]-arr[s-1]);
		}

	}

}