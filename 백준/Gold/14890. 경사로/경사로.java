import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] step = new int[n][n];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			
			for(int j=1; j<n; j++) {
				
				if(Math.abs(map[i][j] - map[i][j-1]) > 1) {
					break;
				}
				else {
					if(map[i][j] - map[i][j-1] < 0) { // 내려가는중
						step[i][j] = -1;
						boolean down = true;
						for(int k=1; k<l; k++) {
							if(j+k < n && map[i][j+k] == map[i][j]) {
								step[i][j+k] = -1;
							}
							else {
								down = false;
							}
						}
						if(!down) {
							break;
						}
						j += l-1;
						
					}
					else if(map[i][j] - map[i][j-1] > 0){ // 올라가는 중
						if(step[i][j-1] != 0) {
							break;
						}
						step[i][j-1] = 1;
						boolean up = true;
						for(int k=1; k<l; k++) {
							if(j-1-k >= 0 && map[i][j-1-k] == map[i][j-1] && step[i][j-1-k] == 0) {
								step[i][j-1-k] = 1;
							}
							else {
								up = false;
								break;
							}
						}
						
						if(!up)
							break;
						
					}
				}
				
				if(j==n-1) {
					answer++;
				}
			}
			
		}
		
		step = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=1; j<n; j++) {
				if(Math.abs(map[j][i] - map[j-1][i]) > 1) {
					break;
				}
				else {
					if(map[j][i] - map[j-1][i] < 0) { // 내려가는중
						step[j][i] = -1;
						boolean down = true;
						for(int k=1; k<l; k++) {
							if(j+k < n && map[j+k][i] == map[j][i]) {
								step[j+k][i] = -1;
							}
							else {
								down = false;
							}
						}
						if(!down) {
							break;
						}
						j += l-1;
						
					}
					else if(map[j][i] - map[j-1][i] > 0){ // 올라가는 중
						if(step[j-1][i] != 0) {
							break;
						}
						step[j-1][i] = 1;
						boolean up = true;
						for(int k=1; k<l; k++) {
							if(j-1-k >= 0 && map[j-1-k][i] == map[j-1][i] && step[j-1-k][i] == 0) {
								step[j-1-k][i] = 1;
							}
							else {
								up = false;
								break;
							}
						}
						
						if(!up)
							break;
						
					}
				}
				
				if(j==n-1) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);

	}

}

/*
 * 	두개의 차가 2 이상
 *  	내려가는거
 * 			l 만큼 +하면서 같은 값 유지되는지
 *		올라가는거 
 *			l 만큼 전부터 step 유지되는지(기존에 step은 없는지)
 */