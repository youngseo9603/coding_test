import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        int[] bag = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<k; i++)
            bag[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bag);
        Arrays.sort(jewels);

        long answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++){
            int b = bag[i];

            while(cnt<n && jewels[cnt].weight <= b){
                pq.add(jewels[cnt].price);
                cnt++;
            }
            if(!pq.isEmpty())
                answer += pq.poll();
        }

        System.out.println(answer);
    }

    public static class Jewel implements Comparable<Jewel> {

        int weight;
        int price;

        Jewel(int weight, int price){
            this.price = price;
            this.weight = weight;
        }

        public int compareTo(Jewel o){
            if(weight > o.weight)
                return 1;
            else
                return -1;
        }
    }
}