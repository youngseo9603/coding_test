import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Home> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start < end)
                list.add(new Home(start, end));
            else
                list.add(new Home(end, start));
        }
        int d = Integer.parseInt(br.readLine());

        list.sort(Comparator.comparingInt(o -> o.w));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(Home h : list){
            while(!pq.isEmpty() && (pq.peek() < h.w - d))
                pq.poll();

            if(h.h + d >= h.w){
                pq.add(h.h);
            }
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);

    }

    static class Home{
        int h,w;

        Home(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
}