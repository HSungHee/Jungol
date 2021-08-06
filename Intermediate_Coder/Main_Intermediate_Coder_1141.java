package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_Intermediate_Coder_1141 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer=0;
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			if(st.isEmpty()) {
				st.push(in);
			} else {
				while(!st.isEmpty()) {
					if(in>=st.peek()) {
						st.pop();
					} else {
						break;
					}
					
				}
				st.push(in);
				answer+=st.size()-1;
			}
		}
		System.out.println(answer);
	}
}
