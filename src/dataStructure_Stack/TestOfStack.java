package dataStructure_Stack;

public class TestOfStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();

		stack.push("Hello");
		stack.push("World!");
		stack.push("My");
		stack.push("name");
		stack.push("is");
		stack.push("jiyoung");

		while (stack.empty() == false) {
			String s = stack.pop();
			System.out.println(s);
		}

		stack = new Stack<String>();
		stack.push("Hello");

		System.out.println(stack.pop());
		System.out.println(stack.pop()); // indexOutOfBoundsException ¹ß»ý
	}

}
