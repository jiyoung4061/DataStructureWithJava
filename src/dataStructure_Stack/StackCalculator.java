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
		while (!stack.empty()) { // stack에 남아있는 것들 다 pop
			res += stack.pop();
		}
		return res;
	}

	public int compareOfOperand(char a, char b) {
		// 연산자 a가 b보다 우선순위가 큰 경우 +1
		// b가 더 큰경우 -1
		// 같은 경우 == 0
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

		// 선생님 방법
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

//	//첫번째 풀이 : return 값이 char
//	public char CalculatorUsingStack() {
//		
//		char[] arrayOfRes = res.toCharArray();
//		Stack<Character> stack = new Stack<Character>();
//		
//		for(int i = 0 ; i < arrayOfRes.length ; i++) {		
//			if(arrayOfRes[i] > '0' && arrayOfRes[i] <= '9') { // 숫자일 경우
//				stack.push(arrayOfRes[i]);
//			} else { // 연산자일경우
//				int a = stack.pop();
//				int b = stack.pop();
//				stack.push((char) getResult(b, a, arrayOfRes[i]));
//			}
//		}
//		return stack.pop();
//	}

//	// 두번째 풀이 : return값을 int값으로 해주기위해 stack을 Integer 타입으로 받음 => char배열이라 int로 바꾸는 빈번함
//	public int CalculatorUsingStack() {
//		
//		char[] arrayOfRes = res.toCharArray();
//		Stack<Integer> stack = new Stack<Integer>();
//		
//		for(int i = 0 ; i < arrayOfRes.length ; i++) {		
//			if(arrayOfRes[i]-'0' > 0 && arrayOfRes[i]-'0' <= 9) { // 숫자일 경우
//				stack.push(arrayOfRes[i]-'0');
//			} else { // 연산자일경우
//				stack.push(getResult(stack.pop(), stack.pop(), arrayOfRes[i]));
//			}
//		}
//		return stack.pop();
//	}

//	// 최종 풀이 : char로 값을 계산하되 마지막 return에서 char를 int로 바꿔줌
	public int CalculatorUsingStack() {
		
		char[] arrayOfRes = res.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < arrayOfRes.length; i++) {
			if (arrayOfRes[i] > '0' && arrayOfRes[i] <= '9') { // 숫자일 경우
				stack.push(arrayOfRes[i]);
			} else { // 연산자일경우
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