import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] life;
	static int n;
	static int[] happy;
	static int[] visited;
	static int l;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		life = new int[n];
		happy = new int[n];
		visited = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			life[i] = Integer.parseInt(s[i]);

		s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			happy[i] = Integer.parseInt(s[i]);

		l = 100;
		h = 0;
		answer = 0;
		
		dfs(0, 100);
		
		System.out.println(answer);
	}

	static int answer;

	public static void dfs(int depth, int curlife) {
		if(curlife>0) {
			int cnt=0;
			for(int i=0; i<n; i++) {
				if(visited[i] == 1)
					cnt += happy[i];
			}
			answer = Math.max(answer, cnt);
			
		}
		
		for(int i=depth; i<n; i++) {
			if(visited[i]==1 || curlife-life[i] <= 0)
				continue;
			visited[i] = 1;
			dfs(i+1, curlife-life[i]);
			visited[i] = 0;
				
		}
		//dfs(depth-1);
		

	}
}