import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] map = new int[n][n];
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
            answer[i][i] = 1;
        }

        while(b > 0){
            if(b % 2 == 1)
                answer = multiply(answer, map);
            map = multiply(map, map);
            b /= 2;
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static int[][] multiply(int[][] a, int[][] b) {

        int n = a.length;
        int[][] response = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                for(int k=0; k<n; k++){
                    response[i][j] += a[i][k] * b[k][j];
                }

                response[i][j] %= 1000;

            }
        }

        return response;
    }
}