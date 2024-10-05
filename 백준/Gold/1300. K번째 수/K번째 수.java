import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            int cnt = 0;
            for(int i=1; i<=n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                left = mid + 1;
            }
            else
                right = mid;
        }

        System.out.println(right);


    }
}

/*
    1 2 3 4 5 6 7 8
    2 4 6 8
    3 6 9 12
    4 8 12 16
    5
    6
    7
    8


    100000 *
    50 50 2500
    40 40 1600
    30 30 900
    31 31

 */