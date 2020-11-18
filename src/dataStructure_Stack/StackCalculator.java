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
			case '(': // ���� ��ȣ => ������ push
				stack.push(arr[i]);
				break;
			case ')': // ���� ��ȣ => (�� ���ö����� pop�ؼ� res�� �ٿ��ֱ�
				while (stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop(); // ( pop!!
				break;
			case '+':
			case '-':
//				if (stack.empty() || stack.peek() == '(') { // stack�� ����ְų�, stack top�� (�� ��쿡�� ������ push
//					stack.push(arr[i]);
//				} else { // �켱������ ���ų� ���� �����ڸ� ������ ��� => ������ ���..
//					while (!stack.empty() && stack.peek() != '(') {
//						res += stack.pop();
//					}
//					if (!stack.empty()) { // stack���� ��Ұ� ���°�� = ( �� top�� �ִ°��
//						stack.pop();
//					}
//					stack.push(arr[i]);
//				}
//				stack.push(arr[i]);
//				break;
				top = stack.peek();
				if (top == '+' || top == '-'|| top == '/'|| top == '*') {  // �켱������ ���ų� ���� �����ڸ� ������ ��� => ������ ���..
					while (!stack.empty() && top != '(') {
						res += stack.pop();
					}
					if (top == '(') { // ( �� top�� �ִ°��
						stack.pop();
					}
				}
				stack.push(arr[i]);
				break;
			case '*':
			case '/':
				// stack.peek()�� top���� ��ü�Ҽ� ������.....................................................................................................
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') { // �ٷ� push�ص� �Ǵ� ���
					stack.push(arr[i]);
				} else { // �켱 ������ ���� ���
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
					if (stack.peek()=='(') { // stack���� ��Ұ� ���°�� = ( �� top�� �ִ°��
						stack.pop();
					}
					stack.push(arr[i]);
				}
				break;
			default: // ������ ��� ������ res��
				res += arr[i];
				break;
			}
		}

		while (!stack.empty()) { // stack�� �����ִ� �͵� �� pop
			res += stack.pop();
		}
		return res;
	}

}
