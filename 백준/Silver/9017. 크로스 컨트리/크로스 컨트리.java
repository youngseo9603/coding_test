import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] team;
		int[] score;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			score = new int[n];
			team = new int[201][8];
			
			HashMap<Integer, Integer> map = new HashMap<>(); 
			for(int i=0; i<n; i++) {
				score[i] = Integer.parseInt(s[i]);
				map.put(score[i], map.getOrDefault(score[i], 0) + 1);
			}
			
			int cnt = 1;
			for(int i=0; i<n; i++) {
				if(map.get(score[i]) == 6) {
					team[score[i]][0] += 1;
					team[score[i]][team[score[i]][0]] = cnt;
					cnt++;
				}
			}
			
			
			int answer = -1;
			int a = Integer.MAX_VALUE;
			for(int i=1; i<201; i++) {
				int team_sum = 0;
				if(team[i][0] != 6)
					continue;
				for(int j=1; j<5; j++) {
					team_sum += team[i][j];
				}
				if(team_sum < a) {
					a = team_sum;
					answer = i;
				}
				else if(team_sum == a) {
					if(team[i][5] < team[answer][5]) {
						a = team_sum;
						answer = i;
					}
				}
			}
			
			System.out.println(answer);
			
		}
	}

}