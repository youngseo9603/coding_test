import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node{
        int end;
        int length;

        Node(int end, int length){
            this.end = end;
            this.length = length;
        }
    }

    static List<Node>[] map;
    static int answer;
    static boolean[] visited;
    static int endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new List[n+1];
        int start;
        int end = 0;
        int length;

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            map[start] = new ArrayList<>();
            while(true){
                end = Integer.parseInt(st.nextToken());
                if(end == -1)   break;
                length = Integer.parseInt(st.nextToken());

                map[start].add(new Node(end, length));
            }
        }

        visited = new boolean[n+1];
        answer = 0;
        dfs(1, 0);

        answer = 0;
        visited = new boolean[n+1];
        dfs(endNode, 0);

        System.out.println(answer);
    }

    static void dfs(int cur, int len){

        if(answer < len){
            answer = len;
            endNode = cur;
        }

        visited[cur] = true;

        for(Node node : map[cur]) {
            if (!visited[node.end]) {
                dfs(node.end, len+node.length);
                visited[node.end] = true;
            }
        }

    }

}