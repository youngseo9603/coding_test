import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i=0; i<n; i++){
            if(num[i] > list.get(list.size()-1)){
                list.add(num[i]);
            }
            else {
                int start = 0;
                int end = list.size()-1;
                int mid;

                while(start < end){
                    mid = (start + end)/2;
                    if(num[i] <= list.get(mid)){
                        end = mid;
                    }
                    else {
                        start = mid + 1;
                    }
                }
                list.set(end, num[i]);
            }
        }

        System.out.println(list.size()-1);


    }
}