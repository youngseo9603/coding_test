import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            truck[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 1;
        for(int i=0; i<w-1; i++)
            deque.addLast(0);

        deque.addLast(truck[0]);
        int sum = truck[0];
        int time = 1;
        while(sum != 0) {
            if(index != n && sum + truck[index] - deque.peekFirst() <= l) {
                sum += truck[index] - deque.pollFirst();
                deque.addLast(truck[index]);
                index ++;
            }
            else {
                sum -= deque.pollFirst();
                deque.addLast(0);
            }
            time++;
        }

        System.out.println(time);

    }
}