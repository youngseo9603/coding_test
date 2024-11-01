import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int next;
        int weight;
        ArrayList<Integer> path;

        Node (int next, int weight, int start){
            this.next = next;
            this.weight = weight;
            path = new ArrayList<>();
            path.add(start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight, start));
        }

        Node[] dist = new Node[n+1];
        for(int i=0; i<n+1; i++)
            dist[i] = new Node(0,Integer.MAX_VALUE,i);
        boolean[] visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i=0; i<graph[start].size(); i++){
            if(dist[graph[start].get(i).next].weight > graph[start].get(i).weight){
                dist[graph[start].get(i).next] = graph[start].get(i);
                dist[graph[start].get(i).next].path.add(graph[start].get(i).next);
            }
        }
        visited[start] = true;

        int next = 0;
        for(int d=0; d<n; d++){
            
            next = 0;
            for(int i=1; i<n+1; i++){
                if(!visited[i] && dist[i].weight < dist[next].weight){
                    next = i;
                }
            }

            for(int i=0; i<graph[next].size(); i++){
                if(dist[graph[next].get(i).next].weight > dist[next].weight + graph[next].get(i).weight){
                    dist[graph[next].get(i).next].weight = dist[next].weight + graph[next].get(i).weight;
                    dist[graph[next].get(i).next].path = new ArrayList<>();
                    for(int p : dist[next].path)
                        dist[graph[next].get(i).next].path.add(p);
                    dist[graph[next].get(i).next].path.add(graph[next].get(i).next);
                }
            }
            visited[next] = true;

        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end].weight).append("\n");
        sb.append(dist[end].path.size()).append("\n");
        for(int d : dist[end].path){
            sb.append(d).append(" ");
        }
        System.out.println(sb);

    }
}