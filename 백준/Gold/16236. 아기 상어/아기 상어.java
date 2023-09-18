import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] visited;
        int shark = 2;
        int startx=0;
        int starty=0;
        int target=0;
        int target_size = 1;

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 9){
                    startx = i;
                    starty = j;
                    map[i][j] = 0;
                }
                else if(map[i][j] == 1)
                    target++;
            }
        }

        int time = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int cnt = 0;

        while(target!=0){
            visited = new int[n][n];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {startx, starty});
            visited[startx][starty] = 0;
            boolean flag = true;
            ArrayList<int[]> eatfish = new ArrayList<>();

            while(!q.isEmpty() && flag){
                int[] temp = q.poll();


                for(int d=0; d<4; d++) {
                    int x = dx[d] + temp[0];
                    int y = dy[d] + temp[1];

                    if (x >= 0 && y >= 0 && x < n && y < n ) {
                        if (visited[x][y] == 0 && map[x][y] <= shark) {
                            visited[x][y] = visited[temp[0]][temp[1]]+1;
                            q.add(new int[] {x, y});
                            if(map[x][y] != 0 && map[x][y] != shark)
                                eatfish.add(new int[] {x,y,visited[x][y]});
                        }
                    }
                }
            }

            if(eatfish.size() == 0)
                break;
            else
                cnt++;


            startx = eatfish.get(0)[0];
            starty = eatfish.get(0)[1];
            int disc = eatfish.get(0)[2];
            for(int i=1; i<eatfish.size(); i++){
                if(disc >= eatfish.get(i)[2]) {
                    if (eatfish.get(i)[0] < startx) {
                        startx = eatfish.get(i)[0];
                        starty = eatfish.get(i)[1];
                        disc = eatfish.get(i)[2];
                    } else if (eatfish.get(i)[0] == startx && eatfish.get(i)[1] < starty) {
                        startx = eatfish.get(i)[0];
                        starty = eatfish.get(i)[1];
                        disc = eatfish.get(i)[2];
                    }
                }
            }
            map[startx][starty] = 0;
            time += disc;

            if(cnt == shark){
                shark++;
                cnt = 0;
                for(int i=0; i<n; i++)
                    for(int j=0; j<n; j++)
                        if(map[i][j] == shark-1)
                            target++;
            }

        }

        System.out.println(time);


    }

    public static class node{
        int x;
        int y;
        int size;

        node(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }

    }

}