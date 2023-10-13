import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[] visited;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		
		for(int i=0; i<n; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		visited = new int[m];
		combination(0);
	}
	
	static void combination(int depth) {
		
		if(depth == m) {
			
			for(int i=0; i<m-1; i++) {
				for(int j=i+1; j<m; j++) {
					if(visited[i] == visited[j])
						return;
				}
			}
			
			
			for(int i=0; i<m; i++)
				System.out.print(num[visited[i]] + " ");
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			visited[depth] = i;
			combination(depth+1);
		}
		
	}
}