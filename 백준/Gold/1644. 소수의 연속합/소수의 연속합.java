import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int n;
    public static boolean[] prime;
    public static ArrayList<Integer> prime_numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prime = new boolean[n+1];
        prime_numbers = new ArrayList<>();

        prime[0] = prime[1] = true;

        for(int i=2; i*i<=n; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=n; j+=i) prime[j] = true;
            }
        }

        int answer = 0;
        int sum = 0;
        for(int i=2; i<=n; i++){
            int cnt = i;
            if(!prime[cnt]){
                sum += cnt;

                while(sum < n && cnt < n){
                    cnt++;
                    if(!prime[cnt])
                        sum += cnt;
                }

                if(sum == n)
                    answer ++;
                sum = 0;
            }
        }

        System.out.println(answer);

    }
}