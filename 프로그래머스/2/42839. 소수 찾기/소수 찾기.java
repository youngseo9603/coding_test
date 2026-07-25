import java.util.*;

class Solution {
    
    public static int answer;
    StringBuilder sb;
    public static boolean[] done;
    
    public int solution(String numbers) {
        answer = 0;
        sb = new StringBuilder();
        done = new boolean[(int)Math.pow(10,numbers.length()+1)];
        
        boolean[] visited;
        int[] num = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            num[i] = numbers.charAt(i) - '0';
        }
        
        
        for(int d=0; d<=numbers.length(); d++){
            visited = new boolean[numbers.length()];
            dfs(d,visited, num, 0);
        }
        
        return answer;
    }
    
    public void dfs(int depth, boolean[] visited, int[] nums, int num){
        if(depth == 0){
            if(isPrime(num)&&!done[num]){
                done[num] = true;
                answer++;
            }
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth-1, visited, nums, num*10 + nums[i]);
                visited[i] = false;
            }
        }
        
        
    }
    
    public boolean isPrime(int num){
        
        if(num==0 || num==1){
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    
}