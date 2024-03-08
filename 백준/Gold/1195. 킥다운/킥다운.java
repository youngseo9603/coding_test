import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String g1 = br.readLine();
        String g2 = br.readLine();
        int length = g1.length()+g2.length();
        int[] gear1 = new int[g1.length()];
        int[] gear2 = new int[g2.length()];

        for(int i=0; i<g1.length(); i++)
            gear1[i] = g1.charAt(i) - 48;

        for(int i=0; i<g2.length(); i++)
            gear2[i] = g2.charAt(i) - 48;

        int answer1 = rotate(g1, g2, gear1, gear2, length);
        int answer2 = rotate(g2, g1, gear2, gear1, length);
        int answer = Math.min(answer2, answer1);

        System.out.println(answer);
    }

    public static int rotate(String g1, String g2, int[] gear1, int[] gear2, int length){
        int[] gear_sum;
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=g1.length(); i++){

            gear_sum = new int[length];

            for(int j=0; j<g1.length(); j++){
                gear_sum[j] += gear1[j];
            }

            for(int j=0; j<g2.length(); j++){
                gear_sum[i+j] += gear2[j];
            }

            boolean flag = true;
            for(int j=0; j<length; j++){
                if(gear_sum[j] > 3){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer = Math.min(answer, Math.max(g1.length(), i+g2.length()));
            }
        }

        return answer;
    }
}