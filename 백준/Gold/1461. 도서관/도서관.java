import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        int temp;
        for(int i=0; i<n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if(temp<0) {negative.add(temp);}
            else if(temp>0) {positive.add(temp);}
        }

        int answer = 0;
        if(!positive.isEmpty() && !negative.isEmpty()) {
            if (Math.abs(positive.peek()) > Math.abs(negative.peek()))
                answer -= positive.peek();
            else
                answer += negative.peek();
        }
        else{
            if(positive.isEmpty())
                answer += negative.peek();
            else
                answer -= positive.peek();
        }

        int bigger;
        while(!negative.isEmpty()){
            bigger = negative.peek();
            for(int i=0; i<m; i++){
                if(!negative.isEmpty())
                    negative.poll();
                else
                    break;
            }
            answer -= 2 * bigger;
        }

        while(!positive.isEmpty()){
            bigger = positive.peek();
            for(int i=0; i<m; i++){
                if(!positive.isEmpty())
                    positive.poll();
                else
                    break;
            }
            answer += 2 * bigger;
        }

        System.out.println(answer);

    }

}