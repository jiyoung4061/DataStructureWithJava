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
//			else if( arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i]=='/') {
//				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1) ) {
//					while (!stack.empty() && stack.peek() != '(') {
//						res += stack.pop();
//					}
//				}
//				stack.push(arr[i]);
//			} else { 
//				res += arr[i];
//			}
		}
		while (!stack.empty()) { // stack�� �����ִ� �͵� �� pop
			res += stack.pop();
		}
		return res;
	}

	public int compareOfOperand(char a, char b) {
		// ������ a�� b���� �켱������ ū ��� +1
		// b�� �� ū��� -1
		// ���� ��� == 0
//		int valOfReturn = 0;
//		switch(a) {
//		case '+':
//		case '-':
//			if( b == '/' || b == '*') valOfReturn = -1;
//			else valOfReturn = 0;
//			break;
//		case '*':
//		case '/':
//			if( b == '+' || b == '-') valOfReturn = 0;
//			else valOfReturn = 1;
//			break;
//		}
//		return valOfReturn;

		// ������ ���
		if (a == '*' || a == '/') {
			if (b == '/' || b == '*') {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (b == '/' || b == '*') {
				return -1;
			} else {
				return 0;
			}
		}
	}

//	//ù��° Ǯ�� : return ���� char
//	public char CalculatorUsingStack() {
//		
//		char[] arrayOfRes = res.toCharArray();
//		Stack<Character> stack = new Stack<Character>();
//		
//		for(int i = 0 ; i < arrayOfRes.length ; i++) {		
//			if(arrayOfRes[i] > '0' && arrayOfRes[i] <= '9') { // ������ ���
//				stack.push(arrayOfRes[i]);
//			} else { // �������ϰ��
//				int a = stack.pop();
//				int b = stack.pop();
//				stack.push((char) getResult(b, a, arrayOfRes[i]));
//			}
//		}
//		return stack.pop();
//	}

//	// �ι�° Ǯ�� : return���� int������ ���ֱ����� stack�� Integer Ÿ������ ���� => char�迭�̶� int�� �ٲٴ� �����
//	public int CalculatorUsingStack() {
//		
//		char[] arrayOfRes = res.toCharArray();
//		Stack<Integer> stack = new Stack<Integer>();
//		
//		for(int i = 0 ; i < arrayOfRes.length ; i++) {		
//			if(arrayOfRes[i]-'0' > 0 && arrayOfRes[i]-'0' <= 9) { // ������ ���
//				stack.push(arrayOfRes[i]-'0');
//			} else { // �������ϰ��
//				stack.push(getResult(stack.pop(), stack.pop(), arrayOfRes[i]));
//			}
//		}
//		return stack.pop();
//	}

//	// ���� Ǯ�� : char�� ���� ����ϵ� ������ return���� char�� int�� �ٲ���
	public int CalculatorUsingStack() {
		
		char[] arrayOfRes = res.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < arrayOfRes.length; i++) {
			if (arrayOfRes[i] > '0' && arrayOfRes[i] <= '9') { // ������ ���
				stack.push(arrayOfRes[i]);
			} else { // �������ϰ��
				stack.push((char) getResult(stack.pop(), stack.pop(), arrayOfRes[i]));
			}
		}
		return stack.pop() - '0';
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