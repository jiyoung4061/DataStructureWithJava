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
		char top;

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '(': // 열린 괄호 => 무조건 push
				stack.push(arr[i]);
				break;
			case ')': // 닫힌 괄호 => (이 나올때까지 pop해서 res에 붙여주기
				while (stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop(); // ( pop!!
				break;
			case '+':
			case '-':
//				if (stack.empty() || stack.peek() == '(') { // stack이 비어있거나, stack top이 (인 경우에는 무조건 push
//					stack.push(arr[i]);
//				} else { // 우선순위가 같거나 높은 연산자를 만났을 경우 => 연산자 모두..
//					while (!stack.empty() && stack.peek() != '(') {
//						res += stack.pop();
//					}
//					if (!stack.empty()) { // stack내에 요소가 남는경우 = ( 가 top에 있는경우
//						stack.pop();
//					}
//					stack.push(arr[i]);
//				}
//				stack.push(arr[i]);
//				break;
				top = stack.peek();
				if (top == '+' || top == '-'|| top == '/'|| top == '*') {  // 우선순위가 같거나 높은 연산자를 만났을 경우 => 연산자 모두..
					while (!stack.empty() && top != '(') {
						res += stack.pop();
					}
					if (top == '(') { // ( 가 top에 있는경우
						stack.pop();
					}
				}
				stack.push(arr[i]);
				break;
			case '*':
			case '/':
				// stack.peek()를 top으로 대체할수 없을가.....................................................................................................
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') { // 바로 push해도 되는 경우
					stack.push(arr[i]);
				} else { // 우선 순위가 같은 경우
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
					if (stack.peek()=='(') { // stack내에 요소가 남는경우 = ( 가 top에 있는경우
						stack.pop();
					}
					stack.push(arr[i]);
				}
				break;
			default: // 숫자인 경우 무조건 res에
				res += arr[i];
				break;
			}
		}

		while (!stack.empty()) { // stack에 남아있는 것들 다 pop
			res += stack.pop();
		}
		return res;
	}

}
