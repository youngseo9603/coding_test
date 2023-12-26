import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int s;
    static int t;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        System.out.println(bfs(s));
    }

    public static class Emoticon{
        int clipboard;
        int cur;
        int time;

        Emoticon(int clipboard, int cur, int time){
            this.clipboard = clipboard;
            this.cur = cur;
            this.time = time;
        }
    }

    public static int bfs(int n){
        int time = 0;
        Queue<Emoticon> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+1][n+1];
        queue.add(new Emoticon(0,1,0));
        visited[0][1] = true;
        while (!queue.isEmpty()){
            Emoticon e = queue.poll();

            if(e.cur == n){
                time = e.time;
                break;
            }

            //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if(!visited[e.cur][e.cur]) {
                queue.add(new Emoticon(e.cur, e.cur, e.time + 1));
                visited[e.cur][e.cur] = true;
            }
            //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if(e.clipboard != 0 && e.clipboard+e.cur <=n && !visited[e.clipboard][e.clipboard+e.cur]) {
                queue.add(new Emoticon(e.clipboard, e.clipboard + e.cur, e.time+1));
                visited[e.clipboard][e.clipboard+e.cur] = true;
            }
            //화면에 있는 이모티콘 중 하나를 삭제한다.
            if(e.cur > 0 && !visited[e.clipboard][e.cur-1]) {
                queue.add(new Emoticon(e.clipboard, e.cur - 1, e.time+1));
                visited[e.clipboard][e.cur-1] = true;
            }

        }
        return time;
    }
}

/*
    1. 복사
    2. 붙여넣기
    3. 하나 지우기

 */