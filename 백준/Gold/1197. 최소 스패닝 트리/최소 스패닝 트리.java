import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] list;
    static boolean[] visited;
    static int answer;

    public static class Node implements Comparable<Node> {

        int to;
        int value;

        Node(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        visited = new boolean[v+1];
        answer = 0;

        for(int i=0; i<v+1; i++) list[i] = new ArrayList<>();

        int a, b, c;
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        prim(1);
        System.out.println(answer);

    }

    static void prim(int start){

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.value;

            if(visited[node]) continue;
            visited[node] = true;
            answer += weight;

            for(Node next : list[node]){
                if(!visited[next.to])
                    pq.add(next);
            }

        }

    }

}