import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] answer = new long[3];
    static long abs = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] num = new long[n];
        for (int i = 0; i < n; i++)
            num[i] = Long.parseLong(st.nextToken());

        Arrays.sort(num);

        for(int i=0; i<n-2; i++){
            minSum(num,i);
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }

    public static void minSum(long[] num, int mid){
        int start = mid+1;
        int end = num.length-1;

        while (start<end){
            long sum = num[start]+num[mid]+num[end];
            long absSum = Math.abs(sum);

            if(abs > absSum) {
                abs = absSum;
                answer[0] = num[mid];
                answer[1] = num[start];
                answer[2] = num[end];
            }

            if(sum < 0){
                start++;
            }
            else {
                end--;
            }
        }
    }
}