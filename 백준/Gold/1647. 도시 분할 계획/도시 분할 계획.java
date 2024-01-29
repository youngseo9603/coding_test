import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Road> map;
    static int[] parent;

    static class Road implements Comparable<Road>{
        int start;
        int end;
        int weight;

        Road(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o){
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        parent = new int[n+1];

        int a, b, c = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map.add(new Road(a, b, c));
        }

        for(int i=0; i<n+1; i++)
            parent[i] = i;

        Collections.sort(map);

        int ans = 0;
        int bigCost = 0;

        for(int i=0; i<m; i++){
            Road road = map.get(i);

            if(find(road.start) != find(road.end)){
                ans += road.weight;
                union(road.start, road.end);

                bigCost = road.weight;
            }
        }

        System.out.println(ans - bigCost);
        

    }

    public static int find(int x){
        if(x==parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y] = x;
        }
    }

}