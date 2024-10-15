import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static class Place implements Comparable<Place> {
        public int x;
        public int y;
        public int wall;

        public Place(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
        public int compareTo(Place o) {
            return this.wall - o.wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        PriorityQueue<Place> pq = new PriorityQueue<>();
        pq.add(new Place(0, 0, 0));
        boolean[][] visited = new boolean[m][n];

        int answer = -1;

        while(!pq.isEmpty()) {
            Place cur = pq.poll();

            if(cur.x == m-1 && cur.y == n-1) {
                answer = cur.wall;
            }

            for(int d=0; d<4; d++){
                int x = cur.x + dx[d];
                int y = cur.y + dy[d];

                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){

                    if(map[x][y] == 0){
                        pq.add(new Place(x, y, cur.wall));
                        visited[x][y] = true;
                    }
                    else {
                        pq.add(new Place(x, y, cur.wall+1));
                        visited[x][y] = true;
                    }
                }

            }

        }

        System.out.println(answer);

    }
}