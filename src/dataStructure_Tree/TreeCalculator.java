package dataStructure_Tree;

import java.util.List;

import dataStructure_Stack.Stack;
import dataStructure_Tree.LinkedTree.TreeNode;

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
				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1)) {
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
				}
				stack.push(arr[i]);
			}
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
		int valOfReturn = 0; // 0���� �ʱⰪ�������!!!!!=> (��ȣ�� ������ ���!
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
		Stack<TreeNode> stack = new Stack<TreeNode>();

		for (int i = 0; i < res.length(); i++) {
			TreeNode<Character> node = new TreeNode<Character>(res.charAt(i));
			if (node.getNode() >= '0' && node.getNode() <= '9') { // ����
				stack.push(node);
			} else { // ������
				tree.setRoot(node.getNode().toString());
				tree.insertRight(tree.getRoot(), stack.pop());
				tree.insertLeft(tree.getRoot(), stack.pop());
				stack.push(tree.getRoot());
			}
		}
		return tree;
	}

	int evaluateExpressionTree(TreeNode<E> node) {
		int lvalue = 0;
		int rvalue = 0;
		String operand = "";
		if(node.getLeftNode() != null) { // �ܸ���尡 �ƴ� ���=������!
			lvalue = evaluateExpressionTree(node.getLeftNode());
			rvalue = evaluateExpressionTree(node.getRightNode());
			operand = String.valueOf(node.getNode());
			return getResult(lvalue, rvalue, operand);
		} else {
			return Character.getNumericValue((char) node.getNode());
//			return Integer.parseInt(String.valueOf(node.getNode()));
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
