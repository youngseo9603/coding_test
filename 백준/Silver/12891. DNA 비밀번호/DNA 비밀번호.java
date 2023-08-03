import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		String dna = bf.readLine();
		
		int[] type = new int[4];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<4; i++)
			type[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int answer = 0;
		int a=0;
		int c=0;
		int g=0;
		int t=0;
		while(end != p+1 && start != p-s+1) {
			
			if(end-start > s) {
				if(dna.charAt(start)=='A') a--;
				else if(dna.charAt(start)=='C') c--;
				else if(dna.charAt(start)=='G') g--;
				else if(dna.charAt(start)=='T') t--;
				start++;
			}
			else if(end-start < s) {
				if(dna.charAt(end)=='A') a++;
				else if(dna.charAt(end)=='C') c++;
				else if(dna.charAt(end)=='G') g++;
				else if(dna.charAt(end)=='T') t++;
				end++;
			}
			else {
				if(a>=type[0] && c>=type[1] && g>=type[2] && t>=type[3])
					answer +=1;
				if(dna.charAt(start)=='A') a--;
				else if(dna.charAt(start)=='C') c--;
				else if(dna.charAt(start)=='G') g--;
				else if(dna.charAt(start)=='T') t--;
				start++;
			}
			
			
		}
		System.out.println(answer);
		
	}

}