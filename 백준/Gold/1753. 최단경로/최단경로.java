import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int INF = 10*20000+1;
        boolean[] visited = new boolean[v+1];
        int[] map = new int[v+1];
        List<Node>[] list = new List[v+1];

        for(int i=0; i<v+1; i++){
            map[i] = INF;
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        map[k] = 0;
        pq.add(new Node(k,0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(!visited[current.end])
                visited[current.end] = true;
            for(int i=0; i<list[current.end].size(); i++){
                Node next = list[current.end].get(i);
                if(!visited[next.end] && current.weight + next.weight < map[next.end]){
                    map[next.end] = current.weight + next.weight;
                    pq.add(new Node(next.end, map[next.end]));
                }
            }

        }

        for(int i=1; i<v+1; i++)
            if(map[i] == INF)
                System.out.println("INF");
            else
                System.out.println(map[i]);

    }
}