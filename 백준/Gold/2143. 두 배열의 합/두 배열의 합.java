import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        long[] sum_a = new long[n+1];

        // 1 3 2 4 5
        // 0 1 4 6
        for(int i=1; i<n+1; i++)
            sum_a[i] = sum_a[i-1] + a[i-1];



        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            b[i] = Integer.parseInt(st.nextToken());

        long[] sum_b = new long[m+1];
        for(int i=1; i<m+1; i++)
            sum_b[i] = sum_b[i-1] + b[i-1];

        long answer = 0;

        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                //1 2 5 3    0 1 3 8 11
                long sum = sum_a[j+1] - sum_a[i];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=i; j<m; j++){
                long sum = sum_b[j+1] - sum_b[i];
                if(map.containsKey(t-sum)){
                    answer+=map.get(t-sum);
                }
            }
        }

        System.out.println(answer);

    }
}