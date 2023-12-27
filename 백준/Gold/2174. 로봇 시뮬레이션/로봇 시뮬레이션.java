import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        static int A,B,N,M;
        static Robot[] robot;
        static boolean isTrue=false;
        static int check[][];
        static int moveX[] = {0,1,0,-1};
        static int moveY[] = {1,0,-1,0};
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            check = new int[B+1][A+1];
            robot = new Robot[N+1];
            for(int n=1; n<=N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char dir = st.nextToken().charAt(0);
                int d=0;
                if(dir=='N')
                    d = 0;
                else if(dir =='E')
                    d = 1;
                else if(dir =='S')
                    d = 2;
                else if(dir == 'W')
                    d = 3;
                check[y][x] = n;
                robot[n] = new Robot(x,y,d);
            }
            for(int m=1; m<=M; m++) {

                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                char ch = st.nextToken().charAt(0);
                int iter = Integer.parseInt(st.nextToken());

                solve(num, ch, iter);
                if(isTrue)
                    break;

            }
            if(!isTrue)
                System.out.println("OK");

        }



        private static void solve(int num, char ch, int iter) {
            // TODO Auto-generated method stub
            for(int it=0; it<iter; it++) {
                Robot rb = robot[num];
                if(ch == 'R' || ch =='L') {
                    int nextDir = getDir(rb.dir, ch);
                    robot[num] = new Robot(rb.x, rb.y, nextDir);
                }else if(ch == 'F') {
                    int newX = rb.x + moveX[rb.dir];
                    int newY = rb.y + moveY[rb.dir];
                    if(1<=newX && newX<=A && 1<=newY && newY<=B) {
                        if(check[newY][newX] != 0) {
                            System.out.println("Robot "+num +" crashes into robot " + check[newY][newX]);
                            isTrue = true;
                            return;
                        }else {
                            check[rb.y][rb.x] = 0;
                            check[newY][newX] = num;
                            robot[num] = new Robot(newX, newY, rb.dir);
                        }
                    }else {
                        System.out.println("Robot "+num+" crashes into the wall");
                        isTrue = true;
                        return;
                    }
                }
            }
        }

        public static int getDir(int dir, char ch) {

            if(ch == 'L') {
                if(dir == 0){
                    dir = 3;
                }else {
                    dir--;
                }

            }else if(ch == 'R') {
                if(dir==3) {
                    dir = 0;
                }else {
                    dir++;
                }
            }
            return dir;
        }



        public static class Robot{
            int x;
            int y;
            int dir;
            public Robot(int x, int y, int dir) {
                this.x=x;
                this.y=y;
                this.dir=dir;
            }
        }
    }