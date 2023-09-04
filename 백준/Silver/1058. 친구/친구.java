import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] visited;
	static int answer;
	static int[][] arr;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				if(s.charAt(j)=='N')
					arr[i][j] = 0;
				else
					arr[i][j] = 1;
			}
		}
		
		
		answer = 0;
		for(int i=0; i<n; i++) {
			visited = new int[n];
			Queue<int[]> queue = new LinkedList<>();
			int cnt = 0;
			visited[i] = 1;
			queue.add(new int[] {i,0});
			while(!queue.isEmpty()) {
				int temp[] = queue.poll();
				if(temp[1] == 2)
					break;
				for(int k=0; k<n; k++) {
					if(arr[temp[0]][k] == 1 && visited[k] == 0) {
						visited[k] = 1;
						queue.add(new int[] {k,temp[1]+1});
					}
				}
			}
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				if(visited[j]==1)
					cnt++;
			}
				
					
			answer = Math.max(answer, cnt);
			
		}
		System.out.println(answer);
	}
}

/*
 * 1110000001
 * 
 * 
 */