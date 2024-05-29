import java.util.*;

class Solution {
    
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        if(find(maps, 'S', 'L') == -1 || find(maps, 'L', 'E') == -1)
            answer = -1;
        else
            answer = find(maps, 'S', 'L') + find(maps, 'L', 'E');
        
        return answer;
    }
    
    public int find(String[] map, char start ,char target){
        int x = 0;
        int y = 0;
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length(); j++)
                if(map[i].charAt(j) == start){
                    x = i;
                    y = j;
                }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length()];
        queue.add(new int[] {x,y,0});
        visited[x][y] = true;
        int response = -1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            
            if(map[temp[0]].charAt(temp[1]) == target){
                response = temp[2];
            }
            
            for(int d=0; d<4; d++){
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];
                
                if(nx>=0 && ny>=0 && nx<map.length && ny<map[0].length() 
                   && map[nx].charAt(ny)!='X' && !visited[nx][ny]){
                    queue.add(new int[] {nx,ny,temp[2]+1});
                    visited[nx][ny] = true;
                }
                
            }
        }
        
        return response;
    }
    
    
}