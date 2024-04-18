import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] child = new int[n];
        Minus[] minuses = new Minus[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            child[i] = Integer.parseInt(st.nextToken());
            if(i>0)
                minuses[i-1] = new Minus(i-1, child[i]-child[i-1]);
        }

        Arrays.sort(minuses);

        int answer = 0;
        for(int i=0; i<n-k; i++){
            answer += minuses[i].minus;
        }

        System.out.println(answer);


    }

    public static class Minus implements Comparable<Minus> {
        int index;
        int minus;

        Minus(int index, int minus){
            this.minus = minus;
            this.index = index;
        }

        @Override
        public int compareTo(Minus o) {
            return this.minus - o.minus;
        }
    }
}