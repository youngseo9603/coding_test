import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    static int n;
    static String answer;
    static boolean first;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        first = false;

        backtracking(0, new StringBuilder());
        System.out.println(answer);

    }

    public static void backtracking(int depth, StringBuilder num){
//        System.out.println("depth " + depth);

        if(first)
            return;

        for(int i=0; i<num.length()/2; i++){
//            System.out.println("i = " + i + " num = " + num);
//            System.out.println(num.substring(depth-i-1, depth) + " " + num.substring(depth-2*i-2, depth-i-1));
            if(num.substring(depth-i-1, depth).equals(num.substring(depth-2*i-2, depth-i-1)))
                return;
        }

        if(depth == n){
            answer = num.toString();
            first = true;
            return;
        }

        num.append(1);
        backtracking(depth+1, num);
        num.deleteCharAt(num.length()-1);
        num.append(2);
        backtracking(depth+1, num);
        num.deleteCharAt(num.length()-1);
        num.append(3);
        backtracking(depth+1, num);
        num.deleteCharAt(num.length()-1);
    }

}