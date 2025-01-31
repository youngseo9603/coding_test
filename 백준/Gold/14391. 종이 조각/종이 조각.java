import java.io.*;
import java.util.*;
public class Main {
	public static int N,M,max = Integer.MIN_VALUE;
	public static int[][] paper;	//종이의 들어갈 숫자 값
	public static boolean[][] check;	//종이 가로,세로 자른 방향
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        //----------입력값 저장 및 배열 초기화------------
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	paper = new int[N][M];
    	check = new boolean[N][M];
    	for(int i=0;i<N;i++) {
    		String str = br.readLine();
    		for(int j=0;j<M;j++) {
    			paper[i][j] = Character.getNumericValue(str.charAt(j));
    		}
    	}
    	dfs(0,0);		//함수 실행
    	bw.write(max + "\n");		//최대합 BufferedWriter 저장
    	bw.flush();			//결과 출력
    	bw.close();
    	br.close();
    }
    //--------종이 조각내는 모든 경우 구하는 함수--------
    public static void dfs(int x, int y) {
    	if(x==N) {	//종이 조각내는 것 완성시 조각난 종이 합 구하기
    		sum();
    		return;
    	}
    	if(y==M) {	//해당 행 완료시 다음 행으로 이동
    		dfs(x+1,0);
    		return;
    	}
    	check[x][y] = true;		//가로로 잘랐을 때
    	dfs(x,y+1);
    	
    	check[x][y] = false;	//세로로 잘랐을 때
    	dfs(x,y+1);
    }
    //-------조각난 종이 합 구하는 함수--------
    public static void sum() {
    	int result = 0;
    	int temp;
    	for(int i=0;i<N;i++) {		//가로 합, 행 기준 탐색
    		temp = 0;
    		for(int j=0;j<M;j++) {
    			if(check[i][j]) {	//가로로 자른 값 연속할 때
    				temp *= 10;
    				temp += paper[i][j];
    			}else {		//세로로 자른 값 만났을 때
    				result += temp;
    				temp = 0;
    			}
    		}
    		result += temp;
    	}
    	for(int i=0;i<M;i++) {		//세로 합, 열 기준 탐색
    		temp = 0;
    		for(int j=0;j<N;j++) {
    			if(!check[j][i]) {	//세로로 자른 값 연속할 때
    				temp *= 10;
    				temp += paper[j][i];
    			}else {		//가로로 자른 값 만났을 때
    				result += temp;
    				temp = 0;
    			}
    		}
			result += temp;
    	}
    	max = Math.max(max, result);		//최대값 비교
    	return;
    }
}