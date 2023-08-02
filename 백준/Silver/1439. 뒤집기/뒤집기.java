import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("t");
		sb.append(bf.readLine());
		int cnt = 0;
		for(int i=0; i<sb.length()-1; i++) {
			if(sb.charAt(i) != sb.charAt(i+1)) {
				cnt++;
			}
		}
		
		System.out.println(Math.floorDiv(cnt, 2));
		
	}
}