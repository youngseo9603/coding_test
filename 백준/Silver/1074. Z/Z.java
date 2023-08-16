import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long h = (long) Math.pow(2, n);
		long start = 0;
		long end = h*h-1;
		
		while(true) {
			
			if(h<4) {
				if(r==0 && c==0)
					System.out.println(start);
				if(r==0 && c==1)
					System.out.println(start+1);
				if(r==1 && c==0)
					System.out.println(start+2);
				if(r==1 && c==1)
					System.out.println(start+3);
				break;
			}
			
			if(r<h/2 && c<h/2) {
				end = start + h*h/4-1;
			}
			else if(r<h/2 && c>=h/2) {
				start += h*h/4;
				end = start - 1 + h*h/4;
				c -= h/2;
			}
			else if(r>=h/2 && c<h/2) {
				start += h*h/2;
				end = start + h*h/4-1;
				r -= h/2;
			}
			else if(r>=h/2 && c>=h/2) {
				start += (3*h*h/4);
				r -= h/2;
				c -= h/2;
			}

			h = h/2;
		}
		
	}

}