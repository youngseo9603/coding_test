import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp_max = new int[n+1][3];
        int[][] dp_min = new int[n+1][3];

        for(int i=1; i<n+1; i++){
            dp_max[i][0] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + map[i-1][0];
            dp_max[i][1] = Math.max(dp_max[i-1][2],Math.max(dp_max[i-1][0], dp_max[i-1][1])) + map[i-1][1];
            dp_max[i][2] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + map[i-1][2];

            dp_min[i][0] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + map[i-1][0];
            dp_min[i][1] = Math.min(dp_min[i-1][2], Math.min(dp_min[i-1][0], dp_min[i-1][1])) + map[i-1][1];
            dp_min[i][2] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + map[i-1][2];
        }

        int max = Math.max(dp_max[n][2], Math.max(dp_max[n][0], dp_max[n][1]));
        int min = Math.min(dp_min[n][2], Math.min(dp_min[n][0], dp_min[n][1]));
        System.out.println(max + " " + min);

    }
}