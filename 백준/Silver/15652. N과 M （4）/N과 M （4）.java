import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new int[m];
		combination(0);
	}
	
	static void combination(int depth) {
		
		if(depth == m) {
			
			for(int i=1; i<m; i++) {
				if(visited[i] < visited[i-1])
					return;
			}
			
			for(int i=0; i<m; i++)
				System.out.print(visited[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<n+1; i++) {
			visited[depth] = i;
			combination(depth+1);
		}
		
	}
}