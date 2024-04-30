import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            boolean surprise = true;
            if(s.equals("*"))
                break;

            for(int i=1; i<s.length()-1; i++){
                HashMap<String, Integer> map = new HashMap<>();
                for(int j=0; j<s.length()-i; j++){
                    StringBuilder sb= new StringBuilder();
                    sb.append(s.charAt(j)).append(s.charAt(j+i));
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
                }

                for(int k : map.values()){
                    if(k>1) {
                        surprise = false;
                        break;
                    }
                }
            }

            if(surprise)
                System.out.println(s + " is surprising.");
            else
                System.out.println(s + " is NOT surprising.");
        }
    }
}