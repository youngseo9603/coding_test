import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		int num = 0;

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}

		dfs(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}

		System.out.println(sb);

	}

	static boolean check(int x, int y, int m) {
		
		for (int k = 0; k < 9; k++) {
			if(map[k][y] == m || map[x][k] == m) return false;
		}
		
		int a = x/3*3;
		int b = y-y%3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++)
				if(map[i][j] == m)	return false;
		}
		
		return true;
	}

	static void dfs(int d) {
		
		if (d == 81) {
			flag = true;
			return;
		}

		int y = d % 9;
		int x = d / 9;
		if (map[x][y] == 0) {
			for (int i = 1; i < 10; i++) {
				if (!check(x,y,i)) {
					continue;
				}
				map[x][y] = i;
				dfs(d+1);
				
				if(flag) return;
				map[x][y] = 0;
			}
		}
		else {
			dfs(d+1);
		}

	}

}