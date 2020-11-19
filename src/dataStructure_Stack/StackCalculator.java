package dataStructure_Stack;

public class StackCalculator {
	private String infixExpression;

	public StackCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}

	public String infixToPostfix() {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = infixExpression.toCharArray();
		String res = "";
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '(') {
				stack.push(arr[i]);
			} else if(arr[i] == ')') {
				while (stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop(); 
			} else if( arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i]=='/') {
				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1) ) {
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
				}
				stack.push(arr[i]);
			} else {
				res += arr[i];
			}
		}
		while (!stack.empty()) { // stack�� �����ִ� �͵� �� pop
			res += stack.pop();
		}
		return res;
	}

	public int compareOfOperand (char a, char b) {
		// ������ a�� b���� �켱������ ū ��� +1
		// b�� �� ū��� -1
		// ���� ��� == 0
		int valOfReturn = 0;
		switch(a) {
		case '+':
		case '-':
			if( b == '/' || b == '*') valOfReturn = -1;
			else valOfReturn = 0;
			break;
		case '*':
		case '/':
			if( b == '+' || b == '-') valOfReturn = 0;
			else valOfReturn = 1;
			break;
		}
		return valOfReturn;
	}
}