import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        for (int k = 0; k < n && s > 0; k++) {

            int max = arr[k];
            int idx = -1;
            for(int i=k+1; i<n && i<=s+k; i++){
                if(arr[i] > max){
                    max = arr[i];
                    idx = i;
                }
            }

            if(idx == -1)   continue;

            s -= idx-k;
            for(int i=idx; i>=k+1; i--){
                swap(i);
            }

        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);


    }

    static int[] swap(int i){
        int temp = arr[i-1];
        arr[i-1] = arr[i];
        arr[i] = temp;
        return arr;
    }
}