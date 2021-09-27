package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Intermediate_Coder_3517 {

	private static int binarySearchRecur (int[] A, int low, int high, int target) {
		if (low > high) {
	        return -1;
	    }
	    int mid = (low + high) >> 1;

	    if (A[mid] == target) {
	        return mid;
	    }
	    if( A[mid] > target) {
	        return binarySearchRecur(A, low, mid-1, target);
	    }
	    return binarySearchRecur(A, mid+1, high, target);	
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int[] A = new int[N];			// 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int Q = Integer.parseInt(br.readLine());	// 찾을 값의 개수
		int[] B = new int[Q];
		StringBuilder sb = new StringBuilder(Q);
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<Q; i++) {
			sb.append(binarySearchRecur(A, 0, N-1, Integer.parseInt(st.nextToken())));
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
