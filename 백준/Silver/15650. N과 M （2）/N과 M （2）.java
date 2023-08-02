import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int m;
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		
		combination(1,0);
		
	}
	
	public static void combination(int k, int depth) {
		if (depth == m) {
			for(int i: arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=k; i<=n; i++) {
			arr[depth] = i;
			combination(i+1, depth+1);
		}
		
		
	}
}