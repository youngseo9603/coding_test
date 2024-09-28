import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static  class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.start - o.start;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);
        int maxSize = 1;

        for(int i=1; i<n; i++){
            if(pq.peek() > lectures[i].start){
                pq.add(lectures[i].end);
            }
            else {
                pq.poll();
                pq.add(lectures[i].end);
            }
            maxSize = Math.max(maxSize, pq.size());
        }

        System.out.println(maxSize);

    }
}