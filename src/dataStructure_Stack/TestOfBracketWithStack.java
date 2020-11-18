package dataStructure_Stack;

public class TestOfBracketWithStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "[a{b+c-(a*3)}+4]"; // 조건 만족
		System.out.println(checkMatch(expression));
		
		expression = "[a{b+c-(a*3)+4]"; //조건1 위반
		System.out.println(checkMatch(expression));
		
		expression = ")(a+b))"; // 조건2 위반
		System.out.println(checkMatch(expression));
		
		expression = "[a{b+c-(a/2}+1)]"; // 조건3 위반
		System.out.println(checkMatch(expression));
	}
	
	public static boolean checkMatch(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		char[] arr = s.toCharArray(); // char타입의 배열로 바꿔줌!!
//		// 내방법 => if문 사용
//		for(int i = 0 ; i < arr.length ;i++) {
//			if(arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
//				stack.push(arr[i]);				
//			}else if(arr[i] == ')') {
//				if(stack.empty() || stack.pop() != '(') return false; // 닫는 괄호가 먼저 나온 경우 || pop한 값과 짝이 안맞는 경우 return false;
//			}else if(arr[i] == '}') {
//				if(stack.empty() || stack.pop() != '{') return false;
//			} else if(arr[i] == ']') {
//				if(stack.empty()|| stack.pop() != '[') return false;
//			}
//		}
//		
//		if(stack.empty()) {
//			return true;
//		} else {			
//			return false;
//		}
		
		// 선생님 풀이 방법
		boolean valueOfReturn = true;
		
		for(int i = 0 ; i < arr.length ;i++) {
			if(arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
				stack.push(arr[i]);
			else {
				switch(arr[i]) {
				case '}' :
					if(stack.empty() || stack.pop() != '{')
						valueOfReturn = false;
					break;
				case ']' : 
					if(stack.empty() || stack.pop() != '[')
						valueOfReturn = false;
					break;
				case ')' :
					if(stack.empty() || stack.pop() != '(')
						valueOfReturn = false;
					break;
				}
				if(!valueOfReturn) return valueOfReturn; // valueOfReturn값이 false가 되면 바로 함수 끝내주면됨!
			}
		}
		if(!stack.empty())
			valueOfReturn = false;
		return valueOfReturn;
	}
}
