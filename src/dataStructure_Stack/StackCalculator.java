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
				stack.pop(); // ( pop해주기
			} else if( arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i]=='/') {				
				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1) ) { //우선순위가 같거나 높은 연산자를 만났을 경우 => 연산자 모두..						
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
				}
				stack.push(arr[i]);
			} else {
				res += arr[i];
			}
		}
		while (!stack.empty()) { // stack에 남아있는 것들 다 pop
			res += stack.pop();
		}
		return res;
	}
	
	public int compareOfOperand (char a, char b) {
		// 연산자 a가 b보다 우선순위가 큰 경우 +1
		// b가 더 큰경우 -1
		// 같은 경우 == 0
		int valOfReturn = 0; //0으로 초기값해줘야함!!!!!=> (괄호가 들어왔을 경우!
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