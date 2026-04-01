import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = -1;

        for(int a=0; a<=n; a++){
            for(int b=0; b<=m; b++){
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        for(int d=0; d<4; d++){
                            for(int c=0; c<4; c++){

                                if(a * dx[c] == 0 && b * dy[d] == 0)
                                    continue;

                                int nx = i;
                                int ny = j;
                                int num = map[nx][ny];

                                while(nx>=0 && nx<n && ny>=0 && ny<m) {
                                    if(check(num)){
                                        answer = Math.max(answer, num);
                                    }

                                    nx += a*dx[c];
                                    ny += b*dy[d];

                                    if(nx>=0 && nx<n && ny>=0 && ny<m)
                                        num = num*10 + map[nx][ny];

                                }
                            }
                        }

                    }
                }

            }
        }

        System.out.println(answer);

    }

    public static boolean check(int n){
        int sqrt = (int) Math.sqrt(n);
        return n == sqrt * sqrt;
    }
}
