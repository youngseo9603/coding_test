import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int t, n, res;
    private static int arr[];
    private static boolean visited[], done[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            res = 0;
            visited = new boolean[n+1];
            done = new boolean[n+1];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<n+1; i++){
                if(done[i]) continue;
                dfs(i);
            }

            System.out.println(n-res);


        }

    }

    public static void dfs(int idx) {
        if(done[idx]) return;
        if(visited[idx]) {
            done[idx] = true;
            res++;
        }
        visited[idx] = true;
        dfs(arr[idx]);
        done[idx] = true;
        visited[idx] = false;
    }

}