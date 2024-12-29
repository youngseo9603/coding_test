import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer;
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    visited[i][j] = true;
                    Stack<int[]> stack = new Stack<>();
                    stack.add(new int[] {i,j,maps[i].charAt(j)-'0'});
                    
                    int land = 0;
                    while(!stack.isEmpty()){
                        int[] cur = stack.pop();
                        land += cur[2];
                        
                        for(int d=0; d<4; d++){
                            int x = cur[0] + dx[d];
                            int y = cur[1] + dy[d];
                            
                            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && maps[x].charAt(y) != 'X'){
                                visited[x][y] = true;
                                stack.add(new int[] {x,y,maps[x].charAt(y)-'0'});
                            }
                        }
                    }
                    list.add(land);
                }
            }
        }
        
        if(list.size() != 0){
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++)
                answer[i] = list.get(i);
            Arrays.sort(answer);    
        }
        else{
            answer = new int[] {-1};
        }
        
        return answer;
    }
}