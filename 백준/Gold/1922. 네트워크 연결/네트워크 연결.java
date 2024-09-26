import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static ArrayList<Node> list;

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int start;
        int end;
        int cost;
        StringTokenizer st;

        list = new ArrayList<>();
        parent = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, cost));
        }

        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }
        
        Collections.sort(list);

        int answer = 0;

        for(Node node : list){
            if(find(node.start) != find(node.end)){
                answer += node.cost;
                union(node.start, node.end);
            }
        }

        System.out.println(answer);


    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }

}