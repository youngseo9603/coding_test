import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long max = arr[0];
		for(int i=0; i<n-m; i++) {
			long temp = 0;
			for(int j=0; j<m; j++) 
				temp += arr[i+j];
			max = Math.max(max, temp);
		}
		
		System.out.println(max);
	}
}