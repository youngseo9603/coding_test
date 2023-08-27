import java.io.*;

public class Main {

    static String[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = bf.readLine()) != null){
            int n = (int) Math.pow(3,Integer.parseInt(str));
            arr = new String[n];
            for(int i=0; i<n; i++)
                arr[i] = "-";

            dfs(0,n);

            for(int i=0; i<arr.length; i++){
                bw.write(arr[i]);
            }
            bw.write("\n");
            bw.flush();
        }
    }

    static void dfs(int start, int length){
        if(length < 3)
            return;

        for(int i=start+length/3; i<start+length/3*2; i++)
            arr[i] = " ";

        dfs(start, length/3);
        dfs(start+length/3*2, length/3);
    }
}
