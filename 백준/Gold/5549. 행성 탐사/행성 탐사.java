import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[m][n];
        int[][][] sumMap = new int[m+1][n+1][3];

        for(int i=0; i<m; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(s.charAt(j) == 'J')
                    map[i][j] = 0;
                else if (s.charAt(j) == 'O')
                    map[i][j] = 1;
                else
                    map[i][j] = 2;
            }
        }

        int[] temp = new int[3];

        for(int i=0; i<m; i++){
            temp = new int[3];

            for(int j=0; j<n; j++){
                temp[map[i][j]]++;

                for(int z=0; z<3; z++)
                    sumMap[i+1][j+1][z] = sumMap[i][j+1][z] + temp[z];

            }
        }

        while(k-->0){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int[] answer = new int[3];
            for(int i=0; i<3; i++) {
                answer[i] = sumMap[x2][y2][i] - sumMap[x1-1][y2][i] - sumMap[x2][y1-1][i] + sumMap[x1-1][y1-1][i];
            }

            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

        }



//        for(int i=0; i<m+1; i++){
//
//            for(int j=0; j<n+1; j++){
//                System.out.println(sumMap[i][j][0] + " " + sumMap[i][j][1] + " " + sumMap[i][j][2] + " ");
//            }
//
//        }

    }
}