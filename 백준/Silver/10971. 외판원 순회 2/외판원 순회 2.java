import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[][] map;
	static int[] m;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		m = new int[n];
		isSelected = new boolean[n];
		for(int i=0; i<n; i++)
			m[i] = i;
		
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		answer = Integer.MAX_VALUE;
		nextPermutation(0);
		System.out.println(answer);
	}
	static long answer;
	
	static void nextPermutation(int depth) {
		if(depth == n) {
			int cnt = 0;
			for(int i=0; i<n-1; i++) {
				cnt += map[m[i]][m[i+1]];
				if(map[m[i]][m[i+1]] == 0)
					return;
			}
			if(map[m[n-1]][m[0]] == 0)
				return;
			cnt += map[m[n-1]][m[0]];
			answer = Math.min(answer, cnt);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(isSelected[i])	continue;
			m[depth] = i;
			isSelected[i] = true;
			nextPermutation(depth+1);
			isSelected[i] = false;
		}
		
	}

}