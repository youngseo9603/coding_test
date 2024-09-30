import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int N;

    public static class Fireball implements Comparable<Fireball>{

        int r;
        int c;
        int m;
        int s;
        int d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void move() {
            this.r += s*dx[d];
            if(this.r < 0){
                while(this.r < 0)
                    this.r += N;
            }
            else if (this.r >= N) {
                while(this.r >= N)
                    this.r -= N;
            }

            this.c += s*dy[d];
            if(this.c < 0) {
                while(this.c < 0)
                    this.c += N;
            }
            else if (this.c >= N)  {
                while (this.c >= N)
                    this.c -= N;
            }
        }

        public int compareTo(Fireball f) {
            if(this.r != f.r)
                return this.r - f.r;
            else
                return this.c - f.c;
        }

    }

    public static ArrayList<Fireball> addFireball(List<Fireball> fireballs) {
        ArrayList<Fireball> response = new ArrayList<>();
        int r = fireballs.get(0).r;
        int c = fireballs.get(0).c;
        int m = 0;
        int s = 0;
        int odd = 0;
        int even = 0;

        for(Fireball f : fireballs) {
            m += f.m;
            s += f.s;
            if(f.d % 2 == 0) even++;
            else odd++;
        }
        m /= 5;
        s /= fireballs.size();

        if(m == 0)
            return response;

        if(even == 0 || odd == 0){
            response.add(new Fireball(r,c,m,s,0));
            response.add(new Fireball(r,c,m,s,2));
            response.add(new Fireball(r,c,m,s,4));
            response.add(new Fireball(r,c,m,s,6));
        }
        else {
            response.add(new Fireball(r,c,m,s,1));
            response.add(new Fireball(r,c,m,s,3));
            response.add(new Fireball(r,c,m,s,5));
            response.add(new Fireball(r,c,m,s,7));
        }
        return response;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int r, c, m, s, d;

        ArrayList<Fireball> fireballs = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            fireballs.add(new Fireball(r,c,m,s,d));

        }

        while(K-->0){

            for(Fireball f : fireballs)
                f.move();

            ArrayList<Fireball> nextFireball = new ArrayList<>();

            ArrayList<Integer>[][] map = new ArrayList[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = new ArrayList<>();
                }
            }

            for(int i=0; i<fireballs.size(); i++){
                map[fireballs.get(i).r][fireballs.get(i).c].add(i);
            }

            ArrayList<Fireball> addFireballList;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    addFireballList = new ArrayList<>();
                    if(map[i][j].size() == 1){
                        nextFireball.add(fireballs.get(map[i][j].get(0)));
                    }
                    else if (map[i][j].size() > 1){
                        for(int index : map[i][j]){
                            addFireballList.add(fireballs.get(index));
                        }
                        nextFireball.addAll(addFireball(addFireballList));
                    }
                }
            }

            fireballs = nextFireball;
        }

        int answer = 0;
        for(Fireball f : fireballs){
//            System.out.println(f.r + " " + f.c + " " + f.m + " " + f.s + " " + f.d);
            answer += f.m;
        }

        System.out.println(answer);

    }

}