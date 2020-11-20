package dataStructure_Stack;

public class StackCalculator {
	private String infixExpression;
	String res = "";

	public StackCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}

	public String infixToPostfix() {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = infixExpression.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				while (stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop();
			} else if (arr[i] >= '0' && arr[i] <= '9') {
				res += arr[i];
			} else {
				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1)) {
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
				}
				stack.push(arr[i]);
			}
		}
		while (!stack.empty()) { // stack에 남아있는 것들 다 pop
			res += stack.pop();
		}
		return res;
	}

	public int compareOfOperand(char a, char b) {
		// 연산자 a가 b보다 우선순위가 큰 경우 +1
		// b가 더 큰경우 -1
		// 같은 경우 == 0
		int valOfReturn = 0; // 0으로 초기값해줘야함!!!!!=> (괄호가 들어왔을 경우!
		switch (a) {
		case '+':
		case '-':
			if (b == '/' || b == '*')
				valOfReturn = -1;
			else
				valOfReturn = 0;
			break;
		case '*':
		case '/':
			if (b == '+' || b == '-')
				valOfReturn = 1;
			else
				valOfReturn = 0;
			break;
		}
		return valOfReturn;
	}

	public int CalculatorUsingStack() {

		char[] arrayOfRes = res.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < arrayOfRes.length; i++) {
			if (arrayOfRes[i] >= '0' && arrayOfRes[i] <= '9') {
				stack.push(arrayOfRes[i] - '0');
			} else {
				stack.push(getResult(stack.pop(), stack.pop(), arrayOfRes[i]));
			}
		}
		return stack.pop();
	}

	public int getResult(int a, int b, char c) {
		int result = 0;
		switch (c) {
		case '+':
			result = b + a;
			break;
		case '-':
			result = b - a;
			break;
		case '*':
			result = b * a;
			break;
		case '/':
			result = b / a;
			break;
		}
		return result;
	}
}