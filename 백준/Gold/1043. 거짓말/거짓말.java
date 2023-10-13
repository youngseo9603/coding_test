import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int tnum = Integer.parseInt(st.nextToken());
		int[] truth = new int[n+1];
		Stack<Integer> stack = new Stack<>(); 
		for(int i=0; i<tnum; i++) {
			int t = Integer.parseInt(st.nextToken());
			truth[t] = 1;
			stack.add(t);
		}
		int[][] people = new int[n+1][n+1];
		int[][] group = new int[m][];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			group[i] = new int[p];
			for(int j=0; j<p; j++) {
				int person = Integer.parseInt(st.nextToken());
				group[i][j] = person;
			}
			
			for(int a=0; a<p-1; a++) {
				for(int b=a+1; b<p; b++) {
					people[group[i][a]][group[i][b]] = 1;
					people[group[i][b]][group[i][a]] = 1;
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			for(int i=1; i<n+1; i++) {
				if(people[temp][i] == 1 && truth[i] == 0) {
					stack.add(i);
					truth[i] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<m; i++) {
			boolean flag = true;
			for(int j=0; j<group[i].length; j++) {
				if(truth[group[i][j]] == 1) {
					flag = false;
					break;
				}
			}
			if(flag)
				answer++;
		}
		
		System.out.println(answer);
	}
	
}
