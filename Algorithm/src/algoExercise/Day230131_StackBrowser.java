package algoExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day230131_StackBrowser {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> backword = new Stack<String>();
		Stack<String> forword = new Stack<String>();
		
		String current = "naver";

		while(true) {
			
			String input = br.readLine();
			if(input.charAt(0)=='Q') break;
			
			StringTokenizer st = new StringTokenizer(input);
			
			switch(st.nextToken()) {
			case "V": // visit
				backword.push(current);
				forword.clear();
				current = st.nextToken();
				break;
				
			case "B": // back
				if(backword.isEmpty()) {
					System.out.println("ignore");
					continue;
				}
				forword.push(current)
;				current = backword.pop();
				break;
				
			case "F":
				if(forword.isEmpty()) {
					System.out.println("ignore");
					continue;
				}
				backword.push(current);
				current = forword.pop();
				break;
			}
			
			System.out.println(current);
		}
	}

}
