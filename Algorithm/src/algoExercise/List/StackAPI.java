package algoExercise.List;

public class StackAPI {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		System.out.println(stack.isEmpty());
		
		stack.push("김");
		System.out.println(stack);
		stack.push("이");
		System.out.println(stack);
		stack.push("박");
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);

	}

}
