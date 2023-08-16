import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[n];
		st = new StringTokenizer(bf.readLine());
		long end = -1;
		for(int i=0; i<n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (end < tree[i])
				end = tree[i];
		}
		long start = 1;
		long height;
		long log;
		while(start<=end) {
			height = Math.floorDiv(start+end, 2);
			log = 0;
			for(int i=0; i<n; i++) 
				if(tree[i] > height)
					log += tree[i] - height;
			
			if(log >= m)
				start = height + 1;
			else
				end = height-1;
		}
		
		System.out.println(end);
	}

}