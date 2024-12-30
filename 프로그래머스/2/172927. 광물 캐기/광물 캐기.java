import java.util.*;
class Solution {
    
    public int[][] score = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        backtracking(0,picks,minerals,0);
        return answer;
    }
    
    public void backtracking(int depth, int[] picks, String[] minerals, int tired){
        if(5*depth >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)){
            answer = Math.min(tired, answer);
            return;
        }
        
        if(picks[0] > 0){
            int t = 0;
            picks[0]--;
            for(int i=depth*5; i<depth*5+5 && i<minerals.length; i++){
                t+=1;
            }
            backtracking(depth+1, picks, minerals, tired+t);
            picks[0]++;
        }
        
        if(picks[1] > 0){
            int t = 0;
            picks[1]--;
            for(int i=depth*5; i<depth*5+5 && i<minerals.length; i++){
                if(minerals[i].equals("diamond"))
                    t+=5;
                else
                    t+=1;
            }
            backtracking(depth+1, picks, minerals, tired+t);
            picks[1]++;
        }
        
        if(picks[2] > 0){
            int t = 0;
            picks[2]--;
            for(int i=depth*5; i<depth*5+5 && i<minerals.length; i++){
                if(minerals[i].equals("diamond"))
                    t+=25;
                else if(minerals[i].equals("iron"))
                    t+=5;
                else
                    t+=1;
            }
            backtracking(depth+1, picks, minerals, tired+t);
            picks[2]++;
        }
        
    }
}