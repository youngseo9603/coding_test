import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        lists = new List[n+1];
        int[] pre = new int[n+1];

        for(int i=0; i<n+1; i++)
            lists[i] = new ArrayList<Integer>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            pre[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<n+1; i++) {
            if(pre[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");
            
            for(int next : lists[cur]){
                pre[next]--;
                if(pre[next] == 0){
                    pq.offer(next);
                }
            }

        }

        System.out.println(sb);

    }
}