import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int k;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;

            map[i][n1] = 1;
            map[i][n2] = 1;
        }

        int[][] kmap = power(map, k);


        StringBuilder sb = new StringBuilder();
        for(int t=0 ; t<m ; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(kmap[a-1][b-1] == 0)
                sb.append("life").append("\n");
            else
                sb.append("death").append("\n");
        }

        System.out.println(sb);

    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB){
        int[][] res = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int a=0; a<n; a++){
                    res[i][j] += matrixA[i][a] * matrixB[a][j];
                }
            }
        }

        return res;
    }

    public static int[][] power(int[][] matrix, int cur){
        int[][] res = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                res[i][j] = matrix[i][j];

        while(cur != 1){
            if(cur % 2 == 0){
                res = multiply(res, res);
                cur /= 2;
            }
            else {
                res = multiply(res, map);
                cur--;
            }
        }

        return res;
    }

}

/*
    0 1 0 1   0 1 0 1     1
    1 0 1 0   1 0 1 0
    1 0 0 1   1 0 0 1
    0 1 0 0   0 1 0 0

    0 1 0 1
    1 0 1 0
    1 0 0 1
    0 1 0 0
 */