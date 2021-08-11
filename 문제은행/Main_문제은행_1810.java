package jungol;

import java.util.Scanner;

public class Main_문제은행_1810 {
	static int n, r;
	static int[] input;
	static int[] numbers;
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 9C7
		n = 9;
		r = 7;

		numbers = new int[r];		// 조합을 입력받을 배열 초기화
		input = new int[n];			// 난쟁이 모자 번호를 입력받을 배열 초기화
		
		for(int i=0; i<n; i++) {	
			input[i] = scan.nextInt();	// 난쟁이 모자 번호 입력받기
		}
		
		combination(n, r);
	}

	private static void combination(int n, int r) {
		if(r==0) {			// 조합에 요소를 모두 뽑은 경우
			int sum = 0;
			for(int num : numbers) {
				sum += num;		// 현재 조합의 난쟁이 모자 번호 합
			}
			if(sum==100) {		// 합이 100인 경우, 출력
				for(int num : numbers) {
					System.out.println(num);	
				}
			}
			return;
		}
		if(n<r) return;		// n보다 r인 큰 경우, 조합생성 불가
		
		// 선택
		numbers[r-1] = input[n-1];	// 선택한거 넣어주기
		combination(n-1, r-1);
		
		// 비선택
		combination(n-1, r);
	}
}
