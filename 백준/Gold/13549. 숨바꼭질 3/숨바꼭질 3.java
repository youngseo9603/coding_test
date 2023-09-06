import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		int[] visited = new int[n+m+1];
		visited[n] = 1;
		int[] answer = {0,0};
		while(true) {
			int[] temp = q.poll();
			if(temp[0] == m) {
				answer = temp;
				break;
			}
				
			if (temp[0]*2<n+m+1 && visited[temp[0]*2] == 0) {
				q.offer(new int[] {temp[0]*2, temp[1]});
				visited[temp[0]*2] = 1;
			}
			if (temp[0]-1>=0 && visited[temp[0]-1] == 0) {
				q.offer(new int[] {temp[0]-1, temp[1]+1});
				visited[temp[0]-1] = 1;
			}
			if (temp[0]+1<n+m+1 && visited[temp[0]+1] == 0) {
				q.offer(new int[] {temp[0]+1, temp[1]+1});
				visited[temp[0]+1] = 1;
			}
		}
		
		System.out.println(answer[1]);
	}

}