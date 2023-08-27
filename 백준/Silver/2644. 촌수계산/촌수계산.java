import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] visited;
    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        bfs(a,b);
        if(visited[b] == 0)
            System.out.println(-1);
        else
            System.out.println(visited[b]);
    }

    static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int v = q.poll();
            if (v == end)   break;
            for(int i=1; i<=n; i++){
                if(arr[v][i] == 1 && visited[i] == 0){
                    visited[i] = visited[v] + 1;
                    q.add(i);
                }
            }
        }

    }
}
