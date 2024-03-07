import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = n-1;
        long min = Long.MAX_VALUE;
        int ms = 0;
        int me = 0;
        while(start < end){
            long sum = (long)map[start] + (long)map[end];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                ms = start;
                me = end;
            }
            if(sum>=0)
                end--;
            else
                start++;
        }

        System.out.println(map[ms] + " " + map[me]);

    }
}