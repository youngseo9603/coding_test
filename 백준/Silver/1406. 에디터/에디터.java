import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i=0; i<s.length(); i++){
            s1.add(s.charAt(i));
        }
        int index = s1.size();
        int n = Integer.parseInt(br.readLine());

        while(n-->0){

            String t = br.readLine();

            if(t.equals("L")){
                if(!s1.isEmpty()){
                    s2.add(s1.pop());
                }

            }
            else if(t.equals("D")){
                if(!s2.isEmpty()){
                    s1.add(s2.pop());
                }
            }
            else if(t.equals("B")){
                if(!s1.isEmpty()) {
                    s1.pop();
                }
            }
            else if(t.charAt(0) == 'P'){
                s1.add(t.charAt(2));
            }

        }

        StringBuilder sb = new StringBuilder();
        for(char a : s1)
            sb.append(a);
        for(int i=0; i<s2.size(); i++)
            sb.append(s2.get(s2.size()-i-1));
        System.out.println(sb);

    }
}