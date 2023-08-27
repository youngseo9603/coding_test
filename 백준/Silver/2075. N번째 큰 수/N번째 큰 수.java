import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(s[j]));
            }
        }

        for(int i=0; i<n-1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());

    }

}
