import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while(t.length() > s.length()){
            if(t.charAt(t.length()-1) == 'A'){
                t.deleteCharAt(t.length()-1);
            }
            else if(t.charAt(t.length()-1) == 'B'){
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(t.toString().equals(s.toString())) System.out.println(1);
        else System.out.println(0);

    }

}