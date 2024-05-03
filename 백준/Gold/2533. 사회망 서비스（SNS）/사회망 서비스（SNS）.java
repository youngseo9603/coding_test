import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] node;
    static int n;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new List[n+1];
        for(int i=0; i<n+1; i++)
            node[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        visited = new boolean[n+1];
        dp = new int[n+1][2];

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int number){

        visited[number] = true;

        dp[number][0] = 0;
        dp[number][1] = 1;

        for(int child : node[number]){
            if(!visited[child]){
                dfs(child);
                dp[number][0] += dp[child][1];
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }

}