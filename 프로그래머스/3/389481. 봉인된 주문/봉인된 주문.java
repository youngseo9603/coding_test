import java.util.*;

class Solution {
    
    class Magic implements Comparable<Magic>{
        
        String word;
        
        Magic(String word){
            this.word = word;
        }
        
        @Override
        public int compareTo(Magic o){
            if(word.length() == o.word.length()){
                
                for(int i=0; i<word.length(); i++){
                    if(word.charAt(i) != o.word.charAt(i)){
                        return word.charAt(i) - o.word.charAt(i);
                    }
                }
                return o.word.length() - word.length();
                
            }
            else
                return word.length() - o.word.length();
        }
        
    }
    
    public String solution(long n, String[] bans) {
        String answer = "";
        
        Magic[] magics = new Magic[bans.length];
        for(int i=0; i<bans.length; i++){
            magics[i] = new Magic(bans[i]);
        }
        
        Arrays.sort(magics);
        
        for(Magic m : magics){
            if(m.compareTo(new Magic(convert(n))) <= 0){
                n += 1;
            }        
        }
        
        answer = convert(n);
        
        return answer;
    }
    
    public String convert(long num){
        String str = "";
        
        while(num > 0){
            str = String.valueOf((char)((num-1)%26+1+96)) + str;
            num = (num-1)/26;
        }
        
        return str;
        
    }
    
}