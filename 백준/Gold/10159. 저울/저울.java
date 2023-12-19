import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[n][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }

        for(int z=0; z<n; z++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][z] == 1 && map[z][j] == 1)
                        map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(map[i][j] == 0 && map[j][i] == 0)
                    cnt++;
            }
            System.out.println(cnt-1);
        }

    }
}