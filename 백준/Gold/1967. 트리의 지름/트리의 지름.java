import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] list;
    static boolean[] visited;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n+1];
        for(int i=0; i<n+1; i++)
            list[i] = new ArrayList<>();
        visited = new boolean[n+1];
        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y,k));
            list[y].add(new Node(x,k));
        }
        answer = 0;
        for(int i=1; i<n+1; i++){
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        System.out.println(answer);

    }

    public static void dfs(int cur, int sum){
        answer = Math.max(answer, sum);

        for(Node node : list[cur]){
            if(!visited[node.num]){
                visited[node.num] = true;
                dfs(node.num, sum+node.len);
                visited[node.num] = false;
            }
        }
    }

    static class Node{
        int num;
        int len;

        Node(int num, int len){
            this.len = len;
            this.num = num;
        }
    }
}