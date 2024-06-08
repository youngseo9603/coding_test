import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Cave implements Comparable<Cave> {
        int n;
        String[] name;

        Cave(int n, String[] name){
            this.name = name;
            this.n = n;
        }

        @Override
        public int compareTo(Cave o) {
            for(int i =0; i<Math.min(n, o.n); i++){
                if(this.name[i].equals(o.name[i]))  continue;
                else return name[i].compareTo(o.name[i]);
            }
            return n - o.n;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Cave[] caves = new Cave[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            String[] name = new String[k];
            for(int j=0; j<k; j++) {
                name[j] = st.nextToken();
            }

            caves[i] = new Cave(k, name);
        }

        Arrays.sort(caves);


        for(int i=0; i<n; i++) {
            boolean flag = true;
            for(int j=0; j<caves[i].n; j++) {
                if(flag && (i>0 && caves[i-1].n > j && caves[i].name[j].equals(caves[i-1].name[j]))){
                    continue;
                }
                else {
                    for(int k=0; k<j; k++)  System.out.print("--");
                    System.out.println(caves[i].name[j]);
                    flag = false;
                }
            }
        }
    }
}