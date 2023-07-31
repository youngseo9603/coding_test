class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = times[0];
        long end = times[0];

        for(int i=1; i<times.length; i++){
            start = Math.min(start, times[i]);
            end = Math.max(end, times[i]);
        }
        end = end * n;

        while(start <= end){
            long mid = Math.floorDiv(start+end, 2);
            long checked = 0;
            for(int time : times){
                checked += Math.floorDiv(mid, time);
                if (checked >= n)
                    break;
            }
            if (checked >= n){
                answer = mid;
                end = mid-1;
            }
            else if(checked < n){
                start = mid +1;
            }
        }
        return answer;
    }
}