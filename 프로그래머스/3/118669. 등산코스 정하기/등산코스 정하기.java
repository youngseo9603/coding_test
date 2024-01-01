import java.util.*;

class Solution {
    
    static List<List<Node>> graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        graph = new ArrayList<>();
        for(int i=0 ; i<n+1; i++)
            graph.add(new ArrayList<>());
        
        for(int[] p : paths){
            int s = p[0];
            int e = p[1];
            int w = p[2];
            
            if(isGS(s, gates) || isGS(e, summits)){
                graph.get(s).add(new Node(e,w));
            }
            else if(isGS(s, summits) || isGS(e, gates)){
                graph.get(e).add(new Node(s,w));
            }
            else{
                graph.get(s).add(new Node(e,w));
                graph.get(e).add(new Node(s,w));
            }
            
            
        }
        
        
        return dijkstra(n, gates, summits);
    }
    
    public boolean isGS(int g, int[] gates){
        for(int gate : gates)
            if(g == gate)
                return true;
        return false;
    }
    
    static class Node {
        int e; 
        int w;
        
        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
    
    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.w > intensity[node.e])
                continue;
            
            for(int i=0; i<graph.get(node.e).size(); i++){
                Node next = graph.get(node.e).get(i);
                int dis = Math.max(intensity[node.e], next.w);
                if(intensity[next.e] > dis){
                    intensity[next.e] = dis;
                    q.add(new Node(next.e, dis));
                }
            }
        }

        int mn = Integer.MAX_VALUE;
        int mw = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < mw) {
                mn = summit;
                mw = intensity[summit];
            }
        }

        return new int[]{mn, mw};
    }
    
   
}