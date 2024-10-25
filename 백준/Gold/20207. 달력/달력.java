import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] calendar = new int[366];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o1[0] - o2[0];
        });
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start,end});
        }

        int start = -1;
        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.add(-1);
        int max = -1;
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0] > max + 1) {
                answer += cnt*(max-start+1);
                start = cur[0];
                cnt = 1;
                end = new PriorityQueue<>();
                max = cur[1];
                end.add(cur[1]);
            }
            else if (cur[0] >= end.peek()+1){
                end.poll();
                max = Math.max(cur[1], max);
                end.add(cur[1]);
            }
            else {
                cnt++;
                end.add(cur[1]);
                max = Math.max(cur[1], max);
            }

        }

        answer += cnt*(max-start+1);

        System.out.println(answer);

    }
}