import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Work implements Comparable<Work> {

        int d;
        int w;

        Work(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Work o) {

            return o.w - w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Work>[] works = new List[1001];
        int maxDay = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(works[d] == null) works[d] = new ArrayList<>();

            works[d].add(new Work(d, w));
            maxDay = Math.max(maxDay, d);
        }

        PriorityQueue<Work> pq = new PriorityQueue<>();

        int answer = 0;
        for(int i=maxDay; i > 0; i--){

            if(works[i] != null) {
                for (Work w : works[i]) {
                    pq.add(w);
                }
            }

            if(!pq.isEmpty()){
                answer += pq.poll().w;
            }

        }

        System.out.println(answer);
    }
}