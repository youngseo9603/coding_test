import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int r;
	static int c;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			String temp = bf.readLine();
			for(int j=0; j<c; j++)
				map[i][j] = temp.charAt(j);
		}
		
		answer = 0;
		for(int i=0; i<r; i++) 
			if(dfs(i,0))
				answer++;
//			visited[i][0] = 1;
//			LinkedList<int[]> temp_list = new LinkedList<>();
//			while(!stack.empty()) {
//
//				int[] temp = stack.pop();
//				int x = temp[0];
//				int y = temp[1]+1;
//				
//				if(y == c)	{
//					answer++;
//					break;
//				}
//				
//				if(x-1>=0 && map[x-1][y] == '.' && visited[x-1][y] == 0) {
//					stack.add(new int[] {x-1,y});
//					visited[x-1][y] = 1;
//					temp_list.add(new int[] {x-1,y});
//				}
//				else if(map[x][y] == '.' && visited[x][y] == 0) {
//					stack.add(new int[] {x,y});
//					visited[x][y] = 1;
//					temp_list.add(new int[] {x,y});
//				}
//				else if(x+1 < r && map[x+1][y] == '.' && visited[x+1][y] == 0) {
//					stack.add(new int[] {x+1,y});
//					visited[x+1][y] = 1;
//					temp_list.add(new int[] {x+1,y});
//					
//				}
//				else {
//					for(int k=0; k<temp_list.size(); k++) 
//						visited[temp_list.get(k)[0]][temp_list.get(k)[1]] = 0;
//					break;
//				}
//			}
		
		System.out.println(answer);
		
		
	}
	
	static boolean dfs(int i, int j) {
		map[i][j] = '-';
		
		if(j == c-1)
			return true;
		
		if(i > 0 && map[i-1][j+1] == '.') {
			if(dfs(i-1, j+1))
				return true;
		}
		if(map[i][j+1] == '.') {
			if(dfs(i, j+1))
				return true;
		}
		if(i+1<r && map[i+1][j+1] == '.') {
			if(dfs(i+1, j+1))
				return true;
		}
		
		return false;
	}

}