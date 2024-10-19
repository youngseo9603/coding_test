import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static ArrayList<Node>[] map;
    public static boolean[] visited;
    public static int start;
    public static int end;

    public static class Node {
        int next;
        int weight;

        Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<n+1; i++)
            map[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 1000000000;
        int mid = (left+right)/2;

        while(left <= right) {
            mid = (left+right)/2;
            boolean able = dfs(mid);
            if(able){
                left = mid+1;
            }
            else{
                right = mid-1;
            }

        }

        System.out.println(right);

    }

    public static boolean dfs(int w){
        visited = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        stack.push(start);

        boolean res = false;

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            if(visited[end]){
                res = true;
                break;
            }

            for(Node node : map[cur]) {
                if(!visited[node.next] && node.weight >= w){
                    stack.add(node.next);
                    visited[node.next] = true;
                }
            }
        }
        return res;
    }


}