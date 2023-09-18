import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());


        String[] s = br.readLine().split(" ");
        int[] block = new int[w];
        for(int i=0; i<w; i++)
            block[i] = Integer.parseInt(s[i]);

        int rain = 0;

        for(int i=1; i<w-1; i++) {
            int left_max = 0;
            int right_max = 0;

            for(int j=0; j<i; j++)
                left_max = Math.max(left_max, block[j]);

            for(int j=i+1; j<w; j++)
                right_max = Math.max(right_max, block[j]);

            if(block[i] < left_max && block[i] < right_max)
                rain += Math.min(left_max, right_max) - block[i];

        }
        System.out.println(rain);



    }

}