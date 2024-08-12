import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<Shark> sharks;
    public static int r;
    public static int c;
    public static int m;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int answer;

    public static class Shark implements Comparable<Shark> {
        int r;
        int c;
        int s;  //속력
        int d;  //이동 방향
        int z;  //크기


        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return z - o.z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        sharks = new ArrayList();
        int a, b, s, d, z;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken())-1;
            z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(a, b, s, d, z));
        }

        Collections.sort(sharks);

        for(int i=1; i<=c; i++){
            catchShark(i);
            moveShark();
            eatShark();
        }

        System.out.println(answer);

    }

    public static void moveShark(){
        for(int i=0; i<sharks.size(); i++){
            int cnt = sharks.get(i).s;
            while(cnt > 0) {
                if (sharks.get(i).d == 0) {
                    if (sharks.get(i).r == 1) {
                        sharks.get(i).r++;
                        sharks.get(i).d = 1;
                    } else sharks.get(i).r--;
                } else if (sharks.get(i).d == 1) {
                    if(sharks.get(i).r == r){
                        sharks.get(i).r--;
                        sharks.get(i).d = 0;
                    }
                    else sharks.get(i).r++;
                } else if (sharks.get(i).d == 2) {
                    if(sharks.get(i).c == c){
                        sharks.get(i).c--;
                        sharks.get(i).d = 3;
                    }
                    else sharks.get(i).c++;
                } else if (sharks.get(i).d == 3) {
                    if(sharks.get(i).c == 1){
                        sharks.get(i).c++;
                        sharks.get(i).d = 2;
                    }
                    else sharks.get(i).c--;
                }
                cnt--;
            }
        }
    }

    public static void catchShark(int k){
        Shark s = new Shark(r+1,k,0,0,0);
        int cnt = -1;
        for(int i=0; i<sharks.size(); i++){
            if(sharks.get(i).c == k){
                if(s.r > sharks.get(i).r) {
                    s = sharks.get(i);
                    cnt = i;
                }
            }
        }
//        System.out.println(s.r + " " + s.c + " " + s.z);
        answer += s.z;
        if(cnt != -1) {
            sharks.remove(cnt);
        }
    }

    public static void eatShark(){
        boolean[][] visited = new boolean[r+1][c+1];
        for(int i=sharks.size()-1; i>=0; i--){
            if(visited[sharks.get(i).r][sharks.get(i).c]){
                sharks.remove(i);
            }
            visited[sharks.get(i).r][sharks.get(i).c] = true;
        }
    }

}