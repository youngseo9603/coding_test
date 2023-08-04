import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase=0; testCase<10; testCase++) {

			int t = Integer.parseInt(bf.readLine());
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			Deque<Integer> num = new ArrayDeque<>();
			for(int i=0; i<8; i++)
				num.addLast(Integer.parseInt(st.nextToken()));
			
			int k = 0;
			while(true) {
				int temp = num.pollFirst() - ++k;
				if(temp <= 0) {
					num.addLast(0);
					break;
				}
				num.addLast(temp);
				k = k%5;
			}
			
			System.out.print("#" + (testCase+1) + " " );
			
			for(int i=0; i<8; i++)
				System.out.print(num.pollFirst() + " ");
			
			System.out.println();
		}
	}

}