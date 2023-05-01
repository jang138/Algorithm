package Softeer;

import java.util.Scanner;
import java.util.Stack;

public class test {

	public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        Stack<Integer> stack = new Stack<>();  // 인덱스를 저장할 스택
        int[] result = new int[n];  // 오큰수를 저장할 배열. 0으로 초기화.
        
        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않으면서, 스택의 마지막 값이 현재 원소보다 작은 경우
            while (!stack.empty() && a[stack.peek()] < a[i]) {
                result[stack.pop()] = a[i];  // 스택의 마지막 값의 오큰수를 현재 원소로 갱신
            }
            stack.push(i);  // 현재 원소 인덱스를 스택에 추가
        }
        
        while (!stack.empty()) {
            result[stack.pop()] = -1;  // 오큰수가 없는 경우 -1로 설정
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}