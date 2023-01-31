package algoExercise;

import java.util.Stack;

public class Day230131_StackAPI {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.size() + " // " + stack.isEmpty());
		
		stack.push("김");
		stack.push("이");
		stack.push("박");
		
		System.out.println(stack.size() + " // " + stack.isEmpty());
		
		System.out.println(stack.pop());
		System.out.println(stack.size() + " // " + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() + " // " + stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() + " // " + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() + " // " + stack.isEmpty());
		
	}

}
