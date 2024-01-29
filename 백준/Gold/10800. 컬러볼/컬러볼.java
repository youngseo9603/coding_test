import java.io.*;
import java.util.*;

public class Main {

    public static class Ball{
        int index;
        int color;
        int weight;

        Ball(int index, int color, int weight){
            this.index = index;
            this.color = color;
            this.weight = weight;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Ball[] balls = new Ball[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, weight);
        }

        int[] colorSum = new int[n+1];
        int[] answer = new int[n];
        int sum = 0;
        Arrays.sort(balls, (x,y) -> x.weight - y.weight);

        int j=0;
        for(int i=0; i<n; i++){
            Ball a = balls[i];
            Ball b = balls[j];

            while(b.weight < a.weight){
                sum += b.weight;
                colorSum[b.color] += b.weight;
                b = balls[++j];
            }

            answer[a.index] = sum - colorSum[a.color];

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(answer[i]).append("\n");
        System.out.println(sb);
    }
}