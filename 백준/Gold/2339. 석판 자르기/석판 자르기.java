import java.util.*;
import java.io.*;
public class Main {
    static int[][] stones; //전역 변수 선언
    static int solution = 0;
    static boolean state = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int result_ver = 0;//세로로 자르는 것을 시작한 경우의 수
        int result_hor = 0;//가로로 자르는 것을 시작한 경우의 수
        int n = Integer.parseInt(br.readLine());
        stones = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stones[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        result_ver = GetSolution(0, n, 0, n, 1);
        result_hor = GetSolution(0, n, 0, n, 2);
        //만약 초기 석판에 불순물이 하나도 없을 경우
        if (result_ver+result_hor>0)
        	if(IsStone(0,n,0,n))
        		bw.write(String.valueOf(result_ver+result_hor));
        	else
        		bw.write(String.valueOf(1));
        else
            bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }
    //기존 석판에 불순물이 있는지 찾아주는 메소드
    public static boolean IsStone(int x_s,int x_e,int y_s,int y_e) {
    	for(int i= x_s;i<x_e;i++) {
    		for(int j=y_s;j<y_e;j++) {
    			if(stones[i][j]==1)
    				return true;
    			
    		}
    	} 
			return false;
    }
    //자르려는 범위 안에 보석이 포함되어있는지 확인하는 메소드
    public static boolean IsJewel(int x, int y, int x_s, int x_e, int y_s, int y_e, int mod) {
         if (mod == 1) { //세로로 잘랐을때
            for (int i = x_s; i < x_e; i++) {
                if (stones[i][y] == 2)
                    return false;
            }
        } else {//가로로 잘랐을 때
            for (int j = y_s; j < y_e; j++) { 
                if (stones[x][j] == 2) 
                    return false;
            }
        }
        return true;
    }

    public static int GetSolution(int x_start, int x_end, int y_start, int y_end, int mod) {
        
        
    	int trash=0;
    	int jewel=0;
        int result=0;
        int result_one=0;
        int result_two=0;
     	//보석과 불순물 카운트
        for (int i = x_start; i < x_end; i++) {
            for (int j = y_start; j < y_end; j++) {
               if(stones[i][j]==1)
            	  trash++;
               if(stones[i][j]==2)
            	   jewel++;
             
            }
        }
        
        //자른 석판에 보석이 아예 없거나, 보석이 2개이상인데 자를 불순물이 없다면, 잘못자른걸로 취급한다.
        if(jewel==0||jewel>=2&&trash==0||jewel==1&&trash>=1) {
        	return 0;
        }else if(jewel==1&&trash==0) {//만약 석판에 불순물이 없고, 보석이 1개 있다면 잘 자른걸로 취급해 1를 리턴한다. 
  
        	return 1;
        }
        //잘라야할 경우 
        for (int i = x_start; i < x_end; i++) {
            for (int j = y_start; j < y_end; j++) {
               if(stones[i][j]==1&&IsJewel(i,j,x_start,x_end,y_start,y_end,mod)) {//mod=1 세로로 자른것,mod=2 가로로 자른것
            	   if(mod==1) {
            		   if(j==y_end-1||j==y_start) //만약 불순물이 외곽에 있을경우 자르지 못한다. *석판은 무조건 두조각으로 나뉘어야한다
            			  continue;
            		   result_one=GetSolution(x_start,x_end,y_start,j,2);
            		   result_two=GetSolution(x_start,x_end,j+1,y_end,2);
            	   }else {
            		   if(i==x_end-1||i==x_start) //만약 불순물이 외곽에 있을경우 자르지 못한다. *석판은 무조건 두조각으로 나뉘어야한다
            			   continue;
            			 
            		   result_one=GetSolution(x_start,i,y_start,y_end,1);
            		   result_two=GetSolution(i+1,x_end,y_start,y_end,1);
            	   }
            	  
            	   
            	   //방법을 누적해서 더해준다. 
            	   result +=  result_one * result_two;
               }
               
               
             
            }
            
        }
        
        return result;
        
    }
}