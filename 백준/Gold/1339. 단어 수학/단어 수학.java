import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] alphabet = new Integer[26];
        Arrays.fill(alphabet, 0);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                alphabet[s.charAt(s.length() - j -1) - 'A'] += (int) Math.pow(10,j);
            }
        }

        Arrays.sort(alphabet, Collections.reverseOrder());
        int answer = 0;
        int cnt = 9;
        for(Integer i : alphabet) {
            if(i == 0)  break;
            answer += i*cnt--;
        }
        System.out.println(answer);

    }

}