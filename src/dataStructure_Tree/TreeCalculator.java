package dataStructure_Tree;

import dataStructure_Stack.Stack;

public class TreeCalculator<E> {
	private String infixExpression;
	String res = "";

	LinkedTree<String> tree = new LinkedTree<String>();

	public TreeCalculator(String infixExpression) {
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
				while (!stack.empty() && stack.peek() != '(' && compareOfOperand(arr[i], stack.peek()) < 1) {
					res += stack.pop();
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
		int valOfReturn = 0;
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

	public LinkedTree<String> makeExpressionTree() {
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>();
		char[] arr = res.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			LinkedTree.TreeNode<String> node = new LinkedTree.TreeNode<String>(String.valueOf(arr[i]));
			if (node.getNode().equals("+") || node.getNode().equals("-") || node.getNode().equals("/")
					|| node.getNode().equals("*")) { // 연산자
				tree.setRoot(node);
				tree.insertRight(node, stack.pop());
				tree.insertLeft(node, stack.pop());
				stack.push(tree.getRoot());
			} else { // 숫자
				stack.push(node);
			}
		}
		return tree;
	}

	int evaluateExpressionTree(LinkedTree.TreeNode<E> node) {
		int lvalue = 0;
		int rvalue = 0;
		String operand = "";
		if (node.getLeftNode() != null) { // 단말노드가 아닌 경우=연산자!
			lvalue = evaluateExpressionTree(node.getLeftNode());
			rvalue = evaluateExpressionTree(node.getRightNode());
			operand = (String) node.getNode();
			return getResult(lvalue, rvalue, operand);
		} else {
			return Integer.parseInt(String.valueOf(node.getNode()));
		}
	}

	public int getResult(int a, int b, String c) {
		int result = 0;
		switch (c) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}
		return result;
	}
}
