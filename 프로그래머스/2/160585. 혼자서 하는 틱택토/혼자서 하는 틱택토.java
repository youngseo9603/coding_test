class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int countO = 0;
        int countX = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'O')
                    countO++;
                else if(board[i].charAt(j) == 'X')
                    countX++;
            }
        }
        
        if(countO < countX)
            answer = 0;
        else if(countO > countX+1)
            answer = 0;
        else {
            boolean scoredO = false;
            boolean scoredX = false;
            
            for(int i=0; i<3; i++){
                if(board[i].equals("OOO"))
                    scoredO = true;
                else if (board[i].equals("XXX"))
                    scoredX = true;
                
                if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O'){
                    scoredO = true;
                }
                else if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X'){
                    scoredX = true;
                }   
            }
            
            if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'){
                scoredO = true;
            }
            else if(board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O'){
                scoredO = true;
            }
            
            if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'){
                scoredX = true;
            }
            else if(board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X'){
                scoredX = true;
            }
            
            System.out.println(scoredO + "" + scoredX);
            
            if(scoredO && scoredX)
                answer = 0;
            
            if (scoredO && countO == countX)
                answer = 0;
            
            if (scoredX && countO != countX)
                answer = 0;
            
        }
        
        
        return answer;
    }
}