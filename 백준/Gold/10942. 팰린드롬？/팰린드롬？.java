import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                boolean flag = true;
                int s = i;
                int e = j;
                while(s<=e){
                    if(arr[s] != arr[e]){
                        flag = false;
                        break;
                    }
                    s++;
                    e--;
                }
                if(flag) map[i][j] = 1;
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<m; t++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(map[start-1][end-1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}