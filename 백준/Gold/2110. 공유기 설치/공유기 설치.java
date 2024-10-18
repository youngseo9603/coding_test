import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int c;
    public static int[] x;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        x = new int[n];

        for(int i=0; i<n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        int left = 1;
        int right = x[n-1] - x[0]+1;
        int mid = (left+right)/2;

        while(left < right){

            mid = (right + left)/2;
//            System.out.println(left + " " + mid + " " + right);
//            System.out.println(install(mid));
            if(install(mid)){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }

        System.out.println(left-1);

    }

    public static boolean install(int len){

        int cnt = 1;
        int lastBuild = 0;

        for(int i=1; i<n; i++){
            if(x[i]-x[lastBuild] >= len){
                cnt++;
                lastBuild = i;
            }
        }

        return cnt >= c;
    }

}

/*
    거리 최대 9 - 1

    1 2 4 8 9
 */