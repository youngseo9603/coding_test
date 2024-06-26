import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static List<Node>[] map;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new List[n+1];

        for(int i=0; i<n+1; i++)
            map[i] = new ArrayList();


        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        int answer11 = findMin(1, mid1);
        int answer12 =  findMin(mid2,n);
        int answer21 = findMin(n,mid1);
        int answer22 = findMin(1,mid2);
        int answer3 = findMin(mid1, mid2);

        if(answer11 == Integer.MAX_VALUE || answer12 == Integer.MAX_VALUE || answer21 == Integer.MAX_VALUE || answer22 == Integer.MAX_VALUE || answer3 == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer3 + Math.min(answer11+answer12, answer21+answer22));

    }

    public static int findMin(int start, int end){

        if(start == end)
            return 0;

        boolean[] visited = new boolean[n+1];
        int[] count = new int[n+1];
        for(int i=0; i<n+1; i++)
            count[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            visited[now.end] = true;

            for(int i=0; i<map[now.end].size(); i++){
                Node next = map[now.end].get(i);
                if(!visited[next.end] && count[next.end] > now.weight + next.weight){
                    count[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end,count[next.end]));
                }
            }

        }

        return count[end];
    }
}