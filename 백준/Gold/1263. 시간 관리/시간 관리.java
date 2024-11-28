
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Work implements Comparable<Work> {
        int time;
        int end;

        Work(int time, int start) {
            this.time = time;
            this.end = start;
        }

        @Override
        public int compareTo(Work o) {
            return o.end - end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Work[] works = new Work[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(works);

        int start = works[0].end - works[0].time;
        for(int i=1; i<n; i++) {
            if(start >= works[i].end){
                start = works[i].end - works[i].time;
            }
            else if (start < works[i].end){
                start = start - works[i].time;
            }
        }

        if(start < 0)
            System.out.println(-1);
        else System.out.println(start);

    }
}