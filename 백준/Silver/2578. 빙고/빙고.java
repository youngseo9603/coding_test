import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[5][5];
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<5; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				int x = 0;
				int y = 0;
				cnt++;
				
				//행열 찾기
				for(int a=0; a<5; a++) {
					for(int b=0; b<5; b++) {
						if(arr[a][b] == temp) {
							x = a;
							y = b;
							break;
						}
					}
				}
				
				arr[x][y] = 0;
				
				int find = 0;
				for(int a=0; a<5; a++) {
					if(arr[a][0] == 0 && arr[a][1] == 0 && arr[a][2] == 0 && arr[a][3] == 0 && arr[a][4] == 0 )
						find++;
					if(arr[0][a] == 0 && arr[1][a] == 0 && arr[2][a] == 0 && arr[3][a] == 0 && arr[4][a] == 0 )
						find++;
				}
				if(arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0 )
					find++;
				if(arr[4][0] == 0 && arr[3][1] == 0 && arr[2][2] == 0 && arr[1][3] == 0 && arr[0][4] == 0 )
					find++;
				
				
//				if(arr[x][0] == 0 && arr[x][1] == 0 && arr[x][2] == 0 && arr[x][3] == 0 && arr[x][4] == 0 )
//					find++;
//				if(arr[0][y] == 0 && arr[1][y] == 0 && arr[2][y] == 0 && arr[3][y] == 0 && arr[4][y] == 0 )
//					find++;
//				if(x==y && arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0 )
//					find++;
//				if(x+y==4 && arr[4][0] == 0 && arr[3][1] == 0 && arr[2][2] == 0 && arr[1][3] == 0 && arr[0][4] == 0 )
//					find++;
				
				if(find >= 3) {
					System.out.println(cnt);
					return;
				}
				
			}
		}
	}

}


/*
	12  12   2  24  10
	16   1  13   3  25
	 6  20   5  21  17
 	19   4   8  14   9
 	22  15   7  23  18


 	0	0	x	0	x
 	x	x	x	x	x
 	x	0	x	0	x
 	0	x	x	0	0	
 	x	0	x	0	x


*/