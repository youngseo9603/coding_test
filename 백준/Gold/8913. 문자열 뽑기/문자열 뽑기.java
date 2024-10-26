import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder asw = new StringBuilder();
        while(T-->0){
            String s = br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < s.length(); i++)
                if(s.charAt(i) == 'b')  list.add(1);
                else list.add(0);

            answer = false;
            dfs(list);

            if(answer) asw.append(1).append("\n");
            else asw.append(0).append("\n");
        }
        System.out.print(asw);
    }

    public static void dfs(ArrayList<Integer> s){
        if(answer) return;
        if(s.isEmpty()){
            answer = true;
            return;
        }

        int start = 0;
        ArrayList<Integer> next = new ArrayList<>();
        for(int i=1; i<s.size(); i++){
            if(s.get(start) == s.get(i)){
                if(i == s.size()-1 && i - start >= 1){
                    next = new ArrayList<>();
                    for(int j=0; j<start; j++)
                        next.add(s.get(j));
                    dfs(next);
                }
            }
            else {
                if (i - start >= 2) {
                    next = new ArrayList<>();
                    if(start == 0){
                        for(int j=i; j<s.size(); j++)
                            next.add(s.get(j));

                    }
                    else {
                        for(int j=0; j<start; j++)
                            next.add(s.get(j));
                        for(int j=i; j<s.size(); j++)
                            next.add(s.get(j));
                    }
                    dfs(next);
                    start = i;
                }
                else start = i;
            }
        }


    }
}