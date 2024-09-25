import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] card = new int[n];
        for(int i=0; i<n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(0);
        }
        else if (n == 2){
            System.out.println(card[0] + card[1]);
        }
        else {
            long answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                pq.add(card[i]);
            }
            int temp;
            while(pq.size() > 1){
                temp = pq.poll() + pq.poll();
                answer += temp;
                pq.add(temp);
            }

            System.out.println(answer);

        }

    }
}