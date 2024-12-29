import java.util.*;

class Solution {
    
    public class Time implements Comparable<Time>{
        int hour;
        int min;
        
        Time(int hour, int min){
            this.hour = hour;
            this.min = min;
        }
        
        @Override
        public int compareTo(Time o){
            if(hour != o.hour)
                return hour-o.hour;
            else
                return min-o.min;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        Time[][] book = new Time[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++){
            int hour = Integer.parseInt(book_time[i][0].substring(0,2));
            int min = Integer.parseInt(book_time[i][0].substring(3,5));
            book[i][0] = new Time(hour,min);
            
            hour = Integer.parseInt(book_time[i][1].substring(0,2));
            min = Integer.parseInt(book_time[i][1].substring(3,5))+10;
            if(min >= 60){
                min -= 60;
                hour++;
            }
            book[i][1] = new Time(hour,min);
        }
        
    
        Arrays.sort(book, (a1, a2) -> {
            return a1[0].compareTo(a2[0]);
        });
        
        // for(int i=0; i<book.length; i++)
        //     System.out.println(book[i][0].hour + " " + book[i][0].min);
        
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for(Time[] b : book){
            System.out.println(b[0].hour + " " + b[0].min + " " + b[1].hour + " " + b[1].min);
            if(pq.isEmpty()){
                pq.add(b[1]);
            }
            else {
                Time cur = pq.peek();
                if(b[0].hour > cur.hour || (b[0].hour == cur.hour && b[0].min >= cur.min)){
                    pq.poll();
                    pq.add(b[1]);
                }
                else {
                    pq.add(b[1]);
                }
            }
        }
        
        return pq.size();
    }
}