package dataStructure_Stack;

public class TestOfLinkedListStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LinkedListStack<String> stack = new LinkedListStack<String>();
			
			stack.push("Hello");
			stack.push("World!");
			stack.push("My");
			stack.push("name");
			stack.push("is");
			stack.push("jiyoung");
			
			while(stack.empty() == false) {
				String s = stack.pop();
				System.out.println(s);
			}
			
			stack = new LinkedListStack<String>();
			stack.push("Hello2");
			
			System.out.println(stack.pop());
			System.out.println(stack.pop());	
			
		} catch(StackException e) {
			System.out.println(e.getMessage());
		}
	}

}
