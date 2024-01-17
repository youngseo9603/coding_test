import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        HashMap<Integer, List<Integer>> to = new HashMap<>();
        HashMap<Integer, List<Integer>> from = new HashMap<>();
        
        List<Integer> list;
        int max_node = 0;
        for(int i=0; i<edges.length; i++){
            list = new ArrayList<>();
            list = to.getOrDefault(edges[i][0], list);
            list.add(edges[i][1]);
            to.put(edges[i][0], list);
            
            list = new ArrayList<>();
            list = from.getOrDefault(edges[i][1], list);
            list.add(edges[i][0]);
            from.put(edges[i][1], list);
            
            max_node = Math.max(edges[i][0] , max_node);
            max_node = Math.max(edges[i][1] , max_node);
        }
        
        int cnt = 0;
        for(int i : to.keySet()){
            
            if(!from.containsKey(i) && to.get(i).size() > cnt){
                answer[0] = i;
                cnt = to.get(i).size();
            }
        }
        
        List<Integer> start = to.get(answer[0]);
        boolean[] visited;
        for(int s : start){
            visited = new boolean[max_node+1];
            Stack<Integer> stack = new Stack<>();
            stack.add(s);
            visited[s] = true;
            boolean circle = false;
            int max_cnt = 0;
            int time = 0;
            while(!stack.isEmpty()){
                int temp = stack.pop();

                cnt = 0;
                if(to.containsKey(temp)){
                    for(int t : to.get(temp))
                        if(t!=answer[0])
                            cnt++;
                }
                if(from.containsKey(temp)){
                    for(int t : from.get(temp))
                        if(t!=answer[0])
                            cnt++;
                }
                max_cnt = Math.max(max_cnt, cnt);
                
                // if(temp == s && time == 0){
                //     if(to.containsKey(s) && to.get(s).size()==1 && to.get(s).get(0)==s){
                //         max_cnt = 2;
                //     }
                // }
                
                
                
                if(to.containsKey(temp)){
                    List<Integer> to_list = to.get(temp);
                    for(int t : to_list){
                        if(t == s){
                            circle = true;
                            continue;
                        }
                        else if (visited[t])
                            continue;
                        stack.add(t);
                        visited[t] = true;
                    }
                }
                time++;
            }
            
            if(max_cnt == 4)
                answer[3]++;
            else{
                if(circle)
                    answer[1]++;
                else
                    answer[2]++;
            }
                
            
        }
        
        return answer;
    }
}