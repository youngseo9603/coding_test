import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int t,a,b,n,cnt;
    static int d1,d2,d3,d4;
    static char map [];
    static boolean visits[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner sc = new Scanner(System.in);

        String T = br.readLine();
        t = Integer.parseInt(T);

        for (int test_case=1; test_case<=t; test_case++) {

            String [] tmp = br.readLine().split(" ");

            a = Integer.parseInt(tmp[0]);
            b = Integer.parseInt(tmp[1]);

            map = new char [100];
            visits = new boolean [10000];
//            System.out.println(R(a));

            Queue<node> q = new LinkedList<node>();

            cnt = 0;
            q.offer(new node(a,""));
            while(!q.isEmpty()) {
                node out = q.poll();
                visits[out.getX()] = true;
                int out_x = out.getX(); //
                String out_y = out.getY(); // D S L R

//                System.out.println(out_x + "   " + out_y);


//                int out = q.poll();
                if (out_x == b) {
                    q.clear();
                    System.out.println(out_y);
                    break;
                }
                if(visits[D(out_x)]==false){
                    visits[D(out_x)] = true;
                    q.offer(new node(D(out_x), out_y+"D"));
                }
                if(visits[S(out_x)]==false) {
                    visits[S(out_x)] = true;
                    q.offer(new node(S(out_x), out_y+"S"));
                }
                if(visits[L(out_x)]==false ) {
                    visits[L(out_x)] = true;
                    q.offer(new node(L(out_x), out_y+"L"));
                }
                if(visits[R(out_x)]==false) {
                    visits[R(out_x)] = true;
                    q.offer(new node(R(out_x), out_y+"R"));
                }
//                System.out.println(Arrays.toString(q.toArray()));

            }
        }
    }

    private static class node {
        int x;
        String y;

        public node(int x, String y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public String getY() {
            return y;
        }

    }

    private static int D (int x) { //n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.

        if (2*x>=10000) {
            return ((2*x)%10000);
        }else {
            return 2*x;
        }

    }

    private static int S (int x) { //n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
        if (x==0) {
            return 9999;
        }else {
            return x-1;
        }
    }

    private static int L (int x) { //n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
        int temp3 = 0;
        // x가 231일 경우, L 레지스터를 돌렸을 때 2310이 되어야 한다.
        d1 = x/1000; // 0
        d2 = (x - d1*1000)/100; //2
        d3 = (x-(d1*1000)-(d2*100))/10; //3
        d4 = (x-(d1*1000)-(d2*100)-(d3*10)); //1

        temp3 = d2*1000+d3*100+d4*10+d1; //2 3 1 0

        return temp3;

    }

    private static int R (int x) { //n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
        int temp3 = 0;

        d1 = x/1000;
        d2 = (x - d1*1000)/100;
        d3 = (x-(d1*1000)-(d2*100))/10;
        d4 = (x-(d1*1000)-(d2*100)-(d3*10));

        temp3 = d4*1000+d1*100+d2*10+d3;

        return temp3;

    }
}