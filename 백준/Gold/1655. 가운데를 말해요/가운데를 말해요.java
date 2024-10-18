import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(); // 중간 부터
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 중간 - 1 까지

        StringBuilder sb = new StringBuilder();
        bigHeap.add(Integer.parseInt(br.readLine()));
        sb.append(bigHeap.peek()).append("\n");

        for(int i=0; i<n-1; i++) {
            int num = Integer.parseInt(br.readLine());

            if(bigHeap.peek() > num)
                smallHeap.add(num);
            else
              bigHeap.add(num);

            if(bigHeap.size() == smallHeap.size()){
                sb.append(smallHeap.peek()).append("\n");
            }
            else if(bigHeap.size() == smallHeap.size() + 1){
                sb.append(bigHeap.peek()).append("\n");
            }
            else if (bigHeap.size() == smallHeap.size() + 2){
                smallHeap.add(bigHeap.poll());
                sb.append(smallHeap.peek()).append("\n");
            }
            else if (bigHeap.size() == smallHeap.size() - 1){
                bigHeap.add(smallHeap.poll());
                sb.append(bigHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);

    }
}

/*
    1 2
    5
 */