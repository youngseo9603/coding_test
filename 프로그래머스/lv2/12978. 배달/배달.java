import java.util.*;

class Solution {
    
    public static class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        list = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0; i<road.length; i++){
            list[road[i][0]].add(new Node(road[i][1], road[i][2]));
            list[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        dijkstra(1);
        
        for(int i=1; i<dist.length; i++){
            if(dist[i] <= K)
                answer++;
        }

        return answer;
    }
    
    public static void dijkstra(int v){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight) ;
        
        pq.add(new Node(v,0));
        dist[v] = 0;
        
        while(!pq.isEmpty()){
            
            Node temp = pq.poll();
            if(visited[temp.vertex])
                continue;
            visited[temp.vertex] = true;
            for(Node n : list[temp.vertex]){
                if(dist[n.vertex] > temp.weight + n.weight){
                    dist[n.vertex] = temp.weight + n.weight;
                    pq.add(new Node(n.vertex, dist[n.vertex]));
                }
                
            }
            
        }
        
    }
}