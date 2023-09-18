import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean map[][] = new boolean[5][n/5];
		boolean visited[] = new boolean[n/5];
		String s = br.readLine();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<n/5; j++) {
				if(s.charAt(n*i/5+j) == '#')
					map[i][j] = true;
			}
		}
		
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<n/5; j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n/5; i++) {
			if(map[0][i] && !visited[i]) {
				
				//8
				if(i+3<=n/5 && map[0][i+1] && map[0][i+2] && 
					map[1][i] && map[1][i+2] && 
					map[2][i] && map[2][i+1] && map[2][i+2]
					&& map[3][i]) {
					sb.append("8");
					i += 2;
				}
				//9
				else if(i+3<=n/5 && map[0][i+1] && map[0][i+2] && 
						map[1][i] && map[1][i+2] && 
						map[2][i] && map[2][i+1] && map[2][i+2]
						&& map[3][i+2]) {
					sb.append("9");
					i += 2;
				}
				//0
				else if (i+3<=n/5 && map[0][i+1] && map[0][i+2] && 
						map[1][i] && map[1][i+2] && 
						map[2][i] && map[2][i+2]) {
					sb.append("0");
					i += 2;
				}
				//2
				else if (i+3<=n/5 && map[0][i+1] && map[0][i+2] && 
						map[1][i+2] && 
						map[2][i] && map[2][i+1] && map[2][i+2] &&
						map[3][i]) {
					sb.append("2");
					i += 2;
				}
				//3
				else if (i+3<=n/5 && map[0][i+1] && map[0][i+2] && 
						map[1][i+2] && 
						map[2][i] && map[2][i+1] && map[2][i+2] &&
						map[3][i+2]) {
					sb.append("3");
					i += 2;
				}
				//4
				else if (i+3<=n/5  && map[0][i+2] && 
						map[1][i] && map[1][i+2] &&
						map[2][i] && map[2][i+1] && map[2][i+2] &&
						map[3][i+2]) {
					sb.append("4");
					i += 2;
				}
				//6
				else if (i+3<=n/5  && map[0][i+1] && map[0][i+2] && 
						map[1][i] && 
						map[2][i] && map[2][i+1] && map[2][i+2] &&
						map[3][i]) {
					sb.append("6");
					i += 2;
				}
				//5
				else if (i+3<=n/5  && map[0][i+1] && map[0][i+2] && 
						map[1][i] && 
						map[2][i] && map[2][i+1] && map[2][i+2] &&
						map[3][i+2] &&
						map[4][i+2]) {
					sb.append("5");
					i += 2;
				}
				//7
				else if (i+3<=n/5  && map[0][i+1] && map[0][i+2] && 
						map[1][i+2] && 
						map[2][i+2] &&
						map[3][i+2]) {
					sb.append("7");
					i += 2;
				}
				
				//1
				else {
					sb.append("1");
				}
			}
		}
		System.out.println(sb);
	}

}