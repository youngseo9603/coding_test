import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = br.readLine();
        }

        for(int i=0; i<m; i++){
            String temp = br.readLine();

            for(int j=0; j<n; j++){
                if(s[j].equals(temp))
                    answer++;
            }

        }

        System.out.print(answer);

    }
}
