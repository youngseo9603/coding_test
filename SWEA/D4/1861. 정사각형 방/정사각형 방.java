import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] arr;
	static int n;
	static int[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int testCase=0; testCase<t; testCase++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			int index = 0;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) {
					int temp = search(i,j,0);
					if(answer < temp) {
						answer = temp;
						index = arr[i][j];
					}
					else if(answer == temp) {
						index = Math.min(index, arr[i][j]);
					}
						
				}
			System.out.println("#" + (testCase+1) + " " + index + " " + (answer+1));
		}
	}
	
	public static int search(int x, int y, int cnt) {
		
		visited = new int[n][n];
		Stack<int[]> st = new Stack<>();
		st.add(new int[] {x,y,arr[x][y]});
		int [] newn;
		while(!st.empty()) {
			newn = st.pop();
			int nx = newn[0];
			int ny = newn[1];
			
			for(int k=0; k<4; k++) {
				int ax = nx + dx[k];
				int ay = ny + dy[k];
				
				if(ax >= 0 && ax<n && ay>=0 && ay<n && arr[ax][ay] == newn[2]+1) {
					st.add(new int[] {ax, ay, arr[ax][ay]});
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}